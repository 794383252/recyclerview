package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/14.
 */
public class staggeredAdapter extends RecyclerView.Adapter<staggeredAdapter.mViewHolder> {
    private LayoutInflater inflater;
    private Context mcontext;
    private List<String> mlist;
    private List<Integer> mHeight;

    public staggeredAdapter(List<String> list, Context context) {
        this.mcontext = context;
        this.mlist = list;
        inflater = LayoutInflater.from(context);
        mHeight=new  ArrayList<Integer>();
        for (int i=0;i<mlist.size();i++)
        {
            mHeight.add((int) (100+Math.random()*300));
        }
    }

    @Override
    public staggeredAdapter.mViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        mViewHolder holder = new mViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(staggeredAdapter.mViewHolder mViewHolder, int i) {
        ViewGroup.LayoutParams lp=mViewHolder.itemView.getLayoutParams();
        lp.height=mHeight.get(i);
        mViewHolder.itemView.setLayoutParams(lp);
        mViewHolder.textView.setText(mlist.get(i));
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public mViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.list_text);
        }
    }

}
