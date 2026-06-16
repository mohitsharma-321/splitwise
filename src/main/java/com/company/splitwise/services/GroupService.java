package com.company.splitwise.services;

import com.company.splitwise.dtos.CreateGroupDTO;
import com.company.splitwise.dtos.GroupDTO;
import com.company.splitwise.dtos.SettleResponseDTO;
import com.company.splitwise.models.Expense;
import com.company.splitwise.models.Group;
import com.company.splitwise.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public GroupDTO createGroup(CreateGroupDTO createGroupRequest) {
        Group group = groupRepository.save(Group.from(createGroupRequest));
        return GroupDTO.from(group);
    }

    public Optional<Group> getGroup(Long groupId) {
        return groupRepository.findById(groupId);
    }

    public Optional<SettleResponseDTO> settleExpenses(Long groupId) {
        Optional<Group> group = getGroup(groupId);
        if (group.isEmpty()) {
            return Optional.empty();
        }

        // Strategy logic left
        return null;
        }

}
