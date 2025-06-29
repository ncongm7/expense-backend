package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.MoneyJarDTO;
import com.example.backendquanlichitieu.repository.MoneyJarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyJarService {
    @Autowired
    private MoneyJarRepo moneyJarRepo;
    //getAllMoneyJars with MoneyJarDTO
     public List<MoneyJarDTO> getAllMoneyJars(Long userId) {
        return moneyJarRepo.findAllByUserId(userId).stream()
                .map(moneyJar -> {
                    MoneyJarDTO dto = new MoneyJarDTO();
                    dto.setId(moneyJar.getId());
                    dto.setUserId(Long.valueOf(moneyJar.getUser().getId()));
                    dto.setJarName(moneyJar.getJarName());
                    dto.setJarDisplayName(moneyJar.getJarDisplayName());
                    dto.setPercentage(moneyJar.getPercentage());
                    dto.setCreatedAt(moneyJar.getCreatedAt());
                    dto.setUpdatedAt(moneyJar.getUpdatedAt());
                    dto.setColor(moneyJar.getColor());
                    dto.setIcon(moneyJar.getIcon());
                    dto.setDescription(moneyJar.getDescription());
                    dto.setCurrentAmount(moneyJar.getCurrentAmount());
                    dto.setTargetAmount(moneyJar.getTargetAmount());
                    return dto;
                })
                .toList();
     }
     // lay tong quan sumary of money jars
    public MoneyJarDTO getMoneyJarSumary(Long userId) {
        System.out.println("Fetching money jar summary for user ID: " + userId);
         return new MoneyJarDTO(
                 moneyJarRepo.findProgressPercentageByUserId(userId),
                    moneyJarRepo.findTotalTargetAmountByUserId(userId),
                    moneyJarRepo.findTotalCurrentAmountByUserId(userId),
                    moneyJarRepo.findRemainingAmountByUserId(userId)

         );
    }

}
