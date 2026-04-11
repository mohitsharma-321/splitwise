package com.company.splitwise.models;

import com.company.splitwise.dtos.CreateUserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends BaseModel{

    private String name;
    private String phoneNo;
    private String hashedPassword;

    public static User from(CreateUserDTO createUserDTO,String hashedPassword) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setPhoneNo(createUserDTO.getPhoneNo());
        createUserDTO.setPassword(hashedPassword);
        return user;
    }
}
