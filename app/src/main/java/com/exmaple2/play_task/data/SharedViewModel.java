package com.exmaple2.play_task.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> totalScore = new MutableLiveData<>();

    public void setTotalScore(int score) {
        totalScore.setValue(score);
    }

    public LiveData<Integer> getTotalScore() {
        return totalScore;
    }
    private MutableLiveData<List<BillItem>> billsLiveData = new MutableLiveData<>();

    // 初始化或更新账单列表
    public void setBills(List<BillItem> bills) {
        billsLiveData.setValue(bills);
    }

    // 获取账单列表的 LiveData
    public LiveData<List<BillItem>> getBills() {
        return billsLiveData;
    }

}
