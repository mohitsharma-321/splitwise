package com.company.splitwise.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "EXPENSES")
public class Expense extends BaseModel{
    private String description;
    private int amount; // In paisa

    @ManyToOne    //source to destination -> in this case - multiple expenses and one user
    private User createdBy;

    @ElementCollection    // allows us to store object in database
    private Map<User,Integer> paidBy = new HashMap<>();

    @ElementCollection
    private Map<User,Integer> owedBy = new HashMap<>();
}
