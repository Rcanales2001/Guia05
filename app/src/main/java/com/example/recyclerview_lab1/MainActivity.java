package com.example.recyclerview_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.recyclerview_lab1.databinding.ActivityMainBinding;

import com.example.recyclerview_lab1.vistas.AcercaDe;
import com.example.recyclerview_lab1.vistas.ListTrabajadores;
import com.example.recyclerview_lab1.vistas.SelectTipoTrabajador;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAgregarTrabajador.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SelectTipoTrabajador.class));
        });

        binding.btnMostrar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListTrabajadores.class));
        });

        binding.btnAcerca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
            }
        });
    }
}