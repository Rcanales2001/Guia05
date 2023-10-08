package com.example.recyclerview_lab1.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.recyclerview_lab1.R;

public class SelectTipoTrabajador extends AppCompatActivity {

    private Button btnSiguiente;
    private RadioGroup rgTrabajadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tipo_trabajador);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        rgTrabajadores = findViewById(R.id.rgTrabajadores);
        ((RadioButton)rgTrabajadores.getChildAt(0)).setChecked(true);

        btnSiguiente.setOnClickListener(v -> {
            RadioButton selectedRadioButton = findViewById(rgTrabajadores.getCheckedRadioButtonId());
            boolean idSelected = selectedRadioButton.getText().toString().contains("hora");
            finish();
            startActivity(new Intent(SelectTipoTrabajador.this, idSelected ? AgregarTrabajadorHora.class : AgregarTrabajadorCompleto.class ));
        });
    }
}