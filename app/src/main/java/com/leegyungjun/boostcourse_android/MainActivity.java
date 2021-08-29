package com.leegyungjun.boostcourse_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button likeButton, hateButton;
    private TextView likeCountText, hateCountText;

    private Boolean likeState = false;
    private Boolean hateState = false;
    private int likeCount = 0;
    private int hateCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button) findViewById(R.id.likeButton);
        likeCountText = (TextView) findViewById(R.id.likeCountText);
        hateButton = (Button) findViewById(R.id.hateButton);
        hateCountText = (TextView) findViewById(R.id.hateCountText);

        //좋아요 버튼
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likeState) decrLikeCount();
                else increLikeCount();
                likeState = !likeState;
            }
        });

        //싫어요 버튼
        hateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hateState) decrHateCount();
                else incrHateCount();
                hateState = !hateState;
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);
        CommentViewAdapter adapter = new CommentViewAdapter();

        adapter.addItem(new CommentItem("augustin**","10분전",getResources().getString(R.string.comment),"0"));
        adapter.addItem(new CommentItem("augustin**","10분전",getResources().getString(R.string.comment),"0"));
        adapter.addItem(new CommentItem("augustin**","10분전",getResources().getString(R.string.comment),"0"));
        adapter.addItem(new CommentItem("augustin**","10분전",getResources().getString(R.string.comment),"0"));
        adapter.addItem(new CommentItem("augustin111**","10분전",getResources().getString(R.string.comment),"0"));

        listView.setAdapter(adapter);

    }

    //좋아요 증가
    public void increLikeCount() {
        likeCount++;
        likeCountText.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
        if(hateState) {
            decrHateCount();
            hateState = !hateState;
        }
    }

    //좋아요 감소
    public void decrLikeCount() {
        likeCount--;
        likeCountText.setText(String.valueOf(likeCount));
        likeButton.setBackgroundResource(R.drawable.thumb_up);
    }

    //싫어요 증가
    public void incrHateCount() {
        hateCount++;
        hateCountText.setText(String.valueOf(hateCount));
        hateButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
        if(likeState) {
            decrLikeCount();
            likeState = !likeState;
        }
    }

    //싫어요 감소
    public void decrHateCount() {
        hateCount--;
        hateCountText.setText(String.valueOf(hateCount));
        hateButton.setBackgroundResource(R.drawable.thumb_down);
    }
}