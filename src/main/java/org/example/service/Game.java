package org.example.service;

import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public Board initializeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of snakes followed by n lines each containing there head and tail");
        List<Snake> snakes = takeInputForSnakes(scanner);

        System.out.println("Enter the number of ladders followed by n lines each containing there start and end position");
        List<Ladder> ladders = takeInputForLadders(scanner);

        System.out.println("Enter the number of players followed by n lines each containing there names");
        List<Player> players = takeInputForPlayers(scanner);

        Board board = new Board(100, ladders, players, snakes);
        return board;
    }

    private static List<Player> takeInputForPlayers(Scanner sc) {
        List<Player> players = new ArrayList<>();
        Integer noOfPlayers = sc.nextInt();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(sc.next(), 0));
        }
        return players;
    }

    private static List<Ladder> takeInputForLadders(Scanner sc) {
        List<Ladder> ladders = new ArrayList<>();
        Integer noOfLadders = sc.nextInt();
        for (int i = 0; i < noOfLadders; i++) {
            ladders.add(new Ladder(sc.nextInt(), sc.nextInt()));
        }
        return ladders;
    }

    private static List<Snake> takeInputForSnakes(Scanner scanner) {
        List<Snake> snakes = new ArrayList<>();
        Integer noOfSnakes = scanner.nextInt();
        for (int i = 0; i < noOfSnakes; i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }
        return snakes;
    }
}
