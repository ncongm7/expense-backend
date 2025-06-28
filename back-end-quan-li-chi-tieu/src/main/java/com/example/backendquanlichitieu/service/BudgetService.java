package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.BudgetDTO;
import com.example.backendquanlichitieu.entity.Budget;
import com.example.backendquanlichitieu.repository.BudgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepo budgetRepo;
    //Get All
    public List<BudgetDTO> getAllBudgets(Long id) {
        // Logic to retrieve all budgets
         return (List<BudgetDTO>) budgetRepo.findByUserId(id).stream().map(
                 budget ->  new BudgetDTO(
                         budget.getId(),
                         budget.getCategory().getName(),
                         budget.getAmount(),
                         budget.getAmountSpent(),
                         budget.getStartDate(),
                         budget.getEndDate()
                 )
         ).collect(Collectors.toList());
    }
}
