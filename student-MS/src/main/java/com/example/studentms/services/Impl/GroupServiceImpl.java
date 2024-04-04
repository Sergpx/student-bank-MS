package com.example.studentms.services.Impl;

import com.example.studentms.models.Group;
import com.example.studentms.repositories.GroupRepository;
import com.example.studentms.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> getStudentsOfGroup(Long id) {
        return groupRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
