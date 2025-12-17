package com.emmaalmer.Blaff.service;

import com.emmaalmer.Blaff.entity.Word;
import com.emmaalmer.Blaff.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final Random random = new Random();

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    //random ord perkategori
    public Word getRandomWord(String category) {
        List<Word> wordList = wordRepository.findByCategoryName(category);

        if (wordList.isEmpty()) {
            throw new RuntimeException("The category: " + category + " has no words");
        }

        return wordList.get(random.nextInt(wordList.size()));
    }

    //alla kategorier
    public Word getRandomWord() {
        List<Word> wordList = wordRepository.findAll();

        if (wordList.isEmpty()) {
            throw new RuntimeException("Has no words");
        }

        return wordList.get(random.nextInt(wordList.size()));
    }
}
