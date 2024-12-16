package org.example.service;

import org.example.models.*;

import java.util.List;

public class GameController {
    private Board board;
    private Dice dice;
    private Integer numberOfPlayers;

    public GameController(Board board, Dice dice, Integer numberOfPlayers) {
        this.board = board;
        this.dice = dice;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Player startGame() {
        List<Player> players = board.getPlayers();
        Integer diceNumber;
        Integer playerPosition;
        Player winner = null;
        while (winner == null) {
            for (Player player : players) {
                diceNumber = dice.rollDice();
                playerPosition = player.getPosition();
                for (Snake snake : board.getSnakes()) {
                    if (snake.getHead().equals(player.getPosition() + diceNumber)) {
                        player.setPosition(snake.getTail());
                        break;
                    }
                }
                for (Ladder ladder : board.getLadders()) {
                    if (ladder.getBottomPosition().equals(player.getPosition() + diceNumber)) {
                        player.setPosition(ladder.getTopPosition());
                        break;
                    }
                }
                if (playerPosition.equals(player.getPosition())) {
                    player.setPosition(playerPosition + diceNumber);
                }

                if (player.getPosition() > board.getBoardSize()) {
                    player.setPosition(player.getPosition() - diceNumber);
                }

                System.out.println("Player " + player.getName() + " moved from position " + playerPosition + " to "
                        + player.getPosition());

                if (player.getPosition().equals(board.getBoardSize())) {
                    winner = player;
                    System.out.println("Player " + player.getName() + " won the game !!");
                }
            }
        }
        return winner;
    }
}
