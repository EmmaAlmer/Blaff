package com.emmaalmer.Blaff.restController;

import com.emmaalmer.Blaff.entity.Category;
import com.emmaalmer.Blaff.entity.Word;
import com.emmaalmer.Blaff.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {


    private final WordRepository wordRepository;

    @Autowired
    public WordController(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    @PostMapping("/word/create")
    public ResponseEntity<String> createWord(@RequestBody Word word){
        wordRepository.save(word);
        return ResponseEntity.status(201).body(word.getName());
    }

    @PostMapping("/word/createWords")
    public ResponseEntity<String> createWords(@RequestBody List<Word> word){

        word.forEach(w -> wordRepository.save(w));

        return ResponseEntity.status(201).body("words added");
    }
}
