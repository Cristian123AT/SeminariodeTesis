package com.seminariodetesis.Modelo;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.seminariodetesis.Presentador.ListenerLogin;

public class ModelLoginImp implements ModelLogin {
    private ListenerLogin listenerLogin;
    private FirebaseAuth mAuth;

    public ModelLoginImp(ListenerLogin listenerLogin) {
        this.listenerLogin = listenerLogin;
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    listenerLogin.onSuccess();
                } else {

                    listenerLogin.onError("Usuario o password incorrecto");
                }

            }
        });
    }
}
