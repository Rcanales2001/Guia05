package com.example.recyclerview_lab1.modelo;

import java.text.DecimalFormat;

public abstract class Trabajador extends Persona{
    protected float sueldoMensual;
    protected float descuentoISR;
    protected float totalDescuentos;
    protected float totalPagar;

    public Trabajador(){}
    public Trabajador(String codigoPersona, String nombrePersona, String apellidoPersona){
        super(codigoPersona, nombrePersona, apellidoPersona);
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(float sueldoMensual)
    {

        this.sueldoMensual = sueldoMensual;

        float tmpSueldoMensual = this.sueldoMensual - this.getTotalDescuentos();

        float sobreExcedente = 0;
        float cuotaFija = 0;
        float porcentajeTramo = 0;

        if (tmpSueldoMensual > 2088.10){
            porcentajeTramo = (float) 0.3;
            sobreExcedente = (float) 2038.57;
            cuotaFija = (float) 288.67;
        }

        if (tmpSueldoMensual >= 895.25){
            porcentajeTramo = (float) 0.2;
            sobreExcedente = (float) 895.24;
            cuotaFija = (float) 60.00;
        }

        if (tmpSueldoMensual >= 472.01){
            porcentajeTramo = (float) 0.1;
            sobreExcedente = (float) 472.00;
            cuotaFija = (float) 17.67;
        }



        this.setDescuentoISR(porcentajeTramo > 0 ? ((tmpSueldoMensual - sobreExcedente) * porcentajeTramo) + cuotaFija : 0  );
        this.setTotalDescuentos(this.getDescuentoISR() + this.getTotalDescuentos());
        this.setTotalPagar(this.getSueldoMensual() - this.getTotalDescuentos());

    }

    public float getDescuentoISR() {
        return descuentoISR;
    }

    public void setDescuentoISR(float descuentoISR) {
        this.descuentoISR = descuentoISR;
    }

    public float getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(float totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        DecimalFormat df = new DecimalFormat("#0.00"); // Formatear a dos decimales
        String totalPagarFormateado = df.format(totalPagar); // Formatear el totalPagar

        this.totalPagar = Float.parseFloat(totalPagarFormateado); // Asignar el valor formateado
    }


    public abstract int getTipoTrabajador();

}
