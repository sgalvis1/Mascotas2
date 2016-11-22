package com.sebastian.mascotas;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2016-11-21.
 */
public class CperfilmascotaAdapter extends RecyclerView.Adapter<CperfilmascotaAdapter.MascotaViewHolder>{
    ArrayList<Cmascota> mascotas;
    Activity activity;
    public CperfilmascotaAdapter(ArrayList<Cmascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    //Se transfieren los elementos al constructor MascotaViewHolder
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cvperfil,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    // Asocia cada elemento de la lista a cada view
    public void onBindViewHolder(MascotaViewHolder MascotaViewHolder, int position) {
        final Cmascota mascota = mascotas.get(position);
        MascotaViewHolder.IVcardview.setImageResource(mascota.getFoto());
        MascotaViewHolder.TVnumLikes.setText(""+mascota.getLikes());

        MascotaViewHolder.IVcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {// Cantidad de elementos de la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView IVcardview;
        private TextView TVnumLikes;
       // private CircularImageView Photo;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            IVcardview = (ImageView)itemView.findViewById(R.id.IVcardview);
            TVnumLikes = (TextView) itemView.findViewById(R.id.TVnumLikes);
            //IVcardview = (CircularImageView)itemView.findViewById(R.id.Photo);
        }
    }
}
