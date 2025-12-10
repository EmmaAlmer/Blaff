package com.emmaalmer.Blaff.repository;

import com.emmaalmer.Blaff.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
