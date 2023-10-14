package com.example.recyclerview_lab1.vistas;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclerview_lab1.databinding.ActivityAgregarTrabajadorCompletoBinding;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerview_lab1.R;
import com.example.recyclerview_lab1.modelo.TrabajadorTiempoCompleto;
import com.example.recyclerview_lab1.repositorios.TrabajadorRespositos;
import com.example.recyclerview_lab1.servicios.ServiceLocator;

public class AgregarTrabajadorCompleto extends AppCompatActivity {

    private ActivityAgregarTrabajadorCompletoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAgregarTrabajadorCompletoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TrabajadorRespositos dbSource = ServiceLocator.getInstance().getDBSource();

        binding.btnAgregarTC.setOnClickListener(v -> {
            if (validateFields()) {
                if (dbSource.getTrabajadorById(binding.edtID.getText().toString()) != null) {
                    Toast.makeText(getApplicationContext(), "Error: no puede utilizar el ID", Toast.LENGTH_SHORT).show();
                } else {
                    TrabajadorTiempoCompleto nuevoTrabajador = new TrabajadorTiempoCompleto(
                            binding.edtID.getText().toString(),
                            binding.edtName.getText().toString(),
                            binding.edtApellido.getText().toString(),
                            Float.parseFloat(binding.edtSalario.getText().toString())
                    );

                    if (dbSource.AddTrabajador(nuevoTrabajador)) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                        alertDialogBuilder.setTitle("Registrado el trabajador!");
                        alertDialogBuilder.setMessage("Registrado con éxito");
                        alertDialogBuilder.setPositiveButton("Aceptar", (dialog, which) -> finish());

                        alertDialogBuilder.setOnCancelListener(dialogInterface -> finish());

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    } else {
                        new AlertDialog.Builder(AgregarTrabajadorCompleto.this)
                                .setTitle("Error al agregar!")
                                .setMessage("No se pudo guardar el registro")
                                .setPositiveButton("Aceptar", null)
                                .show();
                    }
                }
            }
        });
    }

    private boolean validateFields() {
        if (binding.edtID.getText().toString().isEmpty() ||
                binding.edtName.getText().toString().isEmpty() ||
                binding.edtApellido.getText().toString().isEmpty() ||
                binding.edtEdad.getText().toString().isEmpty() ||
                binding.edtSalario.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos para continuar", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}