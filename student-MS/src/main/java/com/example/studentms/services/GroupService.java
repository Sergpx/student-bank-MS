package com.example.studentms.services;

import com.example.studentms.models.Group;
import com.example.studentms.models.Student;

import java.util.List;

public interface GroupService {


    public Group createGroup(Group group);

    public List<Group> getStudentsOfGroup(Long id);

    public Group updateGroup(Group group);

    public void deleteGroup(Long id);


}
