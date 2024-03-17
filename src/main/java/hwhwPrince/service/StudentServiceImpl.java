package hwhwPrince.service;

import org.springframework.beans.factory.annotation.Autowired;
import hwhwPrince.entities.Student;
import hwhwPrince.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student createStudent(String name, int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    @Override
    public void updateStudent(String name, int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByAge(int age) {
        return studentRepository.getByAge(age);
    }
}