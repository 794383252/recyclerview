package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> list;
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adapter=new myAdapter(list,this);
        listView.setAdapter(adapter);
    }

    private void init()
    {

        listView= (ListView) findViewById(R.id.listview);
        list=new ArrayList<String>();

        for (int i=0;i<10;i++)
        {
            list.add(i+"");
        }

    }

}
