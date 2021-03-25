package com.example.appdual.Class;

public class Film {
    public String nombrepeli;
    public String img;
    public String color;

    public Film(String title,String img,String color) {
        this.nombrepeli = title;
        this.img = img;
        this.color = color;
    }

    public String getNombrepeli() {
        return nombrepeli;
    }

    public void setNombrepeli(String nombrepeli) {
        this.nombrepeli = nombrepeli;
    }

    public String getImagen() {
        return img;
    }

    public void setImagen(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.img = img;
    }
}
