package com.sebastian.mascotas;

/**
 * Created by Sebastian on 2016-11-13.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CmascotaAdapter extends RecyclerView.Adapter<CmascotaAdapter.MascotaViewHolder>{
    ArrayList<Cmascota> mascotas;
    Activity activity;
    public CmascotaAdapter(ArrayList<Cmascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }



    @Override
    //Se transfieren los elementos al constructor MascotaViewHolder
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cvmascotas,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    // Asocia cada elemento de la lista a cada view
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, final int position) {
        final Cmascota mascota = mascotas.get(position);
        MascotaViewHolder.IVcardview.setImageResource(mascota.getFoto());
        MascotaViewHolder.TVnombrecv.setText(mascota.getNombre());
        MascotaViewHolder.TVnumLikes.setText(""+mascota.getLikes());


        MascotaViewHolder.IVcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,mascota.getNombre(), Toast.LENGTH_SHORT).show();
               // Intent i3 = new Intent(activity,Main2Activity.class);
                // activity.startActivity(i3);

            }
        });

        MascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mascota.isFlagLike()) {
                    Toast.makeText(activity,"Te gusta "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    mascotas.get(position).setLikes(mascotas.get(position).getLikes() + 1);
                    mascota.setFlagLike(true);
                    MascotaViewHolder.TVnumLikes.setText(""+mascota.getLikes());
                }
            }
        });

        MascotaViewHolder.btnDLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mascota.isFlagLike()) {
                    Toast.makeText(activity,"No te gusta "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    mascotas.get(position).setLikes(mascotas.get(position).getLikes()-1);
                    mascota.setFlagLike(false);
                    MascotaViewHolder.TVnumLikes.setText(""+mascota.getLikes());
                }
            }
        });

    }

    @Override
    public int getItemCount() {// Cantidad de elementos de la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView IVcardview;
        private TextView TVnombrecv;
        private ImageButton btnLike;
        private ImageButton btnDLike;
        private TextView TVnumLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            IVcardview = (ImageView)itemView.findViewById(R.id.IVcardview);
            TVnombrecv = (TextView)itemView.findViewById(R.id.TVnombrecv);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            btnDLike = (ImageButton) itemView.findViewById(R.id.btnDLike);
            TVnumLikes = (TextView) itemView.findViewById(R.id.TVnumLikes);
        }
    }
}
