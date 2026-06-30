package com.example.ss3.service;

import com.example.ss3.model.Course;
import com.example.ss3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() { return courseRepository.findAll(); }

    public Course getCourseById(int id) { return courseRepository.findById(id); }

    public Course createCourse(Course course) { return courseRepository.create(course); }

    public Course updateCourse(int id, Course course) { return courseRepository.update(id, course); }

    public Course deleteCourseById(int id) {
        Course existingCourse = courseRepository.findById(id);
        if (existingCourse != null) {
            courseRepository.deleteById(id);
            return existingCourse;
        }
        return null;
    }
}