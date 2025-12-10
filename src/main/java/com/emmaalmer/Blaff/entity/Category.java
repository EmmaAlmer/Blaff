package com.emmaalmer.Blaff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Category(

        @Id
        String name) {
}
