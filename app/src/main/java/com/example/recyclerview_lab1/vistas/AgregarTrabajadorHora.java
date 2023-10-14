package com.example.recyclerview_lab1.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.recyclerview_lab1.databinding.ActivityAgregarTrabajadorHoraBinding;

import com.example.recyclerview_lab1.R;
import com.example.recyclerview_lab1.modelo.TrabajadorHora;
import com.example.recyclerview_lab1.repositorios.TrabajadorRespositos;
import com.example.recyclerview_lab1.servicios.ServiceLocator;

public class AgregarTrabajadorHora extends AppCompatActivity {

    private ActivityAgregarTrabajadorHoraBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TrabajadorRespositos dbSource = ServiceLocator.getInstance().getDBSource();
        super.onCreate(savedInstanceState);
        binding = ActivityAgregarTrabajadorHoraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAgregarTH.setOnClickListener(v -> {

            if (validateFields()){
                if (dbSource.getTrabajadorById(binding.etId.getText().toString())!= null){
                    Toast.makeText(getApplicationContext(), "Error no puede utilizar el ID", Toast.LENGTH_SHORT).show();
                }
                else{

                    if( dbSource.AddTrabajador(new TrabajadorHora(
                            binding.etId.getText().toString(),
                            binding.etNombre.getText().toString(),
                            binding.etApellido.getText().toString(),
                            Integer.parseInt(binding.etHoras.getText().toString()),
                            Float.parseFloat(binding.etValor.getText().toString() )))){

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                        alertDialogBuilder.setTitle("Registrado el trabajador!");
                        alertDialogBuilder.setMessage("Registrado con éxito");
                        alertDialogBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

                        alertDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialogInterface) {
                                finish();
                            }
                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                    else{
                        new AlertDialog.Builder(AgregarTrabajadorHora.this)
                                .setTitle("Error al agregar!")
                                .setMessage("No se pudo guardar el registro")
                                .setPositiveButton("Aceptar", null)
                                .show();
                    }
                }
            }
        });

    }

    private boolean validateFields(){
        if (binding.etId.getText().toString().isEmpty() ||
                binding.etNombre.getText().toString().isEmpty()||
                binding.etApellido.getText().toString().isEmpty() ||
                binding.etEdad.getText().toString().isEmpty() ||
                binding.etValor.getText().toString().isEmpty()||
                binding.etHoras.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos para continuar", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}