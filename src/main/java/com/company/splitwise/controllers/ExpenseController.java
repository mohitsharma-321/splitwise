package com.company.splitwise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExpenseController {

    @PostMapping("/expense")
    public void createExpense() {

    }

    @GetMapping("/expense/:{expenseId}")
    public void getExpense() {

    }
}
