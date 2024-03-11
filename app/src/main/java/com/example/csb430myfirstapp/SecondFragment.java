package com.example.csb430myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.csb430myfirstapp.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            int number = getArguments().getInt("myArg");
            TextView textViewHeader = view.findViewById(R.id.textview_header);
            String headerText = getResources().getString(R.string.randText);
            String formattedHeaderText = String.format(headerText, number);
            textViewHeader.setText(formattedHeaderText);

            TextView textViewRandom = view.findViewById(R.id.textview_random);
            Random random = new Random();
            int randomNumber = 0;
            if (number > 0) {
                randomNumber = random.nextInt(number + 1);
            }
            textViewRandom.setText(String.valueOf(randomNumber));
        }

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}