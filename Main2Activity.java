package com.sebastian.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<Cmascota> mascotas;
    private RecyclerView rvMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Se convierte el recyclerview layout a un objeto
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);

        // Formato del recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);
        rvMascotas.setLayoutManager(llm);

        IniLista();
        IniAdaptador();


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
        CmascotaAdapter adaptador = new CmascotaAdapter(mascotas,this);
        rvMascotas.setAdapter(adaptador);
    }

    // Menú de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones,menu);
        return true;
    }
    // Opciones de menú opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.MeContacto:
                Intent i4 = new Intent(this,NuevoContacto.class);
                startActivity(i4);
                break;

            case R.id.MeInformacion:
                Intent i5 = new Intent(this,Informacionapp.class);
                startActivity(i5);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
