package com.example.appdual.Class;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdual.R;

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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView PortadaPeli;
        TextView myText;

        public MyViewHolder (@NonNull View itemView){
            super(itemView);
            myText = itemView.findViewById(R.id.NomsTextView);
            PortadaPeli = itemView.findViewById(R.id.PortadaView);
        }

        public void bindData(Film film) {

            myText.setText((film.getNombrepeli()));
            PortadaPeli.setColorFilter(Color.parseColor(film.getColor()), PorterDuff.Mode.SRC_IN);

        }
    }
}
