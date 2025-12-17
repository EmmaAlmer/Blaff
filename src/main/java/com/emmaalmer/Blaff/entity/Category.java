package com.emmaalmer.Blaff.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

        @Id
        String name;

        @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Word> words = new ArrayList<>();

        public Category(String name) {
                this.name = name;
        }

        public Category() {
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}
