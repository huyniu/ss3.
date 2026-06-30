package com.example.ss3.repository;

import com.example.ss3.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    private List<Instructor> instructors = new ArrayList<>();

    public InstructorRepository() {
        instructors.add(new Instructor(1, "Nguyen Van A", "nva@rikkei.edu.vn"));
        instructors.add(new Instructor(2, "Tran Thi B", "ttb@rikkei.edu.vn"));
    }

    public List<Instructor> findAll() {
        return instructors;
    }
}