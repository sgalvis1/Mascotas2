package com.sebastian.mascotas;

/**
 * Created by Sebastian on 2016-11-13.
 */
public class Cmascota {
        private String Nombre;
        private int Foto;
        private int Likes;
        private  boolean FlagLike;

    public boolean isFlagLike() {
        return FlagLike;
    }

    public void setFlagLike(boolean flagLike) {
        FlagLike = flagLike;
    }

    public Cmascota(String nombre, int foto, int likes) {
        Nombre = nombre;
        Foto = foto;
        Likes = likes;
        FlagLike = false;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public String getNombre() {
            return Nombre;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

        public int getFoto() {
            return Foto;
        }

        public void setFoto(int foto) {
            Foto = foto;
        }

}
