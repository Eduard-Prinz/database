package hwhwPrince.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hwhwPrince.entities.Student;
import hwhwPrince.service.StudentServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return new ResponseEntity<>(new Student(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestParam String name, @RequestParam int age) {
        return new ResponseEntity<>(new Student(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestParam String name, @RequestParam int age) {
        return new ResponseEntity<>(new Student(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable long id) {
        return new ResponseEntity<>("Faculty deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/age/{age}")
    public List<Student> getStudentsByAge(@PathVariable int age) {
        return studentService.getStudentsByAge(age);
    }
}