package com.emmaalmer.Blaff.restController;

import com.emmaalmer.Blaff.repository.CategoryRepository;
import com.emmaalmer.Blaff.entity.Category;
import com.emmaalmer.Blaff.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final WordService wordService;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, WordService wordService){
        this.categoryRepository = categoryRepository;
        this.wordService = wordService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/category/create")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryRepository.save(category);
        return ResponseEntity.status(201).body(category.getName());
    }
}
