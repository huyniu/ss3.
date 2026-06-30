package com.example.ss3.repository;

import com.example.ss3.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        // Chuẩn bị dữ liệu mock, chú ý instructorId
        courses.add(new Course(1, "Java Backend", "Active", 1));
        courses.add(new Course(2, "Spring Boot", "Active", 2));
    }

    public List<Course> findAll() {
        return courses;
    }
}