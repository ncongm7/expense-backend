package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.BudgetDTO;
import com.example.backendquanlichitieu.entity.Budget;
import com.example.backendquanlichitieu.entity.Category;
import com.example.backendquanlichitieu.repository.BudgetRepo;
import com.example.backendquanlichitieu.repository.CategoryRepo;
import com.example.backendquanlichitieu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepo budgetRepo;


    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;


    //Get All
    public List<BudgetDTO> getAllBudgets(Long id) {
        // Logic to retrieve all budgets
        return (List<BudgetDTO>) budgetRepo.findByUserId(id).stream().map(
                budget -> new BudgetDTO(
                        budget.getPeriod(),
                        budget.getId(),
                        budget.getCategory().getName(),
                        budget.getAmount(),
                        budget.getAmountSpent(),
                        budget.getStartDate(),
                        budget.getEndDate()
                )
        ).collect(Collectors.toList());
    }

    //them moi Budget
    public BudgetDTO createBudget(BudgetDTO budgetDTO) {
        Budget budget = new Budget();
        Category category = categoryRepo.findById(budgetDTO.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        budget.setCategory(category);

        budget.setUser(userRepo.findById(budgetDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found")));
        budget.setAmount(budgetDTO.getAmount());

        budget.setStartDate(budgetDTO.getStartDate());
        budget.setEndDate(budgetDTO.getEndDate());
        budget.setPeriod(budgetDTO.getPeriod());
        System.out.println(budget.toString());
        Budget savedBudget = budgetRepo.save(budget);

        return new BudgetDTO(
                savedBudget.getPeriod(),
                savedBudget.getId(),
                savedBudget.getCategory().getName(),
                savedBudget.getAmount(),
                savedBudget.getAmountSpent(),
                savedBudget.getStartDate(),
                savedBudget.getEndDate()
        );

    }

    //delete Budget
    public void deleteBudget(Long id) {
        Budget budget = budgetRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found"));
        budgetRepo.delete(budget);
    }
}
