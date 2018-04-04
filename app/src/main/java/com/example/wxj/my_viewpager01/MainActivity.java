package com.example.wxj.my_viewpager01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.wxj.my_viewpager01.Fragement.Dt;
import com.example.wxj.my_viewpager01.Fragement.Lxr;
import com.example.wxj.my_viewpager01.Fragement.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        View.OnClickListener {
    private ViewPager mViewPager;
    private ImageView mMessage, mLxr, mDt;
    private List<Fragment> mFragementList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addFragement();
        mViewPager.setAdapter(new ViewFragementPageAdapter(getSupportFragmentManager()));

        /*实现其滑动*/
        mViewPager.addOnPageChangeListener(this);

        /*为底部导航图标注册监听事件*/
        mMessage.setOnClickListener(this);
        mLxr.setOnClickListener(this);
        mDt.setOnClickListener(this);
    }

    /*接口ViewPager.OnPageChangeListener中方法的重写,实现其滑动*/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        resetImageSelect();
        switch (position) {
            case 0:
                mMessage.setSelected(true);
                break;
            case 1:
                mLxr.setSelected(true);
                break;
            case 2:
                mDt.setSelected(true);
                break;

        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /*为底部导航图标注册监听事件*/
    @Override
    public void onClick(View view) {
        resetImageSelect();
        switch (view.getId()) {
            case R.id.img_message:
                mViewPager.setCurrentItem(0);
                mMessage.setSelected(true);
                break;
            case R.id.img_lxr:
                mViewPager.setCurrentItem(1);
                mLxr.setSelected(true);
                break;
            case R.id.img_dt:
                mViewPager.setCurrentItem(2);
                mDt.setSelected(true);
                break;
        }

    }

    /*创建自定义类ViewFragementPageAdapter继承FragmentPagerAdapter类*/
    public class ViewFragementPageAdapter extends FragmentPagerAdapter {

        public ViewFragementPageAdapter(FragmentManager fm) {
            super(fm);/*调用父类中的构造方法*/
        }

        @Override
        public Fragment getItem(int position) {
            return mFragementList.get(position);
        }

        @Override
        public int getCount() {
            return mFragementList.size();
        }
    }

    /*重置图片选择*/
    private void resetImageSelect() {
        mMessage.setSelected(false);
        mLxr.setSelected(false);
        mDt.setSelected(false);
    }

    private void addFragement() {
        mFragementList = new ArrayList<>();
        mFragementList.add(new Message());
        mFragementList.add(new Lxr());
        mFragementList.add(new Dt());

    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mMessage = (ImageView) findViewById(R.id.img_message);
        mLxr = (ImageView) findViewById(R.id.img_lxr);
        mDt = (ImageView) findViewById(R.id.img_dt);
    }
}
