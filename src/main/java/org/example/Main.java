package org.example;

import org.example.models.*;
import org.example.service.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of snakes followed by n lines each containing there head and tail");

        Scanner sc = new Scanner(System.in);
        Integer noOfSnakes = sc.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for (int i = 0; i < noOfSnakes; i++) {
            snakes.add(new Snake(sc.nextInt(), sc.nextInt()));
        }

        System.out.println("Enter the number of ladders followed by n lines each containing there start and end position");

        List<Ladder> ladders = new ArrayList<>();
        Integer noOfLadders = sc.nextInt();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(sc.nextInt(), sc.nextInt()));
        }

        System.out.println("Enter the number of players followed by n lines each containing there names");

        List<Player> players = new ArrayList<>();
        Integer noOfPlayers = sc.nextInt();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(sc.next(), 0));
        }

        Board board = new Board(100, ladders, players, snakes);
        Dice dice = new Dice();

        GameController gameController = new GameController(board, dice, players.size());
        gameController.startGame();
    }
}
