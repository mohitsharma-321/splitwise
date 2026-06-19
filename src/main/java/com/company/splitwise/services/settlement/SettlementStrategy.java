package com.company.splitwise.services.settlement;

import com.company.splitwise.models.Expense;
import com.company.splitwise.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface SettlementStrategy {
    List<Transaction> settleExpenses(List<Expense> expenses);
}
