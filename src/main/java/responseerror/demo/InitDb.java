package responseerror.demo;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import responseerror.demo.domain.dao.Student;

@Component
public class InitDb {

    private final InitService initService;

    public InitDb(InitService initService) {
        this.initService = initService;
    }

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    public static class InitService {

        private final EntityManager em;

        public void dbInit() {
            Student student1 = createStudent("kim", 1);
            em.persist(student1);
            Student student2 = createStudent("Lee", 2);
            em.persist(student2);
            Student student3 = createStudent("Park", 3);
            em.persist(student3);
            Student student4 = createStudent("Choi", 2);
            em.persist(student4);
        }

        private Student createStudent(String name, int grade) {
            return new Student(name, grade);
        }
    }
}
