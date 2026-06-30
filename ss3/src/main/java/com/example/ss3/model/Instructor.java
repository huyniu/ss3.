package com.example.ss3.model;

public class Instructor {
    private int id;
    private String name;
    private String email;

    // Constructor không tham số (Bắt buộc phải có để Spring Boot đọc/ghi JSON)
    public Instructor() {
    }

    // Constructor đầy đủ tham số
    public Instructor(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // --- BẮT ĐẦU PHẦN GETTER & SETTER ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}