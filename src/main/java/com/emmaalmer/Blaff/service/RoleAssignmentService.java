package com.emmaalmer.Blaff.service;

import com.emmaalmer.Blaff.GameSettings;
import com.emmaalmer.Blaff.Player;
import com.emmaalmer.Blaff.Role;
import com.emmaalmer.Blaff.Round;
import com.emmaalmer.Blaff.entity.Word;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class RoleAssignmentService {

    private final PlayerService playerService;
    private final WordService wordService;

    public RoleAssignmentService(PlayerService playerService, WordService wordService) {
        this.playerService = playerService;
        this.wordService = wordService;
    }

    public Round assignRoles(GameSettings settings) {

        List<Player> players = playerService.getAllPlayers();
        if (players.isEmpty()) {
            throw new RuntimeException("No players added");
        }

        Collections.shuffle(players);

        //slumpar antal imposters
        Random rand = new Random();
        int imposterCount = settings.minImposters()
                + rand.nextInt(settings.maxImposters() - settings.minImposters() + 1);

        //hämtar slumpat ord
        Word chosenWord = wordService.getRandomWord(settings.categories());

        //tilldelar roller
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);

            if (i < imposterCount) {
                playerService.updatePlayer(
                        new Player(p.id(), p.name(), Role.IMPOSTER, null)
                );
            } else {
                playerService.updatePlayer(
                        new Player(p.id(), p.name(), Role.CIVILIAN, chosenWord.getName())
                );
            }
        }


        //returnera info om rundan (inte roller!)
        return new Round(imposterCount, chosenWord.getName());
    }
}
