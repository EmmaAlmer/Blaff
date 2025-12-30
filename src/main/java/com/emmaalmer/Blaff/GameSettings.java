package com.emmaalmer.Blaff;

import java.util.List;

public record GameSettings(

        int minImposters,
        int maxImposters,
        //den valda kategorin som ordet kommer ifrån
        List<String> categories
) {
}
