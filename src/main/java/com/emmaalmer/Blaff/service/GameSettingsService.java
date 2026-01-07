package com.emmaalmer.Blaff.service;

import com.emmaalmer.Blaff.GameSettings;
import org.springframework.stereotype.Service;

@Service
public class GameSettingsService {

    private GameSettings currentSettings;

    public GameSettings getSettings() {
        return currentSettings;
    }

    public void setSettings(GameSettings settings) {
        this.currentSettings = settings;
    }
}
