package com.company.splitwise.services;

import com.company.splitwise.dtos.CreateExpenseDTO;
import com.company.splitwise.dtos.ExpenseDTO;
import com.company.splitwise.dtos.ResponseDTO;
import com.company.splitwise.models.Expense;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {

    public ResponseDTO<ExpenseDTO> createExpense(Long userId, CreateExpenseDTO expenseRequest) {
        return null;
    }

    public Optional<Expense> getExpense(Long expenseId) {
        return null;
    }
}
