package com.emmaalmer.Blaff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record GameSettings(

        int minImposters,
        int maxImposters,
        //den valda kategorin som ordet kommer ifrån
        String category

) {
}
