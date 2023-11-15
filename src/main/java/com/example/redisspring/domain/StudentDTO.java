package com.example.redisspring.domain;

public record StudentDTO(String name, Student.Gender gender, int grade) {
}
