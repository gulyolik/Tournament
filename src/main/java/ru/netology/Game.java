package ru.netology;

import lombok.NoArgsConstructor;
import ru.netology.data.Player;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Game {
    public List<Player> playersList = new ArrayList<Player>();

    public void register(Player player) {
        playersList.add(player);
    }

    boolean isRegistered(String name) {
        for (Player player : playersList) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int round(String playerName1, String playerName2) {
        if (!isRegistered(playerName1)) {
            throw new NotRegisteredException(
                    "Player with name " + playerName1 + " is not registered"
            );
        }
        if (!isRegistered(playerName2)) {
            throw new NotRegisteredException(
                    "Player with name " + playerName2 + " is not registered"
            );
        }
        Player player1 = new Player();
        Player player2 = new Player();
        for (Player player : playersList) {

            if (playerName1.equals(player.getName())) {
                player1 = player;
            }
            if (playerName2.equals(((Player) player).getName())) {
                player2 = player;
            }

        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}


