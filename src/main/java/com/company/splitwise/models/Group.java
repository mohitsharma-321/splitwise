package com.company.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "GROUPS")
public class Group extends BaseModel{
    private String name;

    @ManyToMany     // JPA will create mapping for userId and groupId
    private List<User> users = new ArrayList<>();

    @ManyToMany
    private List<User> admins = new ArrayList<>();
}
