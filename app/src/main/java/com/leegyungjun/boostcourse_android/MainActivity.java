package com.leegyungjun.boostcourse_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button likeButton;
    private Button hateButton;
    private TextView likeCountText;
    private TextView hateCountText;
    private LinearLayout comment_write;
    private androidx.appcompat.widget.AppCompatButton comment_list;
    private ListView listView;

    public static CommentViewAdapter adapter = new CommentViewAdapter();

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
        comment_write = (LinearLayout) findViewById(R.id.comment_write);
        comment_list = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.comment_list);

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

        //한줄평 작성하기 버튼
        comment_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWriteActivity();
            }
        });

        //한줄평 모두보기 버튼
        comment_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentListActivity();
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
//        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.2f));
//        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
//        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 3.5f));
//        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 2.5f));
//        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
//        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
//        adapter.addItem(new CommentItem("augustin11**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));

        listView.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 101) {
            if (intent != null) {
                String contents = intent.getStringExtra("contents");
                Float rating = intent.getFloatExtra("rating", 0f);

                adapter.addItem(new CommentItem("augustin**", "10분전", contents, "0", rating));
                listView.setAdapter(adapter);
            }
        }
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

    //한줄평 작성하기
    public void showCommentWriteActivity() {
        Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
        startActivityForResult(intent, 101);
    }

    //한줄평 모두보기
    public void showCommentListActivity() {
        Intent intent = new Intent(getApplicationContext(), CommentListActivity.class);
        startActivityForResult(intent, 102);
    }
}