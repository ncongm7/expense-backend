package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/budgets/")
@RestController
public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    //getAllBudgets
    @GetMapping("hien-thi")
    public Object getAllBudgets() {
        return budgetService.getAllBudgets();
    }
}
