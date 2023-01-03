package ru.netology.data;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private int strength;


    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }
}
