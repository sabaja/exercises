package com.js.exercises.jpa.manytoone.manytoone;

import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<Student> withId(final Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Student.FIELDS_NAME.ID), id);
    }

    public static Specification<Student> withName(final String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Student.FIELDS_NAME.NAME), name);
    }

    public static Specification<Student> likeName(final String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Student.FIELDS_NAME.NAME), "%" + name + "%");
    }

    public static Specification<Student> joinSchool(final String schoolName) {
        return (root, query, criteriaBuilder) -> {
            final var joinSchoolStudent = root.join(Student.FIELDS_NAME.SCHOOL);
            return criteriaBuilder.equal(joinSchoolStudent.get(School.FIELDS_NAME.NAME), schoolName);
        };
    }
}
