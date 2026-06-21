package com.company.splitwise.services.settlement;

import com.company.splitwise.models.Expense;
import com.company.splitwise.models.Transaction;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class GreedySettlementStrategy implements SettlementStrategy{
    @Override
    public List<Transaction> settleExpenses(List<Expense> expenses) {
        Map<Long, Long> initialState = prepareInitialState(expenses);
        TreeSet<Pair<Long, Long>> expenseTree = new TreeSet<>((left, right) -> (int) (left.getFirst() - right.getFirst()));
        for (Map.Entry<Long, Long> entry : initialState.entrySet()) {
            expenseTree.add(Pair.of(entry.getValue(), entry.getKey()));
        }

        List<Transaction> transactions = new ArrayList<>();

        while (expenseTree.size() > 1) {
            Pair<Long, Long> smallestPair = expenseTree.first();
            Pair<Long, Long> largestPair = expenseTree.last();

            Transaction transaction = new Transaction();
            transaction.setFromId(largestPair.getSecond());
            transaction.setToId(smallestPair.getSecond());
            transaction.setAmount(largestPair.getFirst());

            expenseTree.remove(largestPair);
            expenseTree.remove(smallestPair);

            expenseTree.add(Pair.of(smallestPair.getFirst() + largestPair.getFirst(), smallestPair.getSecond()));
            transactions.add(transaction);
        }

        return transactions;
    }
}
