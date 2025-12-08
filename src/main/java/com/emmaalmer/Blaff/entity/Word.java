package com.emmaalmer.Blaff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Word(

        @Id
        String id) {

}
