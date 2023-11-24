package com.exmaple2.hello_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClockViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClockViewFragment extends Fragment {
    public ClockViewFragment() {
        // Required empty public constructor
    }
    public static ClockViewFragment newInstance(String param1, String param2) {
        ClockViewFragment fragment = new ClockViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock_view_blank, container, false);
    }
}