package com.example.recyclerview_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview_lab1.vistas.AcercaDe;
import com.example.recyclerview_lab1.vistas.ListTrabajadores;
import com.example.recyclerview_lab1.vistas.SelectTipoTrabajador;

public class MainActivity extends AppCompatActivity {

    private Button btnAcerca;
    private Button btnMostrar;
    private Button btnAgregarTrabajador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAcerca = findViewById(R.id.btnAcerca);
        btnAgregarTrabajador = findViewById(R.id.btnAgregarTrabajador);
        btnMostrar = findViewById(R.id.btnMostrar);

        btnAgregarTrabajador.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SelectTipoTrabajador.class));
        });

        btnMostrar.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListTrabajadores.class));
            //ok

        });
        btnAcerca.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
            }
        });
    }

}