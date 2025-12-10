package com.emmaalmer.Blaff.entity;

import com.emmaalmer.Blaff.Role;

public record Player(

        Long id,
        String name,
        Role role,
        //ordet civilian ser, imposters ser ordet imposter
        String word
) {
}
