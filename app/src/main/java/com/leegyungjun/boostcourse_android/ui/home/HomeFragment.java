package com.leegyungjun.boostcourse_android.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.leegyungjun.boostcourse_android.Fragment1;
import com.leegyungjun.boostcourse_android.Fragment2;
import com.leegyungjun.boostcourse_android.Fragment3;
import com.leegyungjun.boostcourse_android.PagerAdapter;
import com.leegyungjun.boostcourse_android.R;
import com.leegyungjun.boostcourse_android.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private PagerAdapter adapter;

    private Button button;
    private ViewPager2 pager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        pager = (ViewPager2) rootView.findViewById(R.id.pager);
        button = (Button) rootView.findViewById(R.id.button);

        pager.setOffscreenPageLimit(3); //캐싱해 놓는 프래그먼트 갯수 설정

        adapter = new PagerAdapter(getChildFragmentManager(), getLifecycle());

        Fragment1 fragment1 = new Fragment1();
        adapter.addItem(fragment1);

        Fragment2 fragment2 = new Fragment2();
        adapter.addItem(fragment2);

        Fragment3 fragment3 = new Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}