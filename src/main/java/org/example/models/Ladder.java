package org.example.models;

public class Ladder {
    private Integer bottomPosition;
    private Integer topPosition;

    public Ladder(Integer bottomPosition, Integer topPosition) {
        this.bottomPosition = bottomPosition;
        this.topPosition = topPosition;
    }

    public Integer getBottomPosition() {
        return bottomPosition;
    }

    public void setBottomPosition(Integer bottomPosition) {
        this.bottomPosition = bottomPosition;
    }

    public Integer getTopPosition() {
        return topPosition;
    }

    public void setTopPosition(Integer topPosition) {
        this.topPosition = topPosition;
    }
}
