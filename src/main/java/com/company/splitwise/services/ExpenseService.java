package com.company.splitwise.services;

import com.company.splitwise.dtos.CreateExpenseDTO;
import com.company.splitwise.dtos.ExpenseDTO;
import com.company.splitwise.dtos.ResponseDTO;
import com.company.splitwise.exceptions.InvalidUserException;
import com.company.splitwise.models.Expense;
import com.company.splitwise.models.User;
import com.company.splitwise.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExpenseService {

    @Autowired
    UserService userService;

    @Autowired
    ExpenseRepository expenseRepository;

    public Optional<ExpenseDTO> createExpense(Long userId, CreateExpenseDTO expenseRequest) {

        // Checking if user exists
        Optional<User> createdBy = userService.getUser(userId);
        if(createdBy.isEmpty())
            throw new InvalidUserException("Invalid User !!");

        // Validate owedBy and paidBy
        Set<Long> userIds = Stream.of(expenseRequest.getPaidBy().keySet(), expenseRequest.getOwedBy().keySet())
                                  .flatMap(Collection::stream)
                                  .collect(Collectors.toSet());

        boolean areUsersValid = userService.validateIds(userIds);

        if(!areUsersValid){
            throw new InvalidUserException("Invalid User(s) !!");
        }

        //Creating Expense here
        Expense expense = transformExpenseRequest(expenseRequest);

        //Persisting Expense
        Expense persistedExpense = expenseRepository.save(expense);


        return null;        // need to return
    }

    private Expense transformExpenseRequest(CreateExpenseDTO expenseRequest) {
        Map<User,Long> paidBy = transformReferencedUsers(expenseRequest.getPaidBy());
        Map<User,Long> owedBy = transformReferencedUsers(expenseRequest.getOwedBy());
        return Expense.from(expenseRequest,paidBy,owedBy);
    }

    private Map<User, Long> transformReferencedUsers(Map<Long,Long> source) {
        Map<User,Long> target = new HashMap<>();

        for(Map.Entry<Long,Long> id_amount : source.entrySet()) {
            Long id = id_amount.getKey();
            Long amount = id_amount.getValue();

            Optional<User> user = userService.getUser(id);
            target.put(user.get(),amount);
        }
        return target;
    }
    public Optional<Expense> getExpense(Long expenseId) {
        return null;
    }
}
