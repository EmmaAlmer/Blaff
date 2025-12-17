package com.emmaalmer.Blaff.service;

import com.emmaalmer.Blaff.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerService {

    private final Map<Long, Player> players = new HashMap<>();
    private long idCounter = 1;

    //lägger tillspelare uta att spara dess värden förutom namn
    public Player addPlayer(String name) {

        Player p = new Player(idCounter++, name, null, null);
        players.put(p.id(), p);
        return p;
    }

    public List<Player> getAllPlayers() {
        return new ArrayList<>(players.values());
    }

    public void removePlayer(Long id) {
        players.remove(id);
    }

    //rensar rollerna för spelarna  men behåller spelarna
    public void clearRoles() {
        for (var entry : players.entrySet()) {
            Player p = entry.getValue();
            entry.setValue(new Player(p.id(), p.name(), null, null));
        }
    }

    //spelaren uppdateras vid ex rollsättingar
    public void updatePlayer(Player updatedPlayer) {
        players.put(updatedPlayer.id(), updatedPlayer);
    }

    // Nollställ spelet helt (alla spelare tas bort)
    public void resetGame() {
        players.clear();
        idCounter = 1;
    }
}
