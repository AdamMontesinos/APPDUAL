package com.example.appdual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void BuscarPeli(View view){
        Intent a = new Intent (this, BuscarPeli.class);
        startActivity(BuscarPeli);
    }

    public void Social(View view){
        Intent b = new Intent (this, Social.class);
        startActivity(Social);
    }

    public void Perfil(View view){
        Intent c = new Intent (this, Perfil.class);
        startActivity(Perfil);
    }
}