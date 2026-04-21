package com.company.splitwise.models;

import com.company.splitwise.dtos.CreateExpenseDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "EXPENSES")
public class Expense extends BaseModel{
    private String description;
    private long amount; // In paisa

    @ManyToOne    //source (classname{Expense}) to destination (Field Type {User}) -> in this case - multiple expenses and one user
    private User createdBy;

    @ElementCollection    // allows us to store object in database
    private Map<User,Integer> paidBy = new HashMap<>();

    @ElementCollection
    private Map<User,Integer> owedBy = new HashMap<>();

    public static Expense from(CreateExpenseDTO expenseRequest, Map<User,Long> paidBy,Map<User,Long> owedBy) {
        return null;
    }
}
