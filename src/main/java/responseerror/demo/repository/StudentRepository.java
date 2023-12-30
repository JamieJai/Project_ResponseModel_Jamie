package responseerror.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import responseerror.demo.domain.dao.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
