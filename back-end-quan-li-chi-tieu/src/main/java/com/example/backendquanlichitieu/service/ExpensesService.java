package com.example.backendquanlichitieu.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.backendquanlichitieu.dto.ExpensDTO;
import com.example.backendquanlichitieu.entity.Category;
import com.example.backendquanlichitieu.entity.User;
import com.example.backendquanlichitieu.repository.CategoryRepo;
import com.example.backendquanlichitieu.repository.ExpensRepo;
import com.example.backendquanlichitieu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendquanlichitieu.entity.Expens;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ExpensesService {
    @Autowired
    private ExpensRepo expensRepo;

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private CategoryRepo categoryRepo;
    public List<ExpensDTO> getAllExpenses() {
        List<Expens> expenses = expensRepo.findAll();
        return expenses.stream()
                .map(expens -> new ExpensDTO(
                        expens.getId(),
                        expens.getUser().getUsername(),
                        expens.getCategory().getName(),
                        expens.getType(),
                        expens.getAmount(),
                        expens.getNote(),
                        expens.getSpentAt()))
                .toList();

    }
    //loc theo cac thuoc tinh trong ExpensDTO

    public List<ExpensDTO> getFilteredExpenses(String type, Long categoryId, String fromDate, String toDate, String search) {
        // Giả sử bạn có JPA hoặc tự lọc trong list

        List<Expens> all = expensRepo.findAll();

        return all.stream()
                .filter(e -> type == null || e.getType().equals(type))
                .filter(e -> categoryId == null || (e.getCategory() != null && Objects.equals(e.getCategory().getId().longValue(), categoryId)))

                .filter(e -> fromDate == null || !e.getSpentAt().isBefore(LocalDate.parse(fromDate)))
                .filter(e -> toDate == null || !e.getSpentAt().isAfter(LocalDate.parse(toDate)))
                .filter(e -> search == null || e.getNote().toLowerCase().contains(search.toLowerCase()))
                .map(e -> new ExpensDTO(
                        e.getId(),
                        e.getUser().getUsername(),
                        e.getCategory().getName(),
                        e.getType(),
                        e.getAmount(),
                        e.getNote(),
                        e.getSpentAt(),
                        e.getCategory().getId()))

                .collect(Collectors.toList());
    }

    public void saveExpense(String type, Double amount, Long categoryId, String notes, String spentAt, Long userId, MultipartFile receipt) throws IOException {
        Expens expens = new Expens();

        expens.setType(type);
        expens.setAmount(BigDecimal.valueOf(amount));
        expens.setNote(notes);
        expens.setSpentAt(LocalDate.parse(spentAt));

        // Lấy user và category từ DB
        User user =userRepo .findById(userId).orElseThrow(() -> new RuntimeException("Không tìm thấy user"));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Không tìm thấy category"));

        expens.setUser(user);
        expens.setCategory(category);

        // Nếu có file ảnh thì lưu vào thư mục server
        if (receipt != null && !receipt.isEmpty()) {
            String uploadDir = "uploads/";
            String fileName = UUID.randomUUID() + "_" + receipt.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, receipt.getBytes());

//            expens.setReceiptPath(filePath.toString()); // giả sử bạn có field này
        }

        expensRepo.save(expens);
    }






}