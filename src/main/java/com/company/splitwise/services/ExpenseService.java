package com.company.splitwise.services;

import com.company.splitwise.dtos.CreateExpenseDTO;
import com.company.splitwise.dtos.ExpenseDTO;
import com.company.splitwise.dtos.ResponseDTO;
import com.company.splitwise.exceptions.InvalidUserException;
import com.company.splitwise.models.Expense;
import com.company.splitwise.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExpenseService {

    @Autowired
    UserService userService;

    public Optional<ExpenseDTO> createExpense(Long userId, CreateExpenseDTO expenseRequest) {

        // Checking if user exists
        Optional<User> createdBy = userService.getUser(userId);
        if(createdBy.isEmpty())
            throw new InvalidUserException("Invalid User !!");

        // Validate owedBy and paidBy
        Set<Long> userIds = Stream.of(expenseRequest.getPaidBy().keySet(), expenseRequest.getOwedBy().keySet())
                                  .flatMap(Collection::stream)
                                  .collect(Collectors.toSet());
        if(!userIds){
            throw new InvalidUserException("Invalid User !!");
        }

        return null;
    }

    public Optional<Expense> getExpense(Long expenseId) {
        return null;
    }
}
