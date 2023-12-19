package com.exmaple2.play_task.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StatisticsData implements Serializable {
    private Map<String, DailyStatistics> dailyStatistics = new HashMap<>();
    private Map<String, WeeklyStatistics> weeklyStatistics = new HashMap<>();
    private Map<String, MonthlyStatistics> monthlyStatistics = new HashMap<>();
    private Map<String, YearlyStatistics> yearlyStatistics = new HashMap<>();

    // 添加或更新统计数据的方法
    public void addOrUpdateDailyStatistics(String date, int income, int expense) {
        DailyStatistics stats = dailyStatistics.getOrDefault(date, new DailyStatistics(0, 0, 0));
        stats.setIncome(stats.getIncome() + income);
        stats.setExpense(stats.getExpense() + expense);
        stats.setBalance(stats.getIncome() - stats.getExpense());
        dailyStatistics.put(date, stats);
    }
    public static class DailyStatistics implements Serializable {
        private int income;
        private int expense;
        private int balance;

        public DailyStatistics(int income, int expense, int balance) {
            this.income = income;
            this.expense = expense;
            this.balance = balance;
        }

        // Getter 和 Setter 方法
        public int getIncome() { return income; }
        public void setIncome(int income) { this.income = income; }

        public int getExpense() { return expense; }
        public void setExpense(int expense) { this.expense = expense; }

        public int getBalance() { return balance; }
        public void setBalance(int balance) { this.balance = balance; }
    }

    public static class WeeklyStatistics implements Serializable {
        private int income; // 每周收入
        private int expense; // 每周支出
        private int balance; // 每周结余

        // 构造函数、getter 和 setter
        public WeeklyStatistics(int income, int expense, int balance) {
            this.income = income;
            this.expense = expense;
            this.balance = balance;
        }

        // Getter 和 Setter 方法
        public int getIncome() { return income; }
        public void setIncome(int income) { this.income = income; }

        public int getExpense() { return expense; }
        public void setExpense(int expense) { this.expense = expense; }

        public int getBalance() { return balance; }
        public void setBalance(int balance) { this.balance = balance; }
    }

    public static class MonthlyStatistics implements Serializable {
        private int income; // 每月收入
        private int expense; // 每月支出
        private int balance; // 每月结余

        // 构造函数、getter 和 setter
        public MonthlyStatistics(int income, int expense, int balance) {
            this.income = income;
            this.expense = expense;
            this.balance = balance;
        }

        // Getter 和 Setter 方法
        public int getIncome() { return income; }
        public void setIncome(int income) { this.income = income; }

        public int getExpense() { return expense; }
        public void setExpense(int expense) { this.expense = expense; }

        public int getBalance() { return balance; }
        public void setBalance(int balance) { this.balance = balance; }
    }

    public static class YearlyStatistics implements Serializable {
        private int income; // 每年收入
        private int expense; // 每年支出
        private int balance; // 每年结余

        // 构造函数、getter 和 setter
        public YearlyStatistics(int income, int expense, int balance) {
            this.income = income;
            this.expense = expense;
            this.balance = balance;
        }

        // Getter 和 Setter 方法
        public int getIncome() { return income; }
        public void setIncome(int income) { this.income = income; }

        public int getExpense() { return expense; }
        public void setExpense(int expense) { this.expense = expense; }

        public int getBalance() { return balance; }
        public void setBalance(int balance) { this.balance = balance; }
    }

    // Getter 和 Setter 方法
    public Map<String, DailyStatistics> getDailyStatistics() { return dailyStatistics; }
    public void setDailyStatistics(Map<String, DailyStatistics> dailyStatistics) { this.dailyStatistics = dailyStatistics; }

    public Map<String, WeeklyStatistics> getWeeklyStatistics() { return weeklyStatistics; }
    public void setWeeklyStatistics(Map<String, WeeklyStatistics> weeklyStatistics) { this.weeklyStatistics = weeklyStatistics; }

    public Map<String, MonthlyStatistics> getMonthlyStatistics() { return monthlyStatistics; }
    public void setMonthlyStatistics(Map<String, MonthlyStatistics> monthlyStatistics) { this.monthlyStatistics = monthlyStatistics; }

    public Map<String, YearlyStatistics> getYearlyStatistics() { return yearlyStatistics; }
    public void setYearlyStatistics(Map<String, YearlyStatistics> yearlyStatistics) { this.yearlyStatistics = yearlyStatistics; }
}
