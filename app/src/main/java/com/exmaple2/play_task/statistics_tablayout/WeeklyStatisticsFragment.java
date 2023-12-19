package com.exmaple2.play_task.statistics_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.exmaple2.play_task.R;
import com.exmaple2.play_task.view.SimpleLineChartView;

public class WeeklyStatisticsFragment extends Fragment {

    private SimpleLineChartView chartView;

    public WeeklyStatisticsFragment() {
        // Required empty public constructor
    }

    public static WeeklyStatisticsFragment newInstance() {
        return new WeeklyStatisticsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weekly_statistics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chartView = view.findViewById(R.id.chart_view);

        // 这里你需要从数据模型中获取实际数据并传递给图表视图
        // 例如，如果你的 SimpleLineChartView 有一个 setData 方法:
        // chartView.setData(...);
    }

    // 你可能还需要其他方法来更新图表数据或响应用户交互
}
