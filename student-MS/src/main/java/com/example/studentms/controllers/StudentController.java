package com.example.studentms.controllers;

import com.example.studentms.models.Student;
import com.example.studentms.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping( "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudent(id);
    }


    @PostMapping("/{groupNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student, @PathVariable String groupNumber){
        System.out.println(student);
        System.out.println(groupNumber);
        return studentService.createStudent(student, groupNumber);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
