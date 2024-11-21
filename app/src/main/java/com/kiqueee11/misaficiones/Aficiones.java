package com.kiqueee11.misaficiones;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kiqueee11.misaficiones.databinding.ActivityAficionesBinding;
import com.kiqueee11.misaficiones.ui.frManager.Paginador;

import java.util.zip.Inflater;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;

    private int posicion;

    private String favorito = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

               posicion = position;

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        FloatingActionButton botonFlotante  = findViewById(R.id.fab);

        botonFlotante.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.favButton){
            Toast.makeText(this, "Anadido a favoritos", Toast.LENGTH_SHORT).show();
            if(posicion==0){
                favorito = "comer";
                System.out.println("comer");
            }else{
                favorito = "dormir";
                System.out.println("dormir");
            }
            SharedPreferences preferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("favoritos",favorito);
            editor.apply();
        }
        if (id==R.id.aboutMeButton){
           Intent intent = new Intent(Aficiones.this, SobreMi.class);
           startActivity(intent);
        }
        if (id==R.id.myCodeButton){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/kiqueee11"));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}