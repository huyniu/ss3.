package com.example.ss3.repository;

import com.example.ss3.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // Nhớ import Optional

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(1, "Java Backend", "Active", 1));
        courses.add(new Course(2, "Spring Boot", "Active", 2));
    }

    public List<Course> findAll() {
        return courses;
    }

    // 1. Trả về Optional thay vì Course hoặc null
    public Optional<Course> findById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst(); // findFirst() của Stream API mặc định trả về Optional
    }

    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    // 2. Sử dụng orElseThrow để bắt lỗi nếu không tìm thấy
    public Course update(int id, Course course) {
        Course existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Nếu tìm thấy, thực hiện cập nhật
        existing.setTitle(course.getTitle());
        existing.setStatus(course.getStatus());
        existing.setInstructorId(course.getInstructorId());

        return existing;
    }

    // 3. Xóa cũng dùng orElseThrow
    public void deleteById(int id) {
        Course existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        courses.remove(existing);
    }
}