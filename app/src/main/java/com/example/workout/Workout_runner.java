package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Workout_runner extends AppCompatActivity {

    private int min;
    private int ms;
    private String mode;
    private String args_str;

    public int getms() {
        return min * 60000;
    }

    private TextView TextViewCountDown;
    private Button ButtonStartPause;
    private ImageView curr_workout;
    private TextView curr_workout_name;

    private android.os.CountDownTimer CountDownTimer;

    private boolean TimerRunning;
    private long TimeLeftInMillis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_runner);

        Intent intent = getIntent();
        mode = intent.getStringExtra(fragment_beine.EXTRA_MESSAGE_mode);
        min = intent.getIntExtra(fragment_beine.EXTRA_MESSAGE_min, 5);

        ms = getms();
        args_str = intent.getStringExtra(fragment_beine.EXTRA_MESSAGE_args);

        TimeLeftInMillis = ms;

        TextViewCountDown = findViewById(R.id.textView_countdown);
        ButtonStartPause = findViewById(R.id.start_stop);
        curr_workout = (ImageView) findViewById(R.id.Current_training);
        curr_workout_name = (TextView) findViewById(R.id.curr_workout_name);

        ButtonStartPause.setOnClickListener(v -> {
            if (TimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        if(mode.equals("arme")){
            String[] args = Parser.Parse_out(args_str);


            ThreadMaker.background(() -> {
                long timer = 0;
                while(TimeLeftInMillis != 0) {
                    if (args[0].equals("Situps")) {
                        curr_workout.setImageResource(R.drawable.liegestuetz);
                        curr_workout_name.setText("Liegestütze");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }
                            Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("Error");
                        }

                    }
                    if (args[1].equals("Radfahren")) {
                        curr_workout.setImageResource(R.drawable.diamond);
                        curr_workout_name.setText("Diamond");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (args[2].equals("Beinheben")) {
                        curr_workout.setImageResource(R.drawable.dips);
                        curr_workout_name.setText("Dips");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (args[3].equals("SeitlichesBeinheben")) {
                        curr_workout.setImageResource(R.drawable.plank);
                        curr_workout_name.setText("Plank");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (args[4].equals("Springen")) {
                        curr_workout.setImageResource(R.drawable.strudeln);
                        curr_workout_name.setText("Strudeln");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        if(mode.equals("beine")){
                String[] args = Parser.Parse_out(args_str);

                ThreadMaker.background(() -> {
                    long timer = 0;
                    while(TimeLeftInMillis != 0) {
                        if (args[0].equals("Situps")) {
                            curr_workout.setImageResource(R.drawable.situps2);
                            curr_workout_name.setText("Situps");
                            try {
                                Thread.sleep(10000);
                                while(!TimerRunning) {
                                    Thread.sleep(1000);
                                    timer++;
                                }Thread.sleep(timer*1000);
                                timer = 0;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                System.out.println("Error");
                            }
                        }
                        if (args[1].equals("Radfahren")) {
                            curr_workout.setImageResource(R.drawable.radfahren2);
                            curr_workout_name.setText("Radfahren");
                            try {
                                Thread.sleep(10000);
                                while(!TimerRunning) {
                                    Thread.sleep(1000);
                                    timer++;
                                }Thread.sleep(timer*1000);
                                timer = 0;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (args[2].equals("Beinheben")) {
                            curr_workout.setImageResource(R.drawable.beine_anheben2);
                            curr_workout_name.setText("Beinheben");
                            try {
                                Thread.sleep(10000);
                                while(!TimerRunning) {
                                    Thread.sleep(1000);
                                    timer++;
                                }Thread.sleep(timer*1000);
                                timer = 0;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (args[3].equals("SeitlichesBeinheben")) {
                            curr_workout.setImageResource(R.drawable.seitliches_beinheben2);
                            curr_workout_name.setText("Seitliches");
                            try {
                                Thread.sleep(10000);
                                while(!TimerRunning) {
                                    Thread.sleep(1000);
                                    timer++;
                                }Thread.sleep(timer*1000);
                                timer = 0;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (args[4].equals("Springen")) {
                            curr_workout.setImageResource(R.drawable.springen2);
                            curr_workout_name.setText("Springen");
                            try {
                                Thread.sleep(10000);
                                while(!TimerRunning) {
                                    Thread.sleep(1000);
                                    timer++;
                                }Thread.sleep(timer*1000);
                                timer = 0;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
        }







        if(mode.equals("ruecken")){
            String[] args = Parser.Parse_out(args_str);

            ThreadMaker.background(() -> {
                int timer = 0;

                while(TimeLeftInMillis != 0) {
                    if (args[0].equals("Situps")) {
                        curr_workout.setImageResource(R.drawable.cobra);
                        curr_workout_name.setText("Cobra");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("Error");
                        }
                    }
                    if (args[1].equals("Radfahren")) {
                        curr_workout.setImageResource(R.drawable.superman);
                        curr_workout_name.setText("Superman");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {                  //Nicht verwirren lassen, ich wollte keine neue methode(Parser) schreiben
                            e.printStackTrace();                            //deswegen heißen die jetzt gleich
                        }
                    }
                    if (args[2].equals("Beinheben")) {
                        curr_workout.setImageResource(R.drawable.vogel);
                        curr_workout_name.setText("Vogel");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (args[3].equals("SeitlichesBeinheben")) {
                        curr_workout.setImageResource(R.drawable.schieb_plank);
                        curr_workout_name.setText("Schieb-Plank");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (args[4].equals("Springen")) {
                        curr_workout.setImageResource(R.drawable.kamel);
                        curr_workout_name.setText("Kamel");
                        try {
                            Thread.sleep(10000);
                            while(!TimerRunning) {
                                Thread.sleep(1000);
                                timer++;
                            }Thread.sleep(timer*1000);
                            timer = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }




    }

    private void startTimer() {
        CountDownTimer = new CountDownTimer(TimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                TimerRunning = false;
                ButtonStartPause.setText("Start");
            }
        }.start();

        TimerRunning = true;
        ButtonStartPause.setText("Pause");

    }

    private void pauseTimer() {
        CountDownTimer.cancel();
        TimerRunning = false;
        ButtonStartPause.setText("Start");
    }

    public void BeineRunner() {


    }

    private void updateCountDownText() {
        int minutes = (int) (TimeLeftInMillis / 1000) / 60;
        int seconds = (int) (TimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);

        TextViewCountDown.setText(timeLeftFormatted);
        TextViewCountDown.setText(timeLeftFormatted);
    }
}