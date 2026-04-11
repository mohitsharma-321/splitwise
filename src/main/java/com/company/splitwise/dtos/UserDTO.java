package com.company.splitwise.dtos;

import com.company.splitwise.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long userId;
    private String name;
    private String phoneNo;

    public static UserDTO from(User user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setPhoneNo(user.getPhoneNo());
//        return userDTO;


        // Using Builder DP

        return UserDTO.builder().userId(user.getId()).name(user.getName()).phoneNo(user.getPhoneNo()).build();
    }
}
