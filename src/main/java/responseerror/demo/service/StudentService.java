package responseerror.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import responseerror.demo.domain.dao.Student;
import responseerror.demo.repository.StudentRepository;

import java.sql.Struct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(String name, int grade) {
        Student student = new Student(name, grade);
        studentRepository.save(student);
        return student;
    }

    public List<Student> getOrderedStudents() {
        return studentRepository.findAll().stream()
                .sorted().collect(Collectors.toList());
    }

    public List<Student> getGradeStudent(int grade) {
        return studentRepository.findAll().stream()
                .filter(s -> s.getGrade() == grade)
                .collect(Collectors.toList());
    }
}
