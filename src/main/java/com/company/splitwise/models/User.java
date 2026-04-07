package com.company.splitwise.models;

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
    private String email;
    private String phoneNo;
    private String hashedPassword;
}
