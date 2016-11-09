package com.gaohonglin.day43_01_coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.gaohonglin.day43_01_coordinatorlayout.Fragment.MyListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Fragment> list = new ArrayList<>();

    private String[] titles = {"电影", "电视剧", "综艺", "音乐"};

    private MyAdapter adapter;
    private TabLayout mTablelayout;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏系统标题栏

        setContentView(R.layout.activity_main);
        initView();

        //处理ViewPager的显示
        initPagerData();

        initPagerAdapter();

        mTablelayout.setupWithViewPager(mPager);
    }

    private void initPagerAdapter() {
        adapter = new MyAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);
    }

    private void initPagerData() {
        for (int i = 0; i < 4; i++) {
            list.add(MyListFragment.getInstance(titles[i]));
        }
    }

    private void initView() {
        mTablelayout = (TabLayout) findViewById(R.id.tablelayout);
        mPager = (ViewPager) findViewById(R.id.pager);
    }


    class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }
}