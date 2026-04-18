package com.company.splitwise.controllers;

import com.company.splitwise.dtos.CreateExpenseDTO;
import com.company.splitwise.dtos.ExpenseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExpenseController {

    @PostMapping("/expense")
    public ExpenseDTO createExpense(@RequestBody CreateExpenseDTO expenseRequest) {


    }

    @GetMapping("/expense/:{expenseId}")
    public void getExpense() {

    }
}
