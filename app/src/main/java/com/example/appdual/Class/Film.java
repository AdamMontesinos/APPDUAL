package com.example.appdual.Class;

public class Film {
    public String nombrepeli;
    public String backdrop_path;
    public String poster_path;

    public Film(String nombrepeli, String backdrop_path, String poster_path) {
        this.nombrepeli = nombrepeli;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
    }

    public String getNombrepeli() {
        return nombrepeli;
    }

    public void setNombrepeli(String nombrepeli) {
        this.nombrepeli = nombrepeli;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
