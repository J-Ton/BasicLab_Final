package com.example.basiclab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class FirstFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        final View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ColorData colorData = new ViewModelProvider(requireActivity()).get(ColorData.class);
        final View layout = view.findViewById(R.id.first_layout);
        layout.setBackgroundColor(colorData.color_frag1.getValue());

        Observer<Integer> numberObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer newInteger) {
                layout.setBackgroundColor(colorData.color_frag1.getValue());
            }
        };

        colorData.color_frag1.observe(getViewLifecycleOwner(), numberObserver);

        view.findViewById(R.id.prev_frag1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment);
            }
        });

        view.findViewById(R.id.next_frag1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                break;
            case R.id.action_2:
                NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_global_SecondFragment);
                break;
            case R.id.action_3:
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_global_ThirdFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}