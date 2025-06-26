package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.ExpensDTO;
import com.example.backendquanlichitieu.entity.Expens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backendquanlichitieu.service.ExpensesService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class ExpensController {
    @Autowired
    private ExpensesService expensesService;
    @GetMapping("hien-thi")
    public List<ExpensDTO> getFilteredExpenses(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            @RequestParam(required = false) String search
    ) {

        return expensesService.getFilteredExpenses(type, categoryId, fromDate, toDate, search);
    }


    //method THEM
    @PostMapping(value = "/post", consumes = "multipart/form-data")
    public ResponseEntity<String> createExpense(
            @RequestParam String type,
            @RequestParam Double amount,
            @RequestParam Long categoryId,
            @RequestParam String notes,
            @RequestParam String spentAt,
            @RequestParam Long userId,
            @RequestParam(required = false) MultipartFile receipt
    ) {
        try {
            expensesService.saveExpense(type, amount, categoryId, notes, spentAt, userId, receipt);
            return ResponseEntity.ok("Thêm giao dịch thành công!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi lưu giao dịch!");
        }
    }



}