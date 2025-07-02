package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.JarTransactionDTO;
import com.example.backendquanlichitieu.service.JarTracsactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions/jars/")
public class JarTransactionController {
    @Autowired
    private JarTracsactionService jarTracsactionService;
    @GetMapping("hien-thi/{jarId}")
    public List<JarTransactionDTO> getAllJarTransactions(@PathVariable Long jarId) {
        // Logic to retrieve all jar transactions for a specific jar
        return jarTracsactionService.getAllJarTransactions(jarId);
    }
}
