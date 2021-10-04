package com.leegyungjun.boostcourse_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CommentListActivity extends AppCompatActivity {

    private LinearLayout comment_write;
    private CommentViewAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);

        listView = (ListView) findViewById(R.id.listView);
        comment_write = (LinearLayout) findViewById(R.id.comment_write);

        adapter = new CommentViewAdapter();
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 4.2f));
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 3.5f));
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 2.5f));
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
        adapter.addItem(new CommentItem("augustinlist**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
        adapter.addItem(new CommentItem("augustinlist11**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));

        listView.setAdapter(adapter);



        //한줄평 작성하기 버튼
        comment_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWriteActivity();
            }
        });

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

    //한줄평 작성하기
    public void showCommentWriteActivity() {
        Intent intent = new Intent(getApplicationContext(), CommentWriteActivity.class);
        startActivityForResult(intent, 101);
    }
}