package com.leegyungjun.boostcourse_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_main, container, false);

        likeButton = (Button) rootView.findViewById(R.id.likeButton);
        likeCountText = (TextView) rootView.findViewById(R.id.likeCountText);
        hateButton = (Button) rootView.findViewById(R.id.hateButton);
        hateCountText = (TextView) rootView.findViewById(R.id.hateCountText);
        comment_write = (LinearLayout) rootView.findViewById(R.id.comment_write);
        comment_list = (androidx.appcompat.widget.AppCompatButton) rootView.findViewById(R.id.comment_list);

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

        listView = (ListView) rootView.findViewById(R.id.listView);

        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));
        adapter.addItem(new CommentItem("augustin**", "10분전", getResources().getString(R.string.comment), "0", 4.5f));

        listView.setAdapter(adapter);


        return rootView;
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
        Intent intent = new Intent(getActivity(), CommentWriteActivity.class);
        startActivityForResult(intent, 101);
    }

    //한줄평 모두보기
    public void showCommentListActivity() {
        Intent intent = new Intent(getActivity(), CommentListActivity.class);
        startActivityForResult(intent, 102);
    }
}