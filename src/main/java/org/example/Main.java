package org.example;

import org.example.models.Ladder;
import org.example.models.Player;
import org.example.models.Snake;
import org.example.service.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of snakes followed by n lines each containing there head and tail");

        Scanner sc = new Scanner(System.in);
        List<Snake> snakes = new ArrayList<>(sc.nextInt());
        for (Snake snake: snakes) {
            snake.setHead(sc.nextInt());
            snake.setHead(sc.nextInt());
        }


        System.out.println("Enter the number of ladders followed by n lines each containing there start and end position");

        List<Ladder> ladders = new ArrayList<>(sc.nextInt());
        for (Ladder ladder: ladders) {
            ladder.setBottomPosition(sc.nextInt());
            ladder.setTopPosition(sc.nextInt());
        }

        System.out.println("Enter the number of players followed by n lines each containing there names");

        List<Player> players = new ArrayList<>(sc.nextInt());
        for (Player player: players) {
            player.setName(sc.next());
            player.setPosition(0);
        }

        GameController gameController = new GameController();




//        Classes:
//        Create model class for all these entities
//        Create a class for the game
//        Create a class for game controller
    }
}