package com.emmaalmer.Blaff;

public record GameSettings(

        int minImposters,
        int maxImposters,
        //den valda kategorin som ordet kommer ifrån
        String category

) {
}
