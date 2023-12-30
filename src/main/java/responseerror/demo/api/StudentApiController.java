package responseerror.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import responseerror.ApiResponse;
import responseerror.demo.domain.dao.Student;
import responseerror.demo.exception.CustomException;
import responseerror.demo.exception.ErrorCode;
import responseerror.demo.exception.data.InputRestriction;
import responseerror.demo.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentApiController extends BaseController {

    private final StudentService studentService;

    @PostMapping("/student/{name}/{grade}")
    public ApiResponse<Student> add(
            @PathVariable("name") String name,
            @PathVariable("grade") int grade
    ) {
        if(grade > 5) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "grade 는 6 이상 입력 할 수 없습니다.", new InputRestriction(6));
        }

        return makeResponse(studentService.addStudent(name, grade));
    }

    @GetMapping("/student/ordered")
    public ApiResponse<Student> getOrdered() {
        return makeResponse(studentService.getOrderedStudents());
    }

    @GetMapping("/student/{grade}")
    public ApiResponse<Student> get(
            @PathVariable("grade") int grade
    ) {
        return makeResponse(studentService.getGradeStudent(grade));
    }
}
