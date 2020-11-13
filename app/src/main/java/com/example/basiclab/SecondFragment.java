package com.example.basiclab;

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

public class SecondFragment extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ColorData colorData = new ViewModelProvider(requireActivity()).get(ColorData.class);
        final View layout = view.findViewById(R.id.second_layout);
        layout.setBackgroundColor(colorData.color_frag2.getValue());

        Observer<Integer> numberObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer newInteger) {
                layout.setBackgroundColor(colorData.color_frag2.getValue());
            }
        };

        colorData.color_frag2.observe(getViewLifecycleOwner(), numberObserver);

        view.findViewById(R.id.next_frag2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment);
            }
        });

        view.findViewById(R.id.prev_frag2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_1:
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_global_FirstFragment);
                break;
            case R.id.action_2:
                break;
            case R.id.action_3:
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_global_ThirdFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}