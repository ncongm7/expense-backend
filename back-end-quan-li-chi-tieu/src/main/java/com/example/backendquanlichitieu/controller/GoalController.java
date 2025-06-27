package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.GoalDTO;
import com.example.backendquanlichitieu.entity.Goal;
import com.example.backendquanlichitieu.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals/")
public class GoalController {
    //getAllGoals
    //getGoalById
    //addGoal
    //updateGoal
    //deleteGoal
    @Autowired
    private GoalService goalService;

    @RequestMapping("hien-thi/{id}")
    public List<GoalDTO> getAllGoals(@PathVariable Long id) {
     return    goalService.getAllGoals(id);
    }
    //deleteGoal method
    @DeleteMapping("delete/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);

    }

}
