package com.company.splitwise.controllers;

import com.company.splitwise.dtos.CreateExpenseDTO;
import com.company.splitwise.dtos.ExpenseDTO;
import com.company.splitwise.dtos.ResponseDTO;
import com.company.splitwise.models.Expense;
import com.company.splitwise.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping("/expense")
    public ResponseDTO<ExpenseDTO> createExpense(@RequestBody CreateExpenseDTO expenseRequest) {
        return expenseService.createExpense(expenseRequest.getUserId(),expenseRequest);
    }

    @GetMapping("/expense/:{expenseId}")
    public ResponseDTO<ExpenseDTO> getExpense(@PathVariable Long expenseId) {
        Optional<Expense>expense = expenseService.getExpense(expenseId);
        Optional<ExpenseDTO> expenseDTO = expense.map(ExpenseDTO::from);
        return expenseDTO.map(ResponseDTO::success).orElse(ResponseDTO.notFound());
    }
}
