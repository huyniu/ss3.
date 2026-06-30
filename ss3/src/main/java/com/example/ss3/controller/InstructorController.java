package com.example.ss3.controller;

import com.example.ss3.dto.ApiResponse; // Nhớ import ApiResponse vừa tạo
import com.example.ss3.model.Instructor;
import com.example.ss3.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAll() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        // Bọc dữ liệu vào ApiResponse
        ApiResponse<List<Instructor>> response = new ApiResponse<>(true, "Fetched instructors successfully", instructors);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getById(@PathVariable int id) {
        Instructor instructor = instructorService.getInstructorById(id);
        if (instructor != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Instructor found", instructor);
            return ResponseEntity.ok(response);
        }
        ApiResponse<Instructor> response = new ApiResponse<>(false, "Instructor not found", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> create(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);
        ApiResponse<Instructor> response = new ApiResponse<>(true, "Instructor created successfully", createdInstructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> update(@PathVariable int id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
        if (updatedInstructor != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Instructor updated successfully", updatedInstructor);
            return ResponseEntity.ok(response);
        }
        ApiResponse<Instructor> response = new ApiResponse<>(false, "Instructor not found to update", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> delete(@PathVariable int id) {
        Instructor deletedInstructor = instructorService.deleteInstructorById(id);
        if (deletedInstructor != null) {
            ApiResponse<Instructor> response = new ApiResponse<>(true, "Instructor deleted successfully", deletedInstructor);
            return ResponseEntity.ok(response);
        }
        ApiResponse<Instructor> response = new ApiResponse<>(false, "Instructor not found to delete", null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}