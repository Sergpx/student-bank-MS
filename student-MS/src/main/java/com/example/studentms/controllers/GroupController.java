package com.example.studentms.controllers;

import com.example.studentms.models.Group;
import com.example.studentms.services.Impl.GroupServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupServiceImpl groupService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Group createGroup(@RequestBody Group group){
        return groupService.createGroup(group);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getStudentsOfGroup(@PathVariable Long id){
        return groupService.getStudentsOfGroup(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Group updateGroup(@RequestBody Group group){
        return groupService.updateGroup(group);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGroup(@PathVariable Long id){
        groupService.deleteGroup(id);
    }



}
