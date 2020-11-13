package com.example.basiclab;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ColorData extends ViewModel {

    public final MutableLiveData<Integer> color_frag1 = new MutableLiveData<>(Color.WHITE);
    public final MutableLiveData<Integer> color_frag2 = new MutableLiveData<>(Color.WHITE);
    public final MutableLiveData<Integer> color_frag3 = new MutableLiveData<>(Color.WHITE);

}
