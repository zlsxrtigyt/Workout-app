package com.example.workout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class fragment_arme extends Fragment {

    public static final String EXTRA_MESSAGE_mode = "com.example.workout.MESSAGE";
    public static final String EXTRA_MESSAGE_min = "com.example.workout.MESSAGE_min";
    public static final String EXTRA_MESSAGE_args = "com.example.workout.MESSAGE_args";


    private CheckBox liegstuez;
    private CheckBox diamond;
    private CheckBox dips;
    private CheckBox plank;
    private CheckBox fragezeichen;
    private EditText min;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(container == null) {
            return null;
        }
        View r_view = inflater.inflate(R.layout.fragment_arme, container, false);

        Button std_workout_btt = (Button) r_view.findViewById(R.id.button_arme);
        Button select_workout_btt = (Button) r_view.findViewById(R.id.workout_select_arme);
        liegstuez = (CheckBox) r_view.findViewById(R.id.liegestuetze);
        diamond = (CheckBox) r_view.findViewById(R.id.diamond_pushups);
        dips = (CheckBox) r_view.findViewById(R.id.dips);
        plank = (CheckBox) r_view.findViewById(R.id.plank);
        fragezeichen = (CheckBox) r_view.findViewById(R.id.fragezeichen);
        min = (EditText) r_view.findViewById(R.id.Minuten_arme);


        std_workout_btt.setOnClickListener(v -> {

            String arg = Parser.Parse_in(
                    true,
                    true,
                    true,
                    true,
                    true
            );

            Intent intent = new Intent(getActivity(), Workout_runner.class);
            intent.putExtra(EXTRA_MESSAGE_mode, "arme");
            if(min.getText().toString().equals("")) {
                intent.putExtra(EXTRA_MESSAGE_min, "5");
            } else {
                intent.putExtra(EXTRA_MESSAGE_min, min.getText().toString());
            }
            intent.putExtra(EXTRA_MESSAGE_args, arg);

            startActivity(intent);

        });

        select_workout_btt.setOnClickListener(v -> {

            String arg = Parser.Parse_in(
                    liegstuez.isChecked(),
                    diamond.isChecked(),
                    dips.isChecked(),
                    plank.isChecked(),
                    fragezeichen.isChecked()
            );

            Intent intent = new Intent(getActivity(), Workout_runner.class);
            intent.putExtra(EXTRA_MESSAGE_mode, "arme");
            if(min.getText().toString().equals("")) {
                intent.putExtra(EXTRA_MESSAGE_min, "5");
            } else {
                intent.putExtra(EXTRA_MESSAGE_min, min.getText().toString());
            }
            intent.putExtra(EXTRA_MESSAGE_args, arg);

            startActivity(intent);

        });

        return r_view;
    }
}