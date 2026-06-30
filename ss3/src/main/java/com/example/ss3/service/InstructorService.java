package com.example.ss3.service;

import com.example.ss3.model.Instructor;
import com.example.ss3.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.create(instructor);
    }

    public Instructor updateInstructor(int id, Instructor instructor) {
        return instructorRepository.update(id, instructor);
    }

    public Instructor deleteInstructorById(int id) {
        // Lấy thông tin bản ghi trước khi xóa để trả về cho Controller
        Instructor existingInstructor = instructorRepository.findById(id);
        if (existingInstructor != null) {
            instructorRepository.deleteById(id);
            return existingInstructor; // Trả về bản ghi bị xóa theo yêu cầu
        }
        return null;
    }
}