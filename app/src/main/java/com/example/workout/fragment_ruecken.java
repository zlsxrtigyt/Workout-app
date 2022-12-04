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

public class fragment_ruecken extends Fragment {

    public static final String EXTRA_MESSAGE_mode = "com.example.workout.MESSAGE";
    public static final String EXTRA_MESSAGE_min = "com.example.workout.MESSAGE_min";
    public static final String EXTRA_MESSAGE_args = "com.example.workout.MESSAGE_args";


    private CheckBox superman;
    private CheckBox cobra;
    private CheckBox vogel;
    private CheckBox kamel;
    private CheckBox schieb_plank;
    private EditText min;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container == null) {
            return null;
        }

        View r_view = inflater.inflate(R.layout.fragment_ruecken, container, false);

        Button std_workout_btt = r_view.findViewById(R.id.button_ruecken);
        Button select_workout_btt = r_view.findViewById(R.id.workout_select_ruecken);
        superman = r_view.findViewById(R.id.superman);
        cobra = r_view.findViewById(R.id.cobra);
        vogel = r_view.findViewById(R.id.vogel);
        kamel = r_view.findViewById(R.id.kamel);
        schieb_plank = r_view.findViewById(R.id.schieb_plank);
        min = r_view.findViewById(R.id.Minuten_ruecken);


        std_workout_btt.setOnClickListener(v -> {

            String arg = Parser.Parse_in(
                    true,
                    true,
                    true,
                    true,
                    true
            );

            Intent intent = new Intent(getActivity(), Workout_runner.class);
            intent.putExtra(EXTRA_MESSAGE_mode, "ruecken");
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
                    superman.isChecked(),
                    cobra.isChecked(),
                    vogel.isChecked(),
                    kamel.isChecked(),
                    schieb_plank.isChecked()
            );

            Intent intent = new Intent(getActivity(), Workout_runner.class);
            intent.putExtra(EXTRA_MESSAGE_mode, "ruecken");
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