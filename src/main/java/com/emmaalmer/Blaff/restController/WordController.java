package com.emmaalmer.Blaff.restController;

import com.emmaalmer.Blaff.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {


    private final WordRepository wordRepository;

    @Autowired
    public WordController(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }
}
