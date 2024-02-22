package com.camilordgz.entregable1_pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Vibrator;

public class ScreenOne extends AppCompatActivity {

    TextView welcomeText;
    EditText username, password;
    Button sendInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_one);

        welcomeText = findViewById(R.id.welcomeText);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        sendInfo = findViewById(R.id.sendInfo);

        sendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerInfo();
            }
        });
    }

    public void registerInfo() {
        String nombreUsuario = username.getText().toString();
        String contraseña = password.getText().toString();

        Intent dashboard = new Intent(ScreenOne.this, ScreenTwo.class);
        dashboard.putExtra("username", nombreUsuario);
        startActivity(dashboard);
    }


    //Genera una vibracion de 500 milisegundos en el telefono
    public void vibratePhone() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }

    //Se llama la funcion de vibracion cuando la app se vuelve a poner en enfoque
    @Override
    protected void onResume() {
        super.onResume();
        vibratePhone();
    }


}