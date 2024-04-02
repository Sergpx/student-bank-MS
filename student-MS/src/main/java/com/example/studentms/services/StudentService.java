package com.example.studentms.services;

import com.example.studentms.models.Student;


public interface StudentService{

    public Student createStudent(Student student);

    public Student getStudent(Long id);

    public Student updateStudent(Student student);

    public void deleteStudent(Long id);
}
