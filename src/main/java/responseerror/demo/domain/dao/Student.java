package responseerror.demo.domain.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "students")
@Getter
public class Student implements Comparable<Student> {

    @Id
    private String name;

    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student(){
    }

    @Override
    public int compareTo(Student student) {
        return this.grade - student.getGrade();
    }
}
