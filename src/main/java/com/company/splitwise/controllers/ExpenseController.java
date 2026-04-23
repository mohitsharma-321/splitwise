package com.company.splitwise.controllers;

import com.company.splitwise.dtos.CreateExpenseDTO;
import com.company.splitwise.dtos.ExpenseDTO;
import com.company.splitwise.dtos.ResponseDTO;
import com.company.splitwise.exceptions.InvalidUserException;
import com.company.splitwise.models.Expense;
import com.company.splitwise.services.ExpenseService;
import com.company.splitwise.utils.ResponseUtils;
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
        try {
            Optional<ExpenseDTO> expenseDTO = expenseService.createExpense(expenseRequest.getUserId(),expenseRequest);
            return ResponseUtils.toResponse(expenseDTO);
        }catch (InvalidUserException e) {
            return ResponseDTO.notFound();
        }

    }

    @GetMapping("/expense/:{expenseId}")
    public ResponseDTO<ExpenseDTO> getExpense(@PathVariable Long expenseId) {
        Optional<Expense> expense = expenseService.getExpense(expenseId);
        return ResponseUtils.toResponse(expense.map(ExpenseDTO::from));
    }
}
