package com.example.appdual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdual.Class.Film;
import com.example.appdual.Class.RecyclerAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InfoPeli extends AppCompatActivity {
    ImageView PortadaPeliGran;
    TextView myText2;
    TextView myRating2;
    TextView myDate;
    TextView myOverview2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peli);

        Intent intent = getIntent();
        //Necesari Serializable en Objecte
        Film peli = (Film) intent.getSerializableExtra("peli");

        Log.i("logTest", "------------------_>" + peli.getNombrepeli());

        myText2 = findViewById(R.id.NomView2);
        myRating2 = findViewById(R.id.Rating2);
        myDate = findViewById(R.id.Release2);
        myOverview2 = findViewById(R.id.Overview2);
        PortadaPeliGran = findViewById(R.id.PortadaView2);

        myText2.setText(peli.getNombrepeli());
        myRating2.setText(peli.getRating());
        myDate.setText(peli.getReleaseDate());
        myOverview2.setText(peli.getOverview());

        String urlImg = "https://image.tmdb.org/t/p/original/" + peli.getBackdrop_path();
        Picasso.get().load(urlImg).into(PortadaPeliGran);
    }
}