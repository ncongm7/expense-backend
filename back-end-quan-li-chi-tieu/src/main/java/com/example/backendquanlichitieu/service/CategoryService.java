package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.CategoryDTO;
import com.example.backendquanlichitieu.dto.MoneyJarDTO;
import com.example.backendquanlichitieu.entity.Category;
import com.example.backendquanlichitieu.entity.MoneyJar;
import com.example.backendquanlichitieu.entity.User;
import com.example.backendquanlichitieu.repository.CategoryRepo;
import com.example.backendquanlichitieu.repository.MoneyJarRepo;
import com.example.backendquanlichitieu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MoneyJarRepo moneyJarRepo;


    //getAllCategories
    public List<CategoryDTO> getAllCategories(Long userId) {
        return categoryRepo.findByUserId(userId).stream()
                .map(category -> new CategoryDTO(
                        category.getId(),
                        category.getName(),
                        category.getIcon(),
                        category.getUser().getUsername(),         // userName đúng kiểu String
                        category.getMoneyJar() != null
                                ? new MoneyJarDTO(
                                category.getMoneyJar().getId(),
                                category.getMoneyJar().getColor(),
                                category.getMoneyJar().getShortcode(),           // hoặc shortcode nếu có
                                category.getMoneyJar().getJarDisplayName()
                        )
                                : null       // lấy trực tiếp entity MoneyJar
                ))
                .toList();
    }
    //add method dung Category khong dung CategoryDTO
    public CategoryDTO addCatergory(CategoryDTO category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setIcon(category.getIcon());
        // Gán User (ví dụ userId cố định là 1)
        User user =userRepo.findById(category.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        newCategory.setUser(user);

        // Gán MoneyJar nếu có ID
        if (category.getMoneyJarId() != null) {
            MoneyJar moneyJar = moneyJarRepo.findById(category.getMoneyJarId())
                    .orElseThrow(() -> new RuntimeException("MoneyJar not found"));
            newCategory.setMoneyJar(moneyJar);
        }
        newCategory.setUser(user);

        Category savedCategory = categoryRepo.save(newCategory);

        return new CategoryDTO(
                savedCategory.getId(),
                savedCategory.getName(),
                savedCategory.getIcon(),
                savedCategory.getMoneyJar().getId() ,
                savedCategory.getUser().getUsername()
        );

    }
    //delete method
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
    //getCategory by id



}
