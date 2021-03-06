package com.runtai.twinklingrefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.runtai.twinklingrefreshlibrary.RefreshListenerAdapter;
import com.runtai.twinklingrefreshlibrary.TwinklingRefreshLayout;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        TwinklingRefreshLayout refreshLayout = (TwinklingRefreshLayout) findViewById(R.id.refresh);
//        ProgressLayout header = new ProgressLayout(this);
//        refreshLayout.setHeaderView(header);
//        refreshLayout.setFloatRefresh(true);
        refreshLayout.setOverScrollRefreshShow(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                }, 4000);
            }
        });
    }
}
