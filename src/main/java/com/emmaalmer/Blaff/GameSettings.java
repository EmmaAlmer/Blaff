package com.emmaalmer.Blaff;

import java.util.List;

public record GameSettings(

        int minImposters,
        int maxImposters,
        List<String> categories
) {
}
