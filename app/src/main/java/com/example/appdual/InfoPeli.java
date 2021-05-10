package com.example.appdual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdual.Class.Film;
import com.example.appdual.Class.RecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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

    boolean comprobacio = true;

    protected ImageButton guardar;
    protected ArrayList<Film> PelisSubidas;

    DatabaseReference db;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peli);

        Intent intent = getIntent();
        //Necesari Serializable en Objecte
        Film peli = (Film) intent.getSerializableExtra("peli");

        Log.i("logTest", "------------------_>" + peli.getNombrepeli());

        guardar = findViewById(R.id.btnguardar);

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

        PelisSubidas = new ArrayList<Film>();

        db = FirebaseDatabase.getInstance().getReference().child("Films");

        existePeliSerie(peli);

        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (comprobacio) {
                    db.child(Integer.toString(peli.getId())).removeValue();
                    //Cambio imagen
                    comprobacio = false;
                } else {
                    db.child(Integer.toString(peli.getId())).setValue(peli);
                    //Cambio imagen
                    comprobacio = true;
                }
            }
        });

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("logTest ", "" + dataSnapshot.getChildrenCount());

                PelisSubidas.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Film pelicula = postSnapshot.getValue(Film.class);
                    PelisSubidas.add(pelicula);
                    Log.i("logTest", pelicula.getNombrepeli());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i("logTest", "Failed to read value.", error.toException());
            }
        });


    }
    public void existePeliSerie (Film peli){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        db = FirebaseDatabase.getInstance().getReference().child("Films");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.hasChild(Integer.toString(peli.getId()))) {
                    comprobacio = false;
                } else {
                    comprobacio = true;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}