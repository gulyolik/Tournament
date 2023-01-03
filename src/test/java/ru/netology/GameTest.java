package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Player;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();
    public List<Player> playersList = new ArrayList<Player>();
    Player player1 = new Player(1, "Петя", 10);
    Player player2 = new Player(2, "Света", 22);
    Player player3 = new Player(3, "Игорь", 22);
    Player player4 = new Player(4, "Маша", 19);

    @BeforeEach
    public void SetUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void shouldShowException1() {
        Player player5 = new Player(5, "Олег", 33);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Олег", "Петя");
                });
    }

    @Test
    public void shouldShowException2() {
        Player player5 = new Player(5, "Олег", 33);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Петя", "Олег");
                });

    }

    @Test
    public void shouldCompareEqualPLayers() {
        int expected = 0;
        int actual = game.round("Света", "Игорь");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldComparePlayers1() {
        int expected = 1;
        int actual = game.round("Света", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePlayers2() {
        int expected = 2;
        int actual = game.round("Петя", "Маша");
        Assertions.assertEquals(expected, actual);
    }
}