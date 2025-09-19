package com.js.exercises;

import com.js.exercises.jpa.manytoone.manytoone.School;
import com.js.exercises.jpa.manytoone.manytoone.Student;
import com.js.exercises.jpa.manytoone.manytoone.StudentRepository;
import com.js.exercises.jpa.manytoone.manytoone.StudentSpecification;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
@SpringBootApplication
public class ExercisesApplication {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ExercisesApplication.class);
    private final StudentRepository studentRepository;

    @PersistenceContext
    public EntityManager entityManager;

    @Value("${isInit}")
    private boolean isInit;

    public static void main(String[] args) {
        SpringApplication.run(ExercisesApplication.class, args);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(JPQLTemplates.DEFAULT, entityManager);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            if (isInit) {
                initData(studentRepository);
            }

        };
    }

    private void initData(StudentRepository studentRepository) {
        final var student = new Student();
        final var school = new School();
        student.setName("Gaia Sabatini");
        school.setName("ICS Padre Puglisi - Laura Conti");

        student.setSchool(school);
        final var save = studentRepository.save(student);
        log.info("save: {}", studentRepository.findById(save.getId()).orElseGet(() -> null));

        final var jpaQueryFactory = jpaQueryFactory();
//        QStudent qStudent = QStudent.student;
//
//        final var res = jpaQueryFactory.selectFrom(qStudent)
//                .where(qStudent.name.like("Jacopo%"))
//                .fetchOne();
//            log.info("res: {}", res);

        Specification<Student> specification = StudentSpecification.joinSchool("HighSchool")
                .and(StudentSpecification.likeName("Jacopo"));

        final var jacopo = studentRepository.findAll(specification);
        log.info("Specification con Jacopo: {}", jacopo);

        final var all = studentRepository.findAll();
        log.info("Tutti: {}", all);
    }
}
