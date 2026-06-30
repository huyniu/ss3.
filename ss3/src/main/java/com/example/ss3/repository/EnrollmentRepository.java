package com.example.ss3.repository;

import com.example.ss3.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {
        enrollments.add(new Enrollment(1, "Dinh Quoc Huy", 1));
        enrollments.add(new Enrollment(2, "Nguyen Van C", 2));
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }
}