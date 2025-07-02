package com.example.backendquanlichitieu.controller;

import com.example.backendquanlichitieu.dto.CategoryDTO;
import com.example.backendquanlichitieu.entity.Category;
import com.example.backendquanlichitieu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories/")
public class CategoryController {
    //getAllCategories
    @Autowired
    private CategoryService categoryService;
    @GetMapping("hien-thi/{id}")
    public List<CategoryDTO> getAllCategories(@PathVariable Long id) {
        return categoryService.getAllCategories(id);
    }

    ///add method dung Category khong dung CategoryDTO
    @PostMapping("add")

    public ResponseEntity<?> themDanhMuc(@RequestBody CategoryDTO category) {
        System.out.println("Received category: " + category);
        return ResponseEntity.ok(categoryService.addCatergory(category));
    }
}
