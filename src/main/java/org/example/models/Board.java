package org.example.models;

import java.util.List;

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

    public Integer getBoardSize() {
        return boardSize;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

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
}
