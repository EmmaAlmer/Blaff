package com.emmaalmer.Blaff.restController;

import com.emmaalmer.Blaff.DTO.AddPlayerRequest;
import com.emmaalmer.Blaff.GameSettings;
import com.emmaalmer.Blaff.Player;
import com.emmaalmer.Blaff.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playersAPI")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;

    }

    @PostMapping("/add")
    public Player addPlayer(@RequestBody AddPlayerRequest req) {
        return playerService.addPlayer(req.name());
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @DeleteMapping("/{id}")
    public void removePlayer(@PathVariable Long id) {
        playerService.removePlayer(id);
    }

}
