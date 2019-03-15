package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start, stop;
    Boolean running = false;
     CountDownTimer countDownTimer;
    private TextView timer;
    private int time = 60000;
    private CountDownTimer Count;
    MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this , R.raw.a);

    public MainActivity(CountDownTimer count) {
        Count = count;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);
            timer = findViewById(R.id.Timer);
            start = findViewById(R.id.Start);


            countDownTimer = new CountDownTimer(time, 1000) {


                @Override
                public void onTick(long millisUntilFinished) {

                    timer.setText(String.format("%d", (millisUntilFinished /360000)%60)

                            +":"+String.format("%d", (millisUntilFinished /1000)%60));


                }

                @Override
                public void onFinish() {


                }
            };


            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    startStop();


                }
            });


        }

        private void startStop() {

            if (running) {
                start.setText("Start");
                StopTimer();
            } else {
                start.setText("Reset");
                StartTimer();
            }


        }

        private void StartTimer() {


            countDownTimer.start();
            mediaPlayer.start();
            running = true;
        }

        private void StopTimer() {


            countDownTimer.cancel();
            mediaPlayer.stop();
            timer.setText("00:00");

            running = false;

        }


    }


