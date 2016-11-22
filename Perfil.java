package com.sebastian.mascotas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {


    ArrayList<Cmascota> mascotas;
    private RecyclerView rvPerfil;
    private CircularImageView Photo;

    public Perfil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Se convierte el recyclerview layout a un objeto
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        rvPerfil = (RecyclerView) v.findViewById(R.id.rvPerfil);

        Photo = (CircularImageView)v.findViewById(R.id.Photo);
        // Set Border
        Photo.setBorderColor(R.color.colorPrimary);
        Photo.setBorderWidth(10);
        // Add Shadow with default param
        Photo.addShadow();

        // Formato del recyclerview
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        rvPerfil.setLayoutManager(glm);

        IniLista();
        IniAdaptador();
        // Inflate the layout for this fragment
        return v;
    }

    public void IniLista(){
        mascotas = new ArrayList<Cmascota>();
        mascotas.add(new Cmascota("Perla",R.drawable.dogperfil,1));
        mascotas.add(new Cmascota("Canela",R.drawable.dogperfil,2));
        mascotas.add(new Cmascota("Caramelo",R.drawable.dogperfil,3));
        mascotas.add(new Cmascota("Almendra",R.drawable.dogperfil,1));
        mascotas.add(new Cmascota("Lola",R.drawable.dogperfil,5));
        mascotas.add(new Cmascota("Chiqui",R.drawable.dogperfil,6));
        mascotas.add(new Cmascota("Alan",R.drawable.dogperfil,7));
        mascotas.add(new Cmascota("Garfield",R.drawable.dogperfil,8));
    };

    public void IniAdaptador(){;
        CperfilmascotaAdapter adaptador = new CperfilmascotaAdapter(mascotas,getActivity());
        rvPerfil.setAdapter(adaptador);
    }


}
