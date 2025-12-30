package com.emmaalmer.Blaff.restController;

import com.emmaalmer.Blaff.DTO.AddPlayerRequest;
import com.emmaalmer.Blaff.GameSettings;
import com.emmaalmer.Blaff.Player;
import com.emmaalmer.Blaff.Round;
import com.emmaalmer.Blaff.service.PlayerService;
import com.emmaalmer.Blaff.service.RoleAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playersAPI")
public class PlayerController {

    private final PlayerService playerService;
    private final RoleAssignmentService roleAssignmentService;

    public PlayerController(PlayerService playerService, RoleAssignmentService roleAssignmentService) {
        this.playerService = playerService;
        this.roleAssignmentService = roleAssignmentService;
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

    @PostMapping("/startRound")
    public Round startRound(@RequestBody GameSettings settings) {

        //behåller spelare, rensar gamla roller
        playerService.clearRoles();

        return roleAssignmentService.assignRoles(settings);
    }
}
