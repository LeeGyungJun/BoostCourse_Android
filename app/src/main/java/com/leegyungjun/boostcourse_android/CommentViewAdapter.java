package com.leegyungjun.boostcourse_android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CommentViewAdapter extends BaseAdapter {
    private ArrayList<CommentItem> items = new ArrayList<CommentItem>();

    public void addItem(CommentItem item) {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentItemView view = new CommentItemView(parent.getContext());

        CommentItem item = items.get(position);
        view.setId(item.getId());
        view.setTime(item.getTime());
        view.setComment(item.getComment());
        view.setLikeCount(item.getLikeCount());
        view.setRatingBar(item.getRating());
        return view;
    }
}
