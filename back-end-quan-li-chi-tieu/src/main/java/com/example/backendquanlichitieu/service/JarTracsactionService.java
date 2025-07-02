package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.JarTransactionDTO;
import com.example.backendquanlichitieu.entity.JarTransaction;
import com.example.backendquanlichitieu.repository.JarTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JarTracsactionService {
    @Autowired
    private JarTransactionRepo jarTransactionRepo;
    //getA;llJarTransactions by jarId
    public List<JarTransactionDTO> getAllJarTransactions(Long jarId) {
        return jarTransactionRepo.findAllByJarId(jarId).stream()
                .map(jarTransaction -> {
                    JarTransactionDTO dto = new JarTransactionDTO(
                            jarTransaction.getAmount(),
                            jarTransaction.getTransactionType(),
                            jarTransaction.getCreatedAt()
                    );



                    return dto;
                })
                .toList();
    }
}
