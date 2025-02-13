package com.exmaple2.play_task;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.exmaple2.play_task.data.SharedViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private SharedViewModel sharedViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取ViewPager2和BottomNavigationView
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 创建适配器
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(fragmentAdapter);

        // 设置BottomNavigationView的选择监听器
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navigation_task) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (itemId == R.id.navigation_bonus) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (itemId == R.id.navigation_statistics) {
                    viewPager.setCurrentItem(2);
                    return true;
                } else if (itemId == R.id.navigation_me) {
                    viewPager.setCurrentItem(3);
                    return true;
                }
                return false;
            }
        });
    }

    private class FragmentAdapter extends FragmentStateAdapter {
        private static final int NUM_TABS = 4;

        public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // 根据位置返回对应的Fragment实例
            switch (position) {
                case 0:
                    return new TaskFragment();
                case 1:
                    return new BonusFragment();
                case 2:
                    return new StatisticsFragment();
                case 3:
                    return new MeFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_TABS;
        }
    }
    @Override
    public void onBackPressed() {
        // 获取当前显示的Fragment
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (currentFragment instanceof BillFragment) {
            // 当前是BillFragment时，执行回退操作
            super.onBackPressed();
            // 调用方法显示统计界面的内容
            showStatisticsContent();
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            // 如果回退栈中还有其他Fragment，则正常处理回退操作
            getSupportFragmentManager().popBackStack();
        } else {
            // 否则，执行默认的回退操作
            super.onBackPressed();
        }
    }

    // MainActivity中的 showStatisticsContent() 方法
    public void showStatisticsContent() {
        // 显示ViewPager和TabLayout
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout_statistics);
        if (viewPager != null && tabLayout != null) {
            viewPager.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.VISIBLE);
        }

    }

    // 用于加载StatisticsFragment的方法
    public void loadStatisticsFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new StatisticsFragment(), "StatisticsFragmentTag");
        transaction.addToBackStack(null); // 将其加入到返回栈中
        transaction.commit();
    }

}
