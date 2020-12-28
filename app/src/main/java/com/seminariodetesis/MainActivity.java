package com.seminariodetesis;

 import android.content.Intent;
import android.os.Bundle;
 import android.util.Log;
 import android.view.ContextMenu;
 import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
 import android.view.View;
 import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.ValueEventListener;
 import com.seminariodetesis.Vista.Completar;
 import com.seminariodetesis.Vista.LetraInvertida;
 import com.seminariodetesis.Vista.Login;
 import com.seminariodetesis.Vista.Sonido;
 import com.seminariodetesis.Vista.VelocidadLectora;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements  IComunicaFragments {

    FirebaseAuth firebaseAuth;
    protected String usuario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        firebaseAuth = FirebaseAuth.getInstance();


        


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tesis_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.salir:

                System.exit(0);

                return (true);

            case R.id.logout:
                firebaseAuth.signOut();
                startActivity(new Intent(this, Login.class));
                return (true);


        }
        return (super.onOptionsItemSelected(item));
    }




    @Override
    public void velocidadLectora() {
        Intent intent = new Intent(this, VelocidadLectora.class);

        intent.putExtra("Tipo","VELOCIDAD LECTORA");
        startActivity(intent);
    }

    @Override
    public void Actividades() {
        Intent intent = new Intent(this, LetraInvertida.class);
        startActivity(intent);
    }

    @Override
    public void CompletarPalabras() {
        Intent intent = new Intent(this, Completar.class);
        startActivity(intent);
    }

    @Override
    public void RelacionarPalabras() {

    }

    @Override
    public void RelacionarSonidos() {
        Intent intent = new Intent(this, Sonido.class);
        startActivity(intent);
    }

    @Override
    public void Otros() {
        
    }
}