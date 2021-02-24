package com.example.appdual;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BuscarPeli extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_peli);
    }

    Button btnSearch = findViewById(R.id.BPelis2);
        btnSearch.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

        }
    });

    public void showTxtSearch(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Busca Pelicula");

        final EditText input = new EditText(this);
        input.setHint("Film");
        alert.setView(input);

        alert.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String movie = input.getText().toString();
                fetchData process = new fetchData(movie);
                process.execute();
            }
        });

        alert.setNegativeButton("Cancela", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });
        alert.show();
    }

}