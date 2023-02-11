package com.example.gztruyen.ui.truyentranh;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gztruyen.R;
import com.example.gztruyen.databinding.FragmentTruyenChuBinding;
import com.example.gztruyen.databinding.FragmentTruyenTranhBinding;

public class TruyenTranhFragment extends Fragment {

    private FragmentTruyenTranhBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TruyenTranhViewModel viewModel =
                new ViewModelProvider(this).get(TruyenTranhViewModel.class);

        binding = FragmentTruyenTranhBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTranh;
        viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}