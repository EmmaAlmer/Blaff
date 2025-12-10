package com.emmaalmer.Blaff.repository;

import com.emmaalmer.Blaff.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, String> {

    List <Word> findByCategoryName(String name);
}
