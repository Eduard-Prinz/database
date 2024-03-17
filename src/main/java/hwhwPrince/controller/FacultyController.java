package hwhwPrince.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hwhwPrince.entities.Faculty;
import hwhwPrince.service.FacultyServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyServiceImpl facultyService;

    public FacultyController(FacultyServiceImpl facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id) {
        Faculty faculty = facultyService.getFacultyById(id);

        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestParam String name, @RequestParam String color) {
        Faculty faculty = facultyService.createFaculty(name, color);
        return new ResponseEntity<>(faculty, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestParam String name, @RequestParam String color) {
        Faculty faculty = facultyService.updateFaculty(id, name, color);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return new ResponseEntity<>("Faculty deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public List<Faculty> getFacultyByColor(@PathVariable String color) {
        return facultyService.getFacultyByColor(color);
    }
}