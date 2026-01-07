package com.emmaalmer.Blaff.controller;

import com.emmaalmer.Blaff.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayerViewController {

    private final PlayerService playerService;

    public PlayerViewController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/view")
    public String showPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());

        return "players";
    }

    @PostMapping("/add")
    public String addPlayers(@RequestParam String name) {
        playerService.addPlayer(name);

        return "redirect:/players/view";
    }

    //kanske ska vara delete men gick ej
    @PostMapping("/remove")
    public String removePlayers(@RequestParam Long id) {

        playerService.removePlayer(id);

        return "redirect:/players/view";
    }
}
