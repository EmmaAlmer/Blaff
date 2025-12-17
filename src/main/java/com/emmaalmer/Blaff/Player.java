package com.emmaalmer.Blaff;

public record Player(

        Long id,
        String name,
        Role role,
        //ordet civilian ser, imposters ser ordet imposter
        String word
) {
}
