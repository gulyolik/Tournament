package ru.netology;

import lombok.NoArgsConstructor;
import ru.netology.data.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
public class Game {
    public HashMap<String, Integer> playersMap = new HashMap<String, Integer>();

    public void register(String name, Integer strength) {

        playersMap.put(name, strength);
    }

    boolean isRegistered(String name) {
        for (String key : playersMap.keySet()) {
            if (playersMap.containsKey(name)) {
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

        if (playersMap.get(playerName1) > playersMap.get(playerName2)) {
            return 1;
        } else if (playersMap.get(playerName1) < playersMap.get(playerName2)) {
            return 2;
        }
        return 0;
    }
}


