package com.example.ss3.model;


public class Enrollment {
    private int id;
    private String studentName;
    private int courseId; // Thể hiện quan hệ 1-n: 1 Khóa học có nhiều Lượt đăng ký

    public Enrollment(int id, String studentName, int courseId) {
        this.id = id;
        this.studentName = studentName;
        this.courseId = courseId;
    }
    // TODO: Generate Getters và Setters
}