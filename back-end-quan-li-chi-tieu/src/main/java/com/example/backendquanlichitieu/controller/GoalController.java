package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.GoalDTO;
import com.example.backendquanlichitieu.entity.Goal;
import com.example.backendquanlichitieu.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    //add method
    @PostMapping("/add")
    public ResponseEntity<?> addGoal(@RequestBody GoalDTO goalDto) {
        try {
            Goal savedGoal = goalService.addGoal(goalDto);
            return ResponseEntity.ok(savedGoal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi thêm mục tiêu: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGoal(@PathVariable Long id, @RequestBody GoalDTO goalDto) {
        try {
            Goal updatedGoal = goalService.updateGoal(id, goalDto);
            return ResponseEntity.ok(updatedGoal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi cập nhật mục tiêu: " + e.getMessage());
        }
    }
}
