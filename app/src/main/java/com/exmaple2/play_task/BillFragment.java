package com.exmaple2.play_task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exmaple2.play_task.data.BillAdapter;
import com.exmaple2.play_task.data.BillItem;
import com.exmaple2.play_task.data.DataBank;
import com.exmaple2.play_task.data.RewardItem;
import com.exmaple2.play_task.data.SharedViewModel;
import com.exmaple2.play_task.data.TaskName;

import java.util.ArrayList;
import java.util.List;

public class BillFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<BillItem> billItems;
    private BillAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bill_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadData();
        adapter = new BillAdapter(billItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        viewModel.getBills().observe(getViewLifecycleOwner(), new Observer<List<BillItem>>() {
            @Override
            public void onChanged(List<BillItem> billItems) {
                // 当账单列表更新时，刷新 RecyclerView
                adapter.setBillItems(billItems); // 确保你的 Adapter 有这个方法
                adapter.notifyDataSetChanged();
            }
        });
        // 找到返回文本视图并设置点击事件
        // 设置返回按钮的点击事件
        TextView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            // 当点击返回时，首先调用popBackStack
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }

            // 然后调用returnToStatistics来确保正确显示统计内容
            returnToStatistics();
        });
    }
    private void returnToStatistics() {
        // 首先我们隐藏fragment容器
        if (getActivity() != null) {
            View fragmentContainer = getActivity().findViewById(R.id.fragment_container);
            if (fragmentContainer != null) {
                fragmentContainer.setVisibility(View.GONE);
            }
        }

        // 然后通知 MainActivity 显示统计内容
        if (getActivity() instanceof MainActivity) {
            ((MainActivity)getActivity()).showStatisticsContent();
        }
    }

    private void loadData() {
        DataBank dataBank = new DataBank();
        billItems = new ArrayList<>();

        // 假设 DataBank 有方法获取所有任务和奖励
        ArrayList<TaskName> tasks = dataBank.loadTasks(getContext(), "tasks_filename"); // 替换为实际文件名
        ArrayList<RewardItem> rewards = dataBank.loadRewards(getContext());

        // 将任务转换为账单项
        for (TaskName task : tasks) {
            billItems.add(new BillItem(task.getDescription(), task.getScoreChange()));
        }

        // 将奖励转换为账单项
        for (RewardItem reward : rewards) {
            billItems.add(new BillItem(reward.getDescription(), reward.getScoreChange()));
        }

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 当BillFragment的视图被销毁时，也就是它从回退栈中弹出时，我们隐藏fragment容器
        if (getActivity() != null) {
            // 获取到FragmentManager，准备事务
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            // 查找StatisticsFragment
            StatisticsFragment statisticsFragment = (StatisticsFragment) fragmentManager.findFragmentByTag("StatisticsFragmentTag");
            if (statisticsFragment != null && statisticsFragment.isVisible()) {
                // 如果找到StatisticsFragment且它是可见的，我们显示ViewPager和TabLayout
                statisticsFragment.showViewPagerAndTabs();
            }
        }
    }

}

