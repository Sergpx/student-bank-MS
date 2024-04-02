package com.example.studentms.services.Impl;

import com.example.studentms.services.StudentService;
import jakarta.ws.rs.NotFoundException;
import com.example.studentms.models.Student;
import org.springframework.stereotype.Service;
import com.example.studentms.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found"));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
