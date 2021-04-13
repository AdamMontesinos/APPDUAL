package com.example.appdual.Class;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdual.InfoPeli;
import com.example.appdual.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Film> data;
    Context context;

    public RecyclerAdapter(Context ct, List<Film> ListaPeli){
        this.context = ct;
        this.data = ListaPeli;
        Log.i("testNom", "-- " + data.size());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.myText.setText(data.get(position));
        holder.bindData(data.get(position));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(context, InfoPeli.class);
                context.startActivity(intento);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView PortadaPeli;
        TextView myText;
        TextView myRating;

        ConstraintLayout mainLayout;

        public MyViewHolder (@NonNull View itemView){
            super(itemView);
            myText = itemView.findViewById(R.id.NomsTextView);
            PortadaPeli = itemView.findViewById(R.id.PortadaView);
            myRating = itemView.findViewById(R.id.RatingText);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

        public void bindData(Film film) {

            myText.setText((film.getNombrepeli()));
            myRating.setText((film.getRating()));

            String urlImg = "https://image.tmdb.org/t/p/original/" + film.getPoster_path();
            Picasso.get().load(urlImg).into(PortadaPeli);
        }
    }
}
