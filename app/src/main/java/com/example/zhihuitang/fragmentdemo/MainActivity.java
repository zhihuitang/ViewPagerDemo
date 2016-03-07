package com.example.zhihuitang.fragmentdemo;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.TabPageIndicator;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        FourFragment.OnFragmentInteractionListener, OneFragment.OnFragmentInteractionListener,
        TwoFragment.OnFragmentInteractionListener,ThreeFragment.OnFragmentInteractionListener{

    private ViewPager viewPager;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private static final String[] TITLE = new String[] { "头条", "房产", "另一面", "女人",
            "财经", "数码", "情感", "科技" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化ViewPager
        InitViewPager();
        //初始化布局
        InitView();
    }

    private void InitView() {

        one         = (Button) findViewById(R.id.bt_one);
        two         = (Button) findViewById(R.id.bt_two);
        three       = (Button) findViewById(R.id.bt_three);
        four        = (Button) findViewById(R.id.bt_four);

        //设置点击监听
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        //将button中字体的颜色先按照点击第一个button的效果初始化
        one.setTextColor(Color.BLUE);
        two.setTextColor(Color.BLACK);
        three.setTextColor(Color.BLACK);
        four.setTextColor(Color.BLACK);
    }

    private void InitViewPager() {
        //获取ViewPager
        //创建一个FragmentPagerAdapter对象，该对象负责为ViewPager提供多个Fragment
        viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(
                getSupportFragmentManager()) {

            //获取第position位置的Fragment
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new OneFragment();
                        Log.d("tang", "new fragment 0");
                        break;
                    case 1:
                        fragment = new TwoFragment();
                        Log.d("tang", "new fragment 1");
                        break;
                    case 2:
                        fragment = new ThreeFragment();
                        Log.d("tang", "new fragment 2");
                        break;
                    case 3:
                        fragment = new FourFragment();
                        Log.d("tang", "new fragment 3");
                        break;
                }

                return fragment;
            }

            //该方法的返回值i表明该Adapter总共包括多少个Fragment
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return TITLE[position];
                //return super.getPageTitle(position);
            }
        };
        //为ViewPager组件设置FragmentPagerAdapter
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                //Log.d("tang", "OnPageChangeListener.onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("tang", "OnPageChangeListener.onPageSelected " + position);
                switch (position) {
                    //如果是点击的第一个button，那么就让第一个button的字体变为蓝色
                    //其他的button的字体的颜色变为黑色
                    case 0:
                        one.setTextColor(Color.BLUE);
                        two.setTextColor(Color.BLACK);
                        three.setTextColor(Color.BLACK);
                        four.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        one.setTextColor(Color.BLACK);
                        two.setTextColor(Color.BLUE);
                        three.setTextColor(Color.BLACK);
                        four.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        one.setTextColor(Color.BLACK);
                        two.setTextColor(Color.BLACK);
                        three.setTextColor(Color.BLUE);
                        four.setTextColor(Color.BLACK);
                        break;
                    case 3:
                        one.setTextColor(Color.BLACK);
                        two.setTextColor(Color.BLACK);
                        three.setTextColor(Color.BLACK);
                        four.setTextColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("tang", "OnPageChangeListener.onPageScrollStateChanged");
            }
        });


        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        indicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_one:
                viewPager.setCurrentItem(0);
                break;
            case R.id.bt_two:
                viewPager.setCurrentItem(1);
                break;
            case R.id.bt_three:
                viewPager.setCurrentItem(2);
                break;
            case R.id.bt_four:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
