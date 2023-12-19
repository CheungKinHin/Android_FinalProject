package com.exmaple2.play_task.data;

public class BillItem {
    private String description;
    private int scoreChange;

    public BillItem(String description, int scoreChange) {
        this.description = description;
        this.scoreChange = scoreChange;
    }

    public String getDescription() {
        return description;
    }

    public int getScoreChange() {
        return scoreChange;
    }
}
