package com.example.studentms.services.Impl;

import com.example.studentms.models.Group;
import com.example.studentms.repositories.GroupRepository;
import com.example.studentms.services.StudentService;
import jakarta.ws.rs.NotFoundException;
import com.example.studentms.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.example.studentms.repositories.StudentRepository;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    @Override
    public Student createStudent(Student student, String groupNumber) {
        if (groupRepository.findByGroupNumberIs(groupNumber).isEmpty()) throw new NotFoundException("group not found");
        Group group = groupRepository.findByGroupNumberIs(groupNumber).get(0);
        student.setGroup(group);
        student.setAccountNumber(createBankAccount(student));
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

    private String createBankAccount(Student student){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8084/accounts";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = String.format("{\"firstName\" : \"%s\",\"lastName\" : \"%s\"}",student.getFirstName(),student.getLastName());
        System.out.println("REQ_BODY \n" + requestBody);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        return restTemplate.postForObject(url, request, String.class);
    }

}
