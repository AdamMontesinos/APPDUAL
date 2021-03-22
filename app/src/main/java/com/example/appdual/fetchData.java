package com.example.appdual;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.appdual.Class.Film;
import com.example.appdual.Class.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class fetchData extends AsyncTask<Void, Void, Void> {

    protected String data = "";
    protected String dataResults = "";
    protected String movie;

    public fetchData(String movie) {
        this.movie = movie;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //Make API connection with key
            URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=9c29bf62bcb9b9eb53965e3ed808540e&query=" + movie.replaceAll(" ", "+"));
            Log.i("logtest", "https://api.themoviedb.org/3/search/movie?api_key=9c29bf62bcb9b9eb53965e3ed808540e&query=" + movie.replaceAll(" ", "+"));

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // Read API results
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sBuilder = new StringBuilder();

            // Build JSON String
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }

            inputStream.close();
            data = sBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        JSONObject jObject = null;

        try {
            jObject = new JSONObject(data);
            List<Film> PeliLista = new ArrayList<>();

            JSONArray results = new JSONArray(jObject.getString("results"));
            for(int i=0; i<results.length(); i++){
                JSONObject movie = new JSONObject(results.getString(i));
                String title  = movie.getString("title");

                Log.i("logTest",  title);

                PeliLista.add(new Film(title));
            }

            RecyclerAdapter myAdapter = new RecyclerAdapter(this, PeliLista);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}