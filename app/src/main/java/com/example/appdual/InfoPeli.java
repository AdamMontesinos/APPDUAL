package com.example.appdual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdual.Class.Film;
import com.example.appdual.Class.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InfoPeli extends AppCompatActivity {

    ArrayList<Film> ElementPeli;
    protected String data = "";
    protected Activity activity;

    ImageView PortadaViewImagen;
    TextView NomView2Info,Overview2Info,Rating2Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peli);

        PortadaViewImagen = findViewById(R.id.PortadaView2);
        NomView2Info = findViewById(R.id.NomView2);
        Overview2Info = findViewById(R.id.Overview2);
        Rating2Info = findViewById(R.id.Rating2);
    }

    protected void onPostExecute(Void aVoid){
        JSONObject jObject = null;

        try {
            jObject = new JSONObject(data);
            ElementPeli = new ArrayList<>();

            JSONArray results = new JSONArray(jObject.getString("results"));
            for(int i=0; i<results.length(); i++){
                JSONObject movie = new JSONObject(results.getString(i));
                String title  = movie.getString("title");
                String posterPath = movie.getString("poster_path");
                String backdropPath = movie.getString("backdrop_path");
                String voteAverage = movie.getString("vote_average");

                Log.i("logTest",  title);

                ElementPeli.add(new Film(title, posterPath, backdropPath, voteAverage));
            }

            RecyclerAdapter myAdapter = new RecyclerAdapter(activity,ElementPeli);
            RecyclerView recyclerView = activity.findViewById(R.id.recyclerview);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}