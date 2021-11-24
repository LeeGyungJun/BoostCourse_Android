package com.leegyungjun.boostcourse_android.ui.list;

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
import com.leegyungjun.boostcourse_android.Fragment4;
import com.leegyungjun.boostcourse_android.Fragment5;
import com.leegyungjun.boostcourse_android.Fragment6;
import com.leegyungjun.boostcourse_android.PagerAdapter;
import com.leegyungjun.boostcourse_android.R;
import com.leegyungjun.boostcourse_android.databinding.FragmentListBinding;

public class ListFragment extends Fragment {

    private ListViewModel listViewModel;
    private FragmentListBinding binding;

    private PagerAdapter adapter;

    private Button button;
    private ViewPager2 pager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        pager = (ViewPager2) rootView.findViewById(R.id.pager);
        button = (Button) rootView.findViewById(R.id.button);


        adapter = new PagerAdapter(getActivity().getSupportFragmentManager(), getLifecycle());

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();
        Fragment5 fragment5 = new Fragment5();
        Fragment6 fragment6 = new Fragment6();

        adapter.addItem(fragment1);
        adapter.addItem(fragment2);
        adapter.addItem(fragment3);
        adapter.addItem(fragment4);
        adapter.addItem(fragment5);
        adapter.addItem(fragment6);

        pager.setOffscreenPageLimit(6); //캐싱해 놓는 프래그먼트 갯수 설정
        pager.setClipToPadding(false);
        pager.setPadding(120,0,120,0);

        pager.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}