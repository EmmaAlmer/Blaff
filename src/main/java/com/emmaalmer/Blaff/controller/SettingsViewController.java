package com.emmaalmer.Blaff.controller;

import com.emmaalmer.Blaff.service.CategoryService;
import com.emmaalmer.Blaff.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingsViewController {

    CategoryService categoryService;
    PlayerService playerService;


    public SettingsViewController(CategoryService categoryService, PlayerService playerService) {
        this.categoryService = categoryService;
        this.playerService = playerService;
    }

    //edvard ska hitta åt felmeddeladne för detta
    @GetMapping
    public String showCategories(Model model) {

        if(playerService.getAllPlayers().size() < 2){
            return "redirect:/players/view";
        }
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("players", playerService.getAllPlayers());


        return "settings";
    }
}
