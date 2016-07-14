package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Administrator on 2016/7/14.
 */
public class myAdapter extends BaseAdapter {

    LayoutInflater inflate;
    Context mcontext;
    List<String> mlist;


    public myAdapter(List<String> list, Context context) {
        this.mlist = list;
        this.mcontext = context;
        inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder = new viewHolder();
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.item_list, null);
            holder.textView = (TextView) convertView.findViewById(R.id.list_item_textview);
            holder.button = (Button) convertView.findViewById(R.id.list_item_button);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        Log.i("ln", mlist.get(position));
        if (holder!=null) {
            holder.textView.setText(mlist.get(position));
        }
        return convertView;
    }

    class viewHolder {
        TextView textView;
        Button button;
    }

}
