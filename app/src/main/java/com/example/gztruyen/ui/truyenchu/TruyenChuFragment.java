package com.example.gztruyen.ui.truyenchu;

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

public class TruyenChuFragment extends Fragment {
    private FragmentTruyenChuBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TruyenChuViewModel viewModel =
                new ViewModelProvider(this).get(TruyenChuViewModel.class);

        binding = FragmentTruyenChuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.text;
        viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}