package com.emmaalmer.Blaff.controller;

import com.emmaalmer.Blaff.DTO.GamePlayerDTO;
import com.emmaalmer.Blaff.GameSettings;
import com.emmaalmer.Blaff.Player;
import com.emmaalmer.Blaff.Role;
import com.emmaalmer.Blaff.entity.Word;
import com.emmaalmer.Blaff.service.CategoryService;
import com.emmaalmer.Blaff.service.GameSettingsService;
import com.emmaalmer.Blaff.service.PlayerService;
import com.emmaalmer.Blaff.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/gameloop")
public class GameloopViewController {

    private final PlayerService playerService;
    private final WordService wordService;
    private final GameSettingsService gameSettingsService;
    private final CategoryService categoryService;
    private final Random random = new Random();

    public GameloopViewController(PlayerService playerService, WordService wordService, GameSettingsService gameSettingsService, CategoryService categoryService) {
        this.playerService = playerService;
        this.wordService = wordService;
        this.gameSettingsService = gameSettingsService;
        this.categoryService = categoryService;
    }

    @PostMapping
    public String startGameWithSettings(GameSettings settings){

        if(settings.categories() == null){

            List<String> categories = new ArrayList<>();
            categoryService.getAllCategories().stream().forEach(category -> categories.add(category.getName()));
            settings = new GameSettings(settings.minImposters(), settings.maxImposters(), categories);
        }
        gameSettingsService.setSettings(settings);
        return "redirect:/gameloop";
    }

    //glöm inte  att  testa min imposters ord och kategori och uppdatera texten i slidern
    @GetMapping
    public String startGameloop(Model model) {

        GameSettings settings = gameSettingsService.getSettings();
        List<Player> players = playerService.getAllPlayers();

        int imposterAmount = random.nextInt(
                settings.minImposters(),
                settings.maxImposters() + 1
        );

        Word word = wordService.getRandomWord(settings.categories());

        List<Boolean> roles = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            roles.add(i < imposterAmount);
        }
        Collections.shuffle(roles);

        List<GamePlayerDTO> dtoPlayers = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            if (roles.get(i)) {
                dtoPlayers.add(new GamePlayerDTO(
                        players.get(i).getName(),
                        "IMPOSTER",
                        null
                ));
            } else {
                dtoPlayers.add(new GamePlayerDTO(
                        players.get(i).getName(),
                        "CIVILIAN",
                        word.getName()
                ));
            }
        }

        model.addAttribute("players", dtoPlayers);
        return "gameloop";
    }


    /*@PostMapping
    public String startGameloop(@RequestBody GameSettings settings, RedirectAttributes redirectAttributes) {


        redirectAttributes.addFlashAttribute("settings", settings);
        return "redirect:/gameloop/game";
    }*/

    @GetMapping("/game")
    public String gameLoop() {
        return "gameLoop";
    }
}
