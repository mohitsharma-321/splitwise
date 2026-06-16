package com.company.splitwise.dtos;

import jakarta.transaction.Transaction;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class SettleResponseDTO {
    List<Transaction> transactions = new ArrayList<>();
}
