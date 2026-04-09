package com.company.splitwise.dtos;

import lombok.Data;

@Data
public class CreateUserDTO {

    private String name;
    private String password;
    private String phoneNo;

}
// POST request mein server apne aap id bnake bhejta hai, so we don't need userId here.