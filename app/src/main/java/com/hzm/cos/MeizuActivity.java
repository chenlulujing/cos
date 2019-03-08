package com.hzm.cos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MeizuActivity extends AppCompatActivity {

    protected TextView mTv;
//    protected NestedScrollView mNestedScrollView;
    protected ImageView mBack;
    protected CoordinatorLayout mCood;


    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
//        mNestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        mBack = (ImageView) findViewById(R.id.back);
        mCood = (CoordinatorLayout) findViewById(R.id.cood);

        Fragment fragment = new MyFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment).commitAllowingStateLoss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.dialog_layout);
        initView();

//        CoordinatorLayout.LayoutParams param = (CoordinatorLayout.LayoutParams) mNestedScrollView.getLayoutParams();
//        final RcvBehavior behavior = (RcvBehavior) param.getBehavior();

//        behavior.setListener(new OnRcvListener() {
//            @Override
//            public void onFinsh() {
//                MeizuActivity.this.finish();
//            }
//
//            @Override
//            public void onOpen() {
//
//            }
//
//            @Override
//            public void onTop() {
//                mBack.setImageResource(R.mipmap.down);
//            }
//
//            @Override
//            public void onLeaveTop() {
//                mBack.setImageResource(R.mipmap.left);
//            }
//        });
//        mBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                behavior.handleLastMove(true);
//            }
//        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                mCood.setBackgroundColor(Color.parseColor("#87000000"));
            }
        },0);

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.out_to_down, R.anim.out_to_down);
    }
}
