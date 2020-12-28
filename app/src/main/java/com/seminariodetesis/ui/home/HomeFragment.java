package com.seminariodetesis.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.seminariodetesis.IComunicaFragments;
import com.seminariodetesis.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Activity actividad;
    CardView velocidadLectora, Actividades, RelacionarSonidos, RelacionarPalabras, Observar, ver_aviso;
    IComunicaFragments interfaceComunicaFragments;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        View vista = inflater.inflate(R.layout.fragment_home, container, false);
        velocidadLectora = vista.findViewById(R.id.velocidadLectora);
        velocidadLectora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaFragments.velocidadLectora();
            }
        });
        //return vista;
        Actividades = vista.findViewById(R.id.actividades);
        Actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaFragments.Actividades();
            }
        });
        //return vista;
        RelacionarSonidos = vista.findViewById(R.id.escuchar);
        RelacionarSonidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaFragments.RelacionarSonidos();
            }
        });
        //return vista;
        RelacionarPalabras = vista.findViewById(R.id.observar);
        RelacionarPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaFragments.RelacionarPalabras();
            }
        });

        Observar = vista.findViewById(R.id.observar);
        Observar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceComunicaFragments.CompletarPalabras();
            }
        });


        return vista;


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            actividad = (Activity) context;
            interfaceComunicaFragments = (IComunicaFragments) actividad;
        }
    }
}