package com.emmaalmer.Blaff.controller;

import com.emmaalmer.Blaff.GameSettings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gameloop")
public class GameloopViewController {

    @PostMapping
    public String startGameloop(@RequestBody GameSettings settings, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("settings", settings);
        return "redirect:/gameloop/game";
    }

    @GetMapping("/game")
    public String gameLoop() {
        return "gameLoop";
    }
}
