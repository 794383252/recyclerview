package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.mViewHolder> {

    private LayoutInflater inflater;
    private Context mcontext;
    private List<String> mlist;

    public interface OnItemClickListener {
        void OnItemClick(View view, int pos);

        void OnItemLongClick(View view, int pos);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickLister(OnItemClickListener lister) {
        this.mOnItemClickListener = lister;
    }

    public SimpleAdapter(List<String> list, Context context) {
        this.mcontext = context;
        this.mlist = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SimpleAdapter.mViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        mViewHolder holder = new mViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final SimpleAdapter.mViewHolder mViewHolder, final int i) {
        mViewHolder.textView.setText(mlist.get(i));

        if (mOnItemClickListener != null) {
            mViewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnItemClickListener.OnItemClick(mViewHolder.textView, i);
                }
            });
            mViewHolder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.OnItemLongClick(mViewHolder.textView, i);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void addData(int pos) {
        mlist.add(pos, "insert one");
        notifyItemInserted(pos);
    }

    public void deleteData(int pos) {
        mlist.remove(pos);
        notifyItemRemoved(pos);
    }

    class mViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public mViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.list_text);
        }
    }

}

