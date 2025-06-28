package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.BudgetDTO;
import com.example.backendquanlichitieu.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/budgets/")
@RestController
public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    //getAllBudgets
    @GetMapping("hien-thi/{id}")
    public Object getAllBudgets(@PathVariable Long id) {
        // Logic to retrieve all budgets
        return budgetService.getAllBudgets(id);
    }
    //post
    @PostMapping("add")
    public  Object createBudget(@RequestBody BudgetDTO budgetDTO) {
        // Logic to create a new budget
        return budgetService.createBudget(budgetDTO);
    }
    //delete
    @DeleteMapping("delete/{id}")
    public void deleteBudget(@PathVariable Long id) {
        // Logic to delete a budget by ID
         budgetService.deleteBudget(id);
    }
}
