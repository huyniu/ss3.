package com.example.ss3.repository;

import com.example.ss3.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(1, "Java Backend", "Active", 1));
        courses.add(new Course(2, "Spring Boot", "Active", 2));
    }

    public List<Course> findAll() { return courses; }

    public Course findById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    public Course update(int id, Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                updatedCourse.setId(id);
                courses.set(i, updatedCourse);
                return updatedCourse;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        return courses.removeIf(c -> c.getId() == id);
    }
}