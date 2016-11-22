package com.sebastian.mascotas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sebastian.mascotas.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMascotas extends Fragment {

    ArrayList<Cmascota> mascotas;
    private RecyclerView rvMascotas;

    public ListaMascotas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Se convierte el recyclerview layout a un objeto
        View v = inflater.inflate(R.layout.fragment_lista_mascotas,container,false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        // Formato del recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);
        rvMascotas.setLayoutManager(llm);

        IniLista();
        IniAdaptador();

        // Inflate the layout for this fragment
        return v;
    }

    public void IniLista(){
        mascotas = new ArrayList<Cmascota>();
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
        CmascotaAdapter adaptador = new CmascotaAdapter(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

}
