package com.camilordgz.entregable1_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

public class ScreenTwo extends AppCompatActivity {

    LinearLayout background;
    TextView greetUser;
    Button vibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_two);

        background = findViewById(R.id.background);
        greetUser = findViewById(R.id.userGreet);
        vibrate = findViewById(R.id.vibrate);

        Intent dashboard = getIntent();
        String usuario = dashboard.getStringExtra("username");

        greetUser.setText("Welcome to the Dashboard " + usuario);

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibratePhone();
            }
        });
    }

    public void vibratePhone() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(1000);
        }
    }
}