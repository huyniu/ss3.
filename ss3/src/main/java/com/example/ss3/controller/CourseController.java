package com.example.ss3.controller;

import com.example.ss3.dto.ApiResponse;
import com.example.ss3.model.Course;
import com.example.ss3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched courses successfully", courseService.getAllCourses()));
    }

    // ÁP DỤNG TRY-CATCH CHO CÁC ENDPOINT CÓ TÌM KIẾM THEO ID

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Fetched Successfully", courseService.getCourseById(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> create(@RequestBody Course course) {
        return ResponseEntity.status(201).body(new ApiResponse<>(true, "Created Successfully", courseService.createCourse(course)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> update(@PathVariable int id, @RequestBody Course course) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(true, "Course updated", courseService.updateCourse(id, course)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id) {
        try {
            courseService.deleteCourseById(id);
            return ResponseEntity.ok(new ApiResponse<>(true, "Course deleted successfully", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }
    }
}