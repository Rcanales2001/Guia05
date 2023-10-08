package com.example.recyclerview_lab1.modelo;

import androidx.annotation.NonNull;

public abstract class Persona {
    protected  String codigoPersona;
    protected  String nombrePersona;
    protected  String apellidoPersona;

    public Persona(){}

    public Persona(String codigoPersona, String nombrePersona, String apellidoPersona){
        this.codigoPersona = codigoPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }


    public String getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(String codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    @NonNull
    @Override
    public String toString() {
        return codigoPersona + nombrePersona + apellidoPersona;
    }
}

