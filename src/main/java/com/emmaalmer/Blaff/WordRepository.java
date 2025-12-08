package com.emmaalmer.Blaff;

import com.emmaalmer.Blaff.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
