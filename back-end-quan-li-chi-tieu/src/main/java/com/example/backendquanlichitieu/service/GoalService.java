package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.GoalDTO;
import com.example.backendquanlichitieu.entity.Goal;
import com.example.backendquanlichitieu.repository.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {
    @Autowired
    private GoalRepo goalRepo;
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
}
