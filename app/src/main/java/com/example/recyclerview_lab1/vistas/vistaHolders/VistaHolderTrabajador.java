package com.example.recyclerview_lab1.vistas.vistaHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_lab1.R;

public class VistaHolderTrabajador extends RecyclerView.ViewHolder  {

    private TextView codigoPersona;
    private TextView nombrePersona;
    private TextView tipoTrabajador;
    private TextView totalPagar;


    public VistaHolderTrabajador(@NonNull View itemView) {
        super(itemView);
        this.codigoPersona = itemView.findViewById(R.id.txvCodigoPersona);
        this.nombrePersona = itemView.findViewById(R.id.txvNombrePersona);
        this.tipoTrabajador = itemView.findViewById(R.id.txvTipoTrabajador);
        this.totalPagar = itemView.findViewById(R.id.txvTotalTrabajador);
    }

    public TextView getCodigoPersona() {
        return codigoPersona;
    }

    public TextView getNombrePersona() {
        return nombrePersona;
    }

    public TextView getTipoTrabajador() {
        return tipoTrabajador;
    }

    public TextView getTotalPagar() {
        return totalPagar;
    }
}

