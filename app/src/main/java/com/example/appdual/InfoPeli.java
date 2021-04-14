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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peli);

        Intent intent = getIntent();
        //Necesari Serializable en Objecte
        Film peli = (Film) intent.getSerializableExtra("peli");

        Log.i("logTest", "------------------_>" + peli.getNombrepeli());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView PortadaPeliGran;
        TextView myText2;
        TextView myRating2;
        TextView myDate;
        TextView myOverview2;

        public MyViewHolder (@NonNull View itemView){
            super(itemView);
            myText2 = itemView.findViewById(R.id.NomView2);
            myRating2 = itemView.findViewById(R.id.Rating2);
            myDate = itemView.findViewById(R.id.Release2);
            myOverview2 = itemView.findViewById(R.id.Overview2);
            PortadaPeliGran = itemView.findViewById(R.id.PortadaView2);
        }

        public void bindData(Film film) {

            myText2.setText((film.getNombrepeli()));
            myRating2.setText((film.getRating()));
            myDate.setText((film.getReleaseDate()));
            myOverview2.setText((film.getOverview()));

            String urlImg = "https://image.tmdb.org/t/p/original/" + film.getPoster_path();
            Picasso.get().load(urlImg).into(PortadaPeliGran);
        }
    }

}