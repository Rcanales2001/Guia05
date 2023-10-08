package com.example.recyclerview_lab1.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerview_lab1.R;
import com.example.recyclerview_lab1.modelo.TrabajadorHora;
import com.example.recyclerview_lab1.repositorios.TrabajadorRespositos;
import com.example.recyclerview_lab1.servicios.ServiceLocator;

public class AgregarTrabajadorHora extends AppCompatActivity {

    EditText etId;
    EditText etNombre;
    EditText etApellido;
    EditText etEdad;
    EditText etValor;
    EditText etHoras;
    Button btnAgregarTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TrabajadorRespositos dbSource = ServiceLocator.getInstance().getDBSource();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_trabajador_hora);

        etId = findViewById(R.id.etId);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEdad = findViewById(R.id.etEdad);
        etValor = findViewById(R.id.etValor);
        etHoras = findViewById(R.id.etHoras);
        btnAgregarTH = findViewById(R.id.btnAgregarTH);

        btnAgregarTH.setOnClickListener(v -> {

            if (validateFields()){
                if (dbSource.getTrabajadorById(etId.getText().toString())!= null){
                    Toast.makeText(getApplicationContext(), "Error no puede utilizar el ID", Toast.LENGTH_SHORT).show();
                }
                else{

                    if( dbSource.AddTrabajador(new TrabajadorHora(
                            etId.getText().toString(),
                            etNombre.getText().toString(),
                            etApellido.getText().toString(),
                            Integer.parseInt(etHoras.getText().toString()),
                            Float.parseFloat(etValor.getText().toString() )))){

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
        if (etId.getText().toString().isEmpty() ||
                etNombre.getText().toString().isEmpty()||
                etApellido.getText().toString().isEmpty() ||
                etEdad.getText().toString().isEmpty() ||
                etValor.getText().toString().isEmpty()||
                etHoras.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos para continuar", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}