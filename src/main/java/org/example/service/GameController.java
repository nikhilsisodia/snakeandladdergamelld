package org.example.service;

import org.example.models.*;

import java.util.List;
import java.util.Objects;

public class GameController {
    private Board board;
    private Dice dice;

    public GameController(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
    }

    public void startGame() {
        List<Player> players = board.getPlayers();
        Integer diceNumber;
        Integer playerPosition;
        while (true) {
            for (Player player : players) {
                playerPosition = player.getPosition();
                diceNumber = dice.rollDice();
                System.out.println("Player: " + player.getName() + " playing at position " + player.getPosition());
                System.out.println("Dice rolled: " + diceNumber);

                if (playerMovedBySnake(player, playerPosition, diceNumber)) continue;

                if (playerMovedByLadder(player, playerPosition, diceNumber)) continue;

                if (playerMovedNaturallyByDice(player, playerPosition, diceNumber)) continue;

                System.out.println("Player:" + player.getName() + " did not move\n");
            }
        }
    }

    private boolean playerMovedNaturallyByDice(Player player, Integer playerPosition, Integer diceNumber) {
        if ((playerPosition + diceNumber) <= board.getBoardSize()) {
            player.setPosition(playerPosition + diceNumber);
            declareWinnerIfPlayerWon(playerPosition, player);
            return true;
        }
        return false;
    }

    private boolean playerMovedByLadder(Player player, Integer playerPosition, Integer diceNumber) {
        Integer finalPosition = board.ladderHeadPositionIfAtTail(playerPosition + diceNumber);
        if (Objects.nonNull(finalPosition)) {
            System.out.println("Ladder detected at position: " + (playerPosition + diceNumber));
            movePlayerByLadder(player, playerPosition, finalPosition);
            return true;
        }
        return false;
    }

    private void movePlayerByLadder(Player player, Integer playerPosition, Integer finalPosition) {
        player.setPosition(finalPosition);
        declareWinnerIfPlayerWon(playerPosition, player);
    }

    private boolean playerMovedBySnake(Player player, Integer playerPosition, Integer diceNumber) {
        Integer finalPosition = board.snakeTailPositionIfAtHead(playerPosition + diceNumber);
        if (Objects.nonNull(finalPosition)) {
            System.out.println("Snake detected at position: " + (playerPosition + diceNumber));
            movePlayerBySnake(player, playerPosition, finalPosition);
            return true;
        }
        return false;
    }

    private void movePlayerBySnake(Player player, Integer playerPosition, Integer finalPosition) {
        player.setPosition(finalPosition);
        declareWinnerIfPlayerWon(playerPosition, player);
    }

    private void declareWinnerIfPlayerWon(Integer playerPosition, Player player) {
        if (hasPlayerWon(player)) {
            System.out.println("Player " + player.getName() + " won the game !!\n");
            System.exit(0);
        }
        System.out.println("Player moved from position " + playerPosition + " to " + player.getPosition() + "\n");
    }

    private boolean hasPlayerWon(Player player) {
        return player.getPosition().equals(board.getBoardSize());
    }
}
