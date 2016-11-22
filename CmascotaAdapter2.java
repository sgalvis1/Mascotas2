package com.sebastian.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sebastian on 2016-11-14.
 */
public class CmascotaAdapter2  extends RecyclerView.Adapter<CmascotaAdapter2.MascotaViewHolder>{

    ArrayList<Cmascota> mascotas;
    Activity activity;
    public CmascotaAdapter2(ArrayList<Cmascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cvmascotas,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder MascotaViewHolder, int position) {
        final Cmascota mascota = mascotas.get(position);
        MascotaViewHolder.IVcardview.setImageResource(mascota.getFoto());
        MascotaViewHolder.TVnombrecv.setText(mascota.getNombre());

        MascotaViewHolder.IVcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        MascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Te gusta "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        MascotaViewHolder.btnDLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"No te gusta "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView IVcardview;
        private TextView TVnombrecv;
        private ImageButton btnLike;
        private ImageButton btnDLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            IVcardview = (ImageView)itemView.findViewById(R.id.IVcardview);
            TVnombrecv = (TextView)itemView.findViewById(R.id.TVnombrecv);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            btnDLike = (ImageButton) itemView.findViewById(R.id.btnDLike);
        }
    }

}


