package com.seminariodetesis.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.seminariodetesis.MainActivity;
import com.seminariodetesis.R;

public class Sonido extends AppCompatActivity {

    private Button siguiente;
    private Button inicio;
    private Button sonido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);
        siguiente = (Button)findViewById(R.id.siguiente);
        inicio = (Button)findViewById(R.id.inicio);
        sonido = (Button)findViewById(R.id.reproducir);
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.casa);
       // no need to call prepare(); create() does that for you

        sonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Reproduciendo", Toast.LENGTH_SHORT).show();
            }
        });
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}