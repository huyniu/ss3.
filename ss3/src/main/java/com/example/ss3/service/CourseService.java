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

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Gọi findById của Repo và ném ngoại lệ nếu không có dữ liệu
    public Course getCourseById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course createCourse(Course course) {
        return courseRepository.create(course);
    }

    // Hàm update ở Repo đã tự xử lý lỗi, nên ta chỉ cần gọi trực tiếp
    public Course updateCourse(int id, Course course) {
        return courseRepository.update(id, course);
    }

    // Hàm delete ở Repo cũng tự xử lý lỗi
    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }
}