package com.example.studentms.controllers;

import com.example.studentms.models.Student;
import com.example.studentms.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping( "/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudent(id);
    }


    @PostMapping("/{groupNumber}")
    Student createStudent(@RequestBody Student student, @PathVariable String groupNumber){
        System.out.println(student);
        System.out.println(groupNumber);
        return studentService.createStudent(student, groupNumber);
    }

}
