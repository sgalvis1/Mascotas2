package com.sebastian.mascotas;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Informacionapp extends AppCompatActivity {
    private ImageButton btnStar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacionapp);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Boton star
        btnStar = (ImageButton)findViewById(R.id.btnStar);

        // Accion de boton de Star
        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Informacionapp.this,Main2Activity.class);
                startActivity(i3);
            }
        });



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
