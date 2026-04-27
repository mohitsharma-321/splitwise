package com.company.splitwise.dtos;

import java.util.ArrayList;
import java.util.List;

public class CreateGroupDTO {
    private String name;
    private String admin;
    private List<Long> members = new ArrayList<>();
    private List<CreateExpenseDTO> expenses = new ArrayList<>();
}
