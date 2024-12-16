package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    final private Integer boardSize;
    final private List<Ladder> ladders;
    final private List<Snake> snakes;
    final private List<Player> players;

    public Board(final Integer boardSize, final List<Ladder> ladders, final List<Player> players,
                 final List<Snake> snakes) {
        this.boardSize = boardSize;
        this.ladders = ladders;
        this.players = players;
        this.snakes = snakes;
    }
    /*
    Board properties:
    - Move the player
    - Should remember all the positions of players
    - Should remember all the positions of snakes
    - Should remember all the positions of ladders
    - Should remember the finish point (size)
     */

    public void movePlayer(final Player player, final Integer newPosition) {
        for(Player player1: players) {
            if (player1.equals(player)) {
                player1.setPosition(newPosition);
            }
        }
        return;
    }

//    public Integer playerPosition(final Player player) {
//        for(Player player1: players) {
//            if (player1.equals(player)) {
//                return player1
//            }
//        }
//    }

    public Integer snakeTailPositionIfAtHead(final Integer position) {
        for (Snake snake: snakes) {
            if(snake.getHead().equals(position))
                return snake.getTail();
        }
        return null;
    }

    public Integer ladderHeadPositionIfAtTail(final Integer position) {
        for (Ladder ladder: ladders) {
            if(ladder.getBottomPosition().equals(position))
                return ladder.getTopPosition();
        }
        return null;
    }

    public Boolean isFinalPosition(final Integer position) {
        return boardSize.equals(position);
    }
}
