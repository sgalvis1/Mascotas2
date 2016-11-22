package com.sebastian.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageButton btnStar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
      //  setSupportActionBar(miActionBar);

       // toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        setUpViewPager();

       if (miActionBar != null){
           setSupportActionBar(miActionBar);
       }

        // Boton star
        btnStar = (ImageButton)findViewById(R.id.btnStar);


        // Accion de boton de Star
        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this,Main2Activity.class);
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

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListaMascotas());
        fragments.add(new Perfil());
        return fragments;
    }

    private void setUpViewPager(){
        //viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        //tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_footprint_filled_50);
    }
}
