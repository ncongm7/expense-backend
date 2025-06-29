package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.MoneyJarDTO;
import com.example.backendquanlichitieu.service.MoneyJarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/money-jars/")
public class MoneyJarController {
    @Autowired
    private MoneyJarService moneyJarService;

    //getAllMoneyJars
    @GetMapping("hien-thi/{userId}")
    public List<MoneyJarDTO> getAllMoneyJars(@PathVariable Long userId) {
        // Logic to retrieve all money jars for a user
        return moneyJarService.getAllMoneyJars(userId);
    }

    //getMoneyJarSumary
    @GetMapping("summary/{userId}")
    public MoneyJarDTO getMoneyJarSumary(@PathVariable Long userId) {
        // Logic to retrieve the summary of money jars for a user
        return moneyJarService.getMoneyJarSumary(userId);
    }
    //
}

