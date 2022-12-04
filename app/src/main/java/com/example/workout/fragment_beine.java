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

public class fragment_beine extends Fragment {
    public static final String EXTRA_MESSAGE_mode = "com.example.workout.MESSAGE";
    public static final String EXTRA_MESSAGE_min = "com.example.workout.MESSAGE_min";
    public static final String EXTRA_MESSAGE_args = "com.example.workout.MESSAGE_args";


    private CheckBox situps;
    private CheckBox radfahren;
    private CheckBox beinheben;
    private CheckBox seitliches_beinheben;
    private CheckBox springen;
    private EditText min;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container == null) {
            return null;
        }

        View r_view = inflater.inflate(R.layout.fragment_beine, container, false);

        Button std_workout_btt = (Button) r_view.findViewById(R.id.button_beine);
        Button select_workout_btt = (Button) r_view.findViewById(R.id.workout_select_beine);
        situps = (CheckBox) r_view.findViewById(R.id.situps);
        radfahren = (CheckBox) r_view.findViewById(R.id.radfahren);
        seitliches_beinheben = (CheckBox) r_view.findViewById(R.id.seit_beinheben);
        beinheben = (CheckBox) r_view.findViewById(R.id.beine_anheben);
        springen = (CheckBox) r_view.findViewById(R.id.springen);
        min = (EditText) r_view.findViewById(R.id.minuten_beine);


        std_workout_btt.setOnClickListener(v -> {

            String arg = Parser.Parse_in(
                    true,
                    true,
                    true,
                    true,
                    true
            );

            Intent intent = new Intent(getActivity(), Workout_runner.class);
            intent.putExtra(EXTRA_MESSAGE_mode, "beine");

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
                    situps.isChecked(),
                    radfahren.isChecked(),
                    beinheben.isChecked(),
                    seitliches_beinheben.isChecked(),
                    springen.isChecked()
            );

            Intent intent = new Intent(getActivity(), Workout_runner.class);
            intent.putExtra(EXTRA_MESSAGE_mode, "beine");
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