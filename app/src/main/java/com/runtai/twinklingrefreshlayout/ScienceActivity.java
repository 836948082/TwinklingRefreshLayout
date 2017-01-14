package com.runtai.twinklingrefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import com.runtai.twinklingrefreshlayout.adapter.ScienceAdapter;
import com.runtai.twinklingrefreshlibrary.Footer.LoadingView;
import com.runtai.twinklingrefreshlibrary.RefreshListenerAdapter;
import com.runtai.twinklingrefreshlibrary.TwinklingRefreshLayout;
import com.runtai.twinklingrefreshlibrary.header.SinaRefreshView;

public class ScienceActivity extends AppCompatActivity {

    private ScienceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        setupGridView((GridView) findViewById(R.id.gridView));

        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupGridView(GridView gridView) {
        final TwinklingRefreshLayout refreshLayout = (TwinklingRefreshLayout) findViewById(R.id.refresh);
        SinaRefreshView headerView = new SinaRefreshView(this);
        headerView.setArrowResource(R.drawable.arrow);
        headerView.setTextColor(0xff745D5C);
//        TextHeaderView headerView = (TextHeaderView) View.inflate(this,R.layout.header_tv,null);
        refreshLayout.setHeaderView(headerView);

        LoadingView loadingView = new LoadingView(this);
        refreshLayout.setBottomView(loadingView);

        adapter = new ScienceAdapter();
        gridView.setAdapter(adapter);
        adapter.refreshCard();

        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.refreshCard();
                        refreshLayout.finishRefreshing();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.loadMoreCard();
                        refreshLayout.finishLoadmore();
                    }
                }, 2000);
            }
        });
    }
}
