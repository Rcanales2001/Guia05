package com.example.recyclerview_lab1.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.recyclerview_lab1.databinding.ActivitySelectTipoTrabajadorBinding;

public class SelectTipoTrabajador extends AppCompatActivity {

    private ActivitySelectTipoTrabajadorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectTipoTrabajadorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSiguiente.setOnClickListener(v -> {
            RadioButton selectedRadioButton = findViewById(binding.rgTrabajadores.getCheckedRadioButtonId());
            boolean idSelected = selectedRadioButton.getText().toString().contains("hora");
            finish();
            startActivity(new Intent(SelectTipoTrabajador.this, idSelected ? AgregarTrabajadorHora.class : AgregarTrabajadorCompleto.class));
        });
    }
}
