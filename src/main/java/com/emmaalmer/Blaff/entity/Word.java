package com.emmaalmer.Blaff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public record Word(

        @Id
        String name,

        @ManyToOne
        @JoinColumn(name = "category_id")Category category) {

}
