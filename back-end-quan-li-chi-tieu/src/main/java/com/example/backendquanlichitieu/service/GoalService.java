package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.GoalDTO;
import com.example.backendquanlichitieu.entity.Goal;
import com.example.backendquanlichitieu.entity.User;
import com.example.backendquanlichitieu.repository.GoalRepo;
import com.example.backendquanlichitieu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {
    @Autowired
    private GoalRepo goalRepo;

    @Autowired
    private UserRepo userRepo;
    //getAllGoals
    //getGoalById
    public List<GoalDTO> getAllGoals(Long userId) {
        return goalRepo.findAllByUserId(userId).stream()
                .map( goal -> new GoalDTO(
                        goal.getId(),
                        goal.getUser().getId(),
                        goal.getTitle(),
                        goal.getTargetAmount(),
                        goal.getCurrentAmount(),
                        goal.getDeadline(),
                        goal.getNote(),
                        goal.getCreatedAt(),
                        goal.getUrlImage()
                )).collect(Collectors.toList());
    }

    //deleteGoal method
    public void deleteGoal(Long id) {
        goalRepo.deleteById(id);
    }

    //add method
    public Goal addGoal(GoalDTO dto) {
        User user = userRepo.findById(Long.valueOf(dto.getUserId()))
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user"));

        Goal goal = new Goal();
        goal.setTitle(dto.getTitle());

        goal.setTargetAmount(dto.getTargetAmount());
        goal.setCurrentAmount(dto.getCurrentAmount());
        goal.setUrlImage(dto.getUrlImage());
        goal.setDeadline(dto.getDeadline());
        goal.setDeadline(dto.getDeadline());
        goal.setCreatedAt(dto.getCreatedAt());
        goal.setUser(user); // 👈 gán quan hệ

     return    goalRepo.save(goal);
    }

    //upateGoal method
    public Goal updateGoal(Long id, GoalDTO dto) {
        User user = userRepo.findById(Long.valueOf(dto.getUserId()))
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user"));
        Goal goal = goalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy mục tiêu với ID: " + id));

        goal.setTitle(dto.getTitle());
        goal.setTargetAmount(dto.getTargetAmount());
        goal.setCurrentAmount(dto.getCurrentAmount());
        goal.setUrlImage(dto.getUrlImage());
        goal.setDeadline(dto.getDeadline());
        goal.setNote(dto.getNote());
        goal.setCreatedAt(dto.getCreatedAt());
        goal.setUser(user); // 👈 gán quan hệ
        return goalRepo.save(goal);
    }
}
