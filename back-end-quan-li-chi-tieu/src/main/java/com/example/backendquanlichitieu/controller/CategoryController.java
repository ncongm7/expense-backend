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
    @GetMapping("hien-thi")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @PostMapping("them")
    //add method dung Category khong dung CategoryDTO

    public ResponseEntity<?> themDanhMuc(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.addCatergory(category));
    }
}
