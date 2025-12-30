package com.emmaalmer.Blaff.service;

import com.emmaalmer.Blaff.entity.Word;
import com.emmaalmer.Blaff.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final Random random = new Random();

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    //random ord per kategori
    public Word getRandomWord(List <String> categories) {

        List<Word> wordList = new ArrayList<>();

        for(String c : categories){
            wordList.addAll(wordRepository.findByCategoryName(c));
        }

        if (wordList.isEmpty()) {
            throw new RuntimeException("Has no words");
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
