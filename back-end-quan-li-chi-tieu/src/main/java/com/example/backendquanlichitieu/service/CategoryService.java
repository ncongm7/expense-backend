package com.example.backendquanlichitieu.service;

import com.example.backendquanlichitieu.dto.CategoryDTO;
import com.example.backendquanlichitieu.entity.Category;
import com.example.backendquanlichitieu.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    //getAllCategories
    public List<CategoryDTO> getAllCategories() {
        return categoryRepo.findAll().stream()
                .map(category -> new CategoryDTO(
                        category.getId(),
                        category.getName(),
                        category.getIcon(),
                        category.getUser().getUsername(
                        )))
                .toList();
    }
    //add method dung Category khong dung CategoryDTO
    public Category addCatergory(Category category) {
        return categoryRepo.save(category);
    }


}
