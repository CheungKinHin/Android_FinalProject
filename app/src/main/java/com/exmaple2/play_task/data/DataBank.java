package com.exmaple2.play_task.data;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataBank {
    final String SCORE_FILENAME = "score.data";

    public void saveScore(Context context, int score) {
        try {
            FileOutputStream fileOut = context.openFileOutput(SCORE_FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeInt(score);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int loadScore(Context context) {
        int score = 0;
        try {
            FileInputStream fileIn = context.openFileInput(SCORE_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            score = objectIn.readInt();
            objectIn.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return score;
    }
    public void saveTasks(Context context, ArrayList<TaskName> tasks, String filename) {
        try {
            FileOutputStream fileOut = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tasks);
            out.close();
            fileOut.close();
            Log.d("Serialization", "Tasks are serialized and saved: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<TaskName> loadTasks(Context context, String filename) {
        ArrayList<TaskName> tasks = new ArrayList<>();
        try {
            FileInputStream fileIn = context.openFileInput(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            tasks = (ArrayList<TaskName>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            Log.d("Serialization", "Tasks loaded successfully: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }
    final String REWARDS_FILENAME = "rewards.data";

    public void saveRewards(Context context, ArrayList<RewardItem> rewards) {
        try {
            FileOutputStream fileOut = context.openFileOutput(REWARDS_FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(rewards);
            out.close();
            fileOut.close();
            Log.d("Serialization", "Rewards are serialized and saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<RewardItem> loadRewards(Context context) {
        ArrayList<RewardItem> rewards = new ArrayList<>();
        try {
            FileInputStream fileIn = context.openFileInput(REWARDS_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            rewards = (ArrayList<RewardItem>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            Log.d("Serialization", "Rewards loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rewards;
    }

// 在 DataBank 类中

    final String STATISTICS_FILENAME = "statistics.data";

    public void saveStatistics(Context context, StatisticsData statisticsData) {
        try {
            FileOutputStream fileOut = context.openFileOutput(STATISTICS_FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(statisticsData);
            out.close();
            fileOut.close();
            Log.d("Serialization", "Statistics data are serialized and saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StatisticsData loadStatistics(Context context) {
        StatisticsData statisticsData = new StatisticsData(); // 默认空统计数据
        try {
            FileInputStream fileIn = context.openFileInput(STATISTICS_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            statisticsData = (StatisticsData) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            Log.d("Serialization", "Statistics data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return statisticsData;
    }
    final String BILL_FILENAME = "bills.data";
    public void saveBills(Context context, ArrayList<BillItem> bills) {
        try {
            FileOutputStream fileOut = context.openFileOutput(BILL_FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(bills);
            out.close();
            fileOut.close();
            Log.d("DataBank", "Bills saved successfully.");
        } catch (IOException e) {
            Log.e("DataBank", "Error saving bills", e);
        }
    }

    public ArrayList<BillItem> loadBills(Context context) {
        ArrayList<BillItem> bills = new ArrayList<>();
        try {
            FileInputStream fileIn = context.openFileInput(BILL_FILENAME);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            bills = (ArrayList<BillItem>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            Log.d("DataBank", "Bills loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            Log.e("DataBank", "Error loading bills", e);
        }
        return bills;
    }

}
