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

    // 1. Lấy toàn bộ
    public List<Instructor> findAll() {
        return instructors;
    }

    // 2. Tìm theo ID
    public Instructor findById(int id) {
        return instructors.stream()
                .filter(instructor -> instructor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // 3. Thêm mới
    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    // 4. Cập nhật
    public Instructor update(int id, Instructor updatedInstructor) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId() == id) {
                // Giữ nguyên ID cũ, cập nhật thông tin mới
                updatedInstructor.setId(id);
                instructors.set(i, updatedInstructor);
                return updatedInstructor;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    // 5. Xóa theo ID
    public boolean deleteById(int id) {
        return instructors.removeIf(instructor -> instructor.getId() == id);
    }
}