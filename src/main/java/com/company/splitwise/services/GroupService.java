package com.company.splitwise.services;

import com.company.splitwise.dtos.CreateGroupDTO;
import com.company.splitwise.models.Group;
import com.company.splitwise.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public void createGroup(CreateGroupDTO createGroupRequest) {
        Group group = groupRepository.save(Group.from(createGroupRequest));
    }
}
