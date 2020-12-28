package com.seminariodetesis.Vista;


import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.seminariodetesis.MainActivity;
import com.seminariodetesis.R;

import static com.seminariodetesis.Vista.LecturaService.INTENT_DATA_TIME;
import static com.seminariodetesis.Vista.LecturaService.INTENT_RECEIVER;

public class VelocidadLectora2 extends AppCompatActivity {



    BroadcastReceiver broadcastReceiver;
    private TextView textView;
    private TextView texto;
    private Intent intent;
    public Context context;
    private Button siguiente;
    private Button inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad_lectora2);
        final String tipo = getIntent().getStringExtra("Tipo");
        this.setTitle(tipo);

        textView = (TextView) findViewById(R.id.reloj );
        texto = (TextView)findViewById(R.id.parrafo);
        siguiente = (Button)findViewById(R.id.siguiente);
        inicio = (Button)findViewById(R.id.inicio);


        context = getApplicationContext();
        intent = new Intent(getApplicationContext(), LecturaService.class);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String dataTime = intent.getStringExtra(INTENT_DATA_TIME);
                textView.setText(dataTime);

                Integer time = Integer.parseInt(dataTime);
                if (time <= 10 && time > 0) {

                } else if (time == 0) {

                }
            }

        };
        stopService(intent);
        startService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        //SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        //sm.unregisterListener(mySensorEventListener);
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(INTENT_RECEIVER));
        //SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        //sm.unregisterListener(mySensorEventListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(broadcastReceiver);
    }



}