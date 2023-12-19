package com.exmaple2.play_task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.exmaple2.play_task.statistics_tablayout.DailyStatisticsFragment;
import com.exmaple2.play_task.statistics_tablayout.MonthlyStatisticsFragment;
import com.exmaple2.play_task.statistics_tablayout.WeeklyStatisticsFragment;
import com.exmaple2.play_task.statistics_tablayout.YearlyStatisticsFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment {
    public StatisticsFragment() {
        // Required empty public constructor
    }
    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_statistics, container, false);

        // 初始化 ViewPager 和 TabLayout
        ViewPager2 viewPager = rootView.findViewById(R.id.view_pager_statistics);
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout_statistics);
        StatisticsPagerAdapter adapter = new StatisticsPagerAdapter(this);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: tab.setText("每日"); break;
                        case 1: tab.setText("每周"); break;
                        case 2: tab.setText("每月"); break;
                        case 3: tab.setText("每年"); break;
                        // 设置其他标签的文本
                    }
                }).attach();

        // 处理账单按钮点击事件
        Button btnBill = rootView.findViewById(R.id.btnBill);
        btnBill.setOnClickListener(view -> {
            // 隐藏ViewPager和TabLayout
            viewPager.setVisibility(View.GONE);
            tabLayout.setVisibility(View.GONE);

            // 替换Fragment
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new BillFragment(), "StatisticsFragment");
            transaction.addToBackStack(null);
            transaction.commit();

            // 由于fragment_container一开始是GONE，现在需要将其设置为VISIBLE
            getActivity().findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
        });


        return rootView;
    }

    public class StatisticsPagerAdapter extends FragmentStateAdapter {
        public StatisticsPagerAdapter(Fragment fragment) {
            super(fragment);
        }

        @Override
        public Fragment createFragment(int position) {
            // 返回对应位置的 Fragment。例如，您可以根据位置返回不同的 Fragment。
            switch (position) {
                case 0: return DailyStatisticsFragment.newInstance();
                case 1: return WeeklyStatisticsFragment.newInstance();
                case 2: return MonthlyStatisticsFragment.newInstance();
                case 3: return YearlyStatisticsFragment.newInstance();
                // 添加更多 case 以处理其他标签
                default: return new Fragment(); // 或返回默认 Fragment
            }
        }

        @Override
        public int getItemCount() {
            return 4; // 例如，如果有四个标签页（每日、每周、每月、每年）
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        // 确保ViewPager和TabLayout是可见的
        if (getView() != null) {
            getView().findViewById(R.id.view_pager_statistics).setVisibility(View.VISIBLE);
            getView().findViewById(R.id.tab_layout_statistics).setVisibility(View.VISIBLE);
        }
    }

    public void showViewPagerAndTabs() {
        // 显示ViewPager和TabLayout
        View rootView = getView();
        if (rootView != null) {
            rootView.findViewById(R.id.view_pager_statistics).setVisibility(View.VISIBLE);
            rootView.findViewById(R.id.tab_layout_statistics).setVisibility(View.VISIBLE);
        }
        // 同时隐藏fragment容器
        if (getActivity() != null) {
            View fragmentContainer = getActivity().findViewById(R.id.fragment_container);
            if (fragmentContainer != null) {
                fragmentContainer.setVisibility(View.GONE);
            }
        }
    }

}