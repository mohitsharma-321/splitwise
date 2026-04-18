package com.company.splitwise.dtos;

import lombok.Data;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

@Data
public class CreateExpenseDTO {
    private Long userId;
    private String description;
    private int amount;
    private Currency currency;
    private Map<Long,Long> paidBy = new HashMap<>();
    private Map<Long,Long> owedBy = new HashMap<>();


}
