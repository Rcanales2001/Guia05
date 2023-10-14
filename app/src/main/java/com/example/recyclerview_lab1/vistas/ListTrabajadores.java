package com.example.recyclerview_lab1.vistas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.recyclerview_lab1.databinding.ActivityListTrabajadoresBinding;
import com.example.recyclerview_lab1.modelo.Trabajador;
import com.example.recyclerview_lab1.repositorios.TrabajadorRespositos;
import com.example.recyclerview_lab1.servicios.ServiceLocator;
import com.example.recyclerview_lab1.vistas.adaptador.TrabajadorAdaptador;

import java.util.ArrayList;
import java.util.List;

public class ListTrabajadores extends AppCompatActivity implements TrabajadorAdaptador.OnItemLongClickListener {

    private ActivityListTrabajadoresBinding binding;
    private TrabajadorAdaptador personaAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListTrabajadoresBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TrabajadorRespositos dbSource = ServiceLocator.getInstance().getDBSource();
        List<Trabajador> listaTrabajadores = dbSource.getAllListTrabajadores();

        // Configurando adaptador
        personaAdapter = new TrabajadorAdaptador((ArrayList<Trabajador>) listaTrabajadores);
        layoutManager = new LinearLayoutManager(this);

        binding.rcvTrabajadores.setAdapter(personaAdapter);
        binding.rcvTrabajadores.setLayoutManager(layoutManager);
        binding.rcvTrabajadores.setHasFixedSize(true);

        personaAdapter.setOnItemLongClickListener(this);
    }

    private void editarTrabajador(int position) {
        Trabajador trabajador = personaAdapter.getTrabajador(position);
        // Aquí puedes agregar el código para editar un trabajador.
    }

    private void eliminarTrabajador(int position) {
        AlertDialog.Builder deleteBuilder = new AlertDialog.Builder(this);
        deleteBuilder.setTitle("Eliminar Trabajador")
                .setMessage("¿Estás seguro de que quieres eliminar este trabajador?")
                .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Trabajador trabajador = personaAdapter.getTrabajador(position);
                        TrabajadorRespositos dbSource = ServiceLocator.getInstance().getDBSource();
                        dbSource.removeTrabajador(trabajador);

                        personaAdapter.removeTrabajador(position);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void onItemLongClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Opciones")
                .setItems(new CharSequence[]{"Editar", "Eliminar"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                editarTrabajador(position);
                                break;
                            case 1:
                                eliminarTrabajador(position);
                                break;
                        }
                    }
                })
                .show();
    }
}
