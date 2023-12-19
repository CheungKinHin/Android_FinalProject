package com.exmaple2.play_task.data;

import java.io.Serializable;

public class TaskName implements Serializable {


    private int score;
    private String name;
    public String getTitle() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public TaskName(String name_, int s) {
        this.name=name_;
        this.score=s;
    }
    public void setName(String name) {
        this.name = name;
    }
    // 构造函数、getter 和 setter

    public String getDescription() {
        return "任务: " + name;
    }

    public int getScoreChange() {
        return  score; // 任务增加分数
    }
}

