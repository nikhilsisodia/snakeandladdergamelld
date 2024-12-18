package org.example;

import org.example.models.*;
import org.example.service.Game;
import org.example.service.GameController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let the Snakes and ladder game begin");
        Game game = new Game();
        Board board = game.initializeGame();
        Dice dice = new Dice();
        GameController gameController = new GameController(board, dice);
        gameController.startGame();
    }
}
