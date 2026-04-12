package com.example.exceptiondemo.controller;

import com.example.exceptiondemo.exception.StudentNotFoundException;
import com.example.exceptiondemo.exception.InvalidInputException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public String getStudent(@PathVariable String id) {
        if (!id.matches("\\d+")) {
            throw new InvalidInputException("Invalid ID format");
        }
        if (!id.equals("1")) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }
        return "Student Found: ID = " + id;
    }
}