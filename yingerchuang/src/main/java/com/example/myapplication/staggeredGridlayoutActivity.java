package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class staggeredGridlayoutActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<String> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mRecyclerView.setAdapter(new staggeredAdapter(mlist, this));

        //设置recyclerview的布局管理
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        //设置recyclerview的分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void init() {
        mlist = new ArrayList<String>();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        for (int i = 'A'; i < 'Z'; i++) {
            mlist.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
//            case R.id.action_gridview:
//                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//                break;
//            case R.id.action_listview:
//                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//                break;
//            case R.id.action_hor_gridview:
//                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
//                break;
//            case R.id.action_stagger:
//                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
