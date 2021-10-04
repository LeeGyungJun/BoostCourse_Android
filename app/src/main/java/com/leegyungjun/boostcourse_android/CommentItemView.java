package com.leegyungjun.boostcourse_android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentItemView extends LinearLayout {

    private TextView tv_id;
    private TextView tv_time;
    private TextView tv_comment;
    private TextView tv_like;
    private RatingBar ratingBar;

    public CommentItemView(Context context) {
        super(context);

        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_comment = (TextView) findViewById(R.id.tv_comment);
        tv_like = (TextView) findViewById(R.id.tv_like);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    }

    public void setId(String id) {
        tv_id.setText(id);
    }
    public void setTime(String time) {
        tv_time.setText(time);
    }
    public void setComment(String comment) {
        tv_comment.setText(comment);
    }
    public void setLikeCount(String like) {
        tv_like.setText(like);
    }
    public void setRatingBar(Float rating) {
        ratingBar.setRating(rating);
    }
}
