package hwhwPrince.service;

import hwhwPrince.entities.Student;

import java.util.Collection;

public interface StudentService {

    public Student getStudentById(long id);
    public Student createStudent(String name, int age);
    public void updateStudent(String name, int age);

    void updateStudent(long id, String name, int age);

    public void deleteStudent(long id);

}