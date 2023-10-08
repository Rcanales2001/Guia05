package com.example.recyclerview_lab1.modelo;

public class TrabajadorHora extends Trabajador{
    private int numeroHoras;
    private float valorHora;

    public TrabajadorHora() {
    }

    public TrabajadorHora(String codigoPersona, String nombrePersona, String apellidoPersona, int numeroHoras, float valorHora) {
        super(codigoPersona, nombrePersona, apellidoPersona);
        this.numeroHoras = numeroHoras;
        this.valorHora = valorHora;
        super.setSueldoMensual(numeroHoras * valorHora);
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public int getTipoTrabajador() {
        return 2;
    }
}
