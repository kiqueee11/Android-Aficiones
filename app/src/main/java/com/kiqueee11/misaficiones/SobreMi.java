package com.kiqueee11.misaficiones;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.kiqueee11.misaficiones.databinding.ActivityAficionesBinding;
import com.kiqueee11.misaficiones.databinding.ActivitySobreMiBinding;
import com.kiqueee11.misaficiones.ui.frManager.Paginador;
import com.kiqueee11.misaficiones.ui.frManager.Paginador2;
import com.kiqueee11.misaficiones.ui.frManager.Paginador3;

public class SobreMi extends AppCompatActivity {

    private ActivitySobreMiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sobre_mi);
        SharedPreferences preferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        String favorito = preferences.getString("favoritos","comer");

        binding = ActivitySobreMiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewPager viewPager = binding.viewPagerSobreMi;

        if(favorito.equals("dormir")){
            Paginador3 paginador = new Paginador3(this, getSupportFragmentManager());
            viewPager.setAdapter(paginador);

        }else{
            Paginador2 paginador = new Paginador2(this, getSupportFragmentManager());
            viewPager.setAdapter(paginador);

        }
    }
}