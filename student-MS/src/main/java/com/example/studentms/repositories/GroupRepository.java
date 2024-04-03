package com.example.studentms.repositories;

import com.example.studentms.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findByGroupNumberIs(String groupNumber);

}
