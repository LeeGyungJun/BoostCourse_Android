package com.leegyungjun.boostcourse_android.ui.review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.leegyungjun.boostcourse_android.Fragment1;
import com.leegyungjun.boostcourse_android.Fragment2;
import com.leegyungjun.boostcourse_android.Fragment3;
import com.leegyungjun.boostcourse_android.PagerAdapter;
import com.leegyungjun.boostcourse_android.R;
import com.leegyungjun.boostcourse_android.databinding.FragmentBookBinding;
import com.leegyungjun.boostcourse_android.databinding.FragmentListBinding;
import com.leegyungjun.boostcourse_android.databinding.FragmentReviewBinding;
import com.leegyungjun.boostcourse_android.ui.book.BookViewModel;
import com.leegyungjun.boostcourse_android.ui.list.ListViewModel;

public class ReviewFragment extends Fragment {

    private ReviewViewModel reviewFragment;
    private FragmentReviewBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reviewFragment = new ViewModelProvider(this).get(ReviewViewModel.class);

        binding = FragmentReviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}