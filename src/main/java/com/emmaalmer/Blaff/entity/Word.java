package com.emmaalmer.Blaff.entity;

import jakarta.persistence.*;

@Entity
public class Word{

        @Id
        String name;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "category_name", nullable = false)
        Category category;

        public Word(String name, Category category) {
                this.name = name;
                this.category = category;
        }

        public Word() {
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Category getCategory() {
                return category;
        }

        public void setCategory(Category category) {
                this.category = category;
        }
}
