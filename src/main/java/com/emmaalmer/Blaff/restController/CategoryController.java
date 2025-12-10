package com.emmaalmer.Blaff.restController;

import com.emmaalmer.Blaff.repository.CategoryRepository;
import com.emmaalmer.Blaff.repository.WordRepository;
import com.emmaalmer.Blaff.entity.Category;
import com.emmaalmer.Blaff.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final WordRepository  wordRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, WordRepository wordRepository){
        this.categoryRepository = categoryRepository;
        this.wordRepository = wordRepository;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{category}/randomWord")
    public Word getRandomWord(@PathVariable String category) {

        List <Word> wordList = wordRepository.findByCategoryName(category);

        if (wordList.isEmpty()) {
            throw new RuntimeException("The categpry: " + category + ",  has no words");
        }

        Random random = new Random();
        Word randomWord = wordList.get(random.nextInt(wordList.size()));

        return randomWord;
    }
}
