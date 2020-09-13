package com.example.reminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.reminder.adapter.ViewPagerAdapter;
import com.example.reminder.database.MyDatabaseHelper;
import com.example.reminder.ui.create.CreateActivity;
import com.example.reminder.ui.histories.HistoriesFragment;
import com.example.reminder.ui.follow.FollowFragment;
import com.example.reminder.ui.setting.SettingFragment;
import com.example.reminder.ui.work.WorkFragment;
import com.example.reminder.utils.Binh;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private MenuItem prevMenuItem;
    private HistoriesFragment historiesFragment;
    private FollowFragment followFragment;
    private WorkFragment workFragment;
    private SettingFragment settingFragment;
    private ImageButton btnCreateEvent;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this);
        init();
        initEvent();
        bottmNavigationView();
        viewpagerShow();
    }

    private void initEvent() {
        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), CreateActivity.class));
            }
        });
    }

    private void viewpagerShow() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);
    }

    private void bottmNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.workId:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.homeId:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.historyId:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.profileId:
                        viewPager.setCurrentItem(3);
                        break;
                }

                return false;
            }
        });
    }


    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        followFragment = new FollowFragment();
        historiesFragment = new HistoriesFragment();
        workFragment = new WorkFragment();
        settingFragment = new SettingFragment();
        adapter.addFragment(workFragment);
        adapter.addFragment(followFragment);
        adapter.addFragment(historiesFragment);
        adapter.addFragment(settingFragment);
        viewPager.setAdapter(adapter);

    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottomId);
        viewPager = findViewById(R.id.viewpager);
        btnCreateEvent = findViewById(R.id.btnCreateEvent);
    }
}
