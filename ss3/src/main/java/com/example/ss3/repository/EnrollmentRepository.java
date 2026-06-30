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

    public List<Enrollment> findAll() { return enrollments; }

    public Enrollment findById(int id) {
        return enrollments.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(int id, Enrollment updatedEnrollment) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getId() == id) {
                updatedEnrollment.setId(id);
                enrollments.set(i, updatedEnrollment);
                return updatedEnrollment;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        return enrollments.removeIf(e -> e.getId() == id);
    }
}