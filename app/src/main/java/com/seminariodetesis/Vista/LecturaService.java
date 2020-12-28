package com.seminariodetesis.Vista;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.TimeUnit;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LecturaService extends Service {

    private static final String TAG = "Sensor Service";

    public  static final  String INTENT_RECEIVER = "";
    public static final String INTENT_DATA_TIME = "TIME";


    public static int number = 0;



    private Intent intent;
    private int time;

    private boolean checkTimer;
    private Thread thread;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Notificaciones");


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Lectura service Creado");
        checkTimer = true;
        intent = new Intent(INTENT_RECEIVER);
        time = 0;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStarComand");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                while (time < 60) {
                    if (checkTimer) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (Exception e) {


                        }
                        time = time + 1;
                        updateUI(time);
                        Log.i(TAG, "onStarComand: " + time);
                    } else {
                        break;
                    }
                }

                Log.i(TAG, "Hilo secundario ha finalizado" + time);


                if (time == 60) {


                    number +=1;
                }

                stopSelf();
            }
        };
        thread = new Thread(runnable);
        thread.start();
        return Service.START_STICKY;
    }

    public void updateUI(int time) {
        intent.putExtra(INTENT_DATA_TIME, String.valueOf(time));

        sendBroadcast(intent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy");
        checkTimer = false;
    }
}

