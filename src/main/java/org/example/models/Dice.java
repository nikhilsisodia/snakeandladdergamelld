package org.example.models;

import java.util.Random;

public class Dice {
    public Integer rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
