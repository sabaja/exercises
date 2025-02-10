package com.js.exercises.manytoone;

import org.springframework.data.jpa.domain.Specification;

public class SchoolSpecification {

    public static Specification<School> withId(final Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(School.FIELDS_NAME.ID), id);
    }

    public static Specification<School> withName(final String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(School.FIELDS_NAME.NAME), name);
    }

    public static Specification<School> likeName(final String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(School.FIELDS_NAME.NAME), "%" + name + "%");
    }
}
