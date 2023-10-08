package com.example.recyclerview_lab1.modelo;

public class TrabajadorTiempoCompleto extends Trabajador {
    private float descuentoAFP;
    private float descuentoISSS;

    public TrabajadorTiempoCompleto() {

    }

    public TrabajadorTiempoCompleto(String codigoPersona, String nombrePersona, String apellidoPersona, float salarioMensual) {
        super(codigoPersona, nombrePersona, apellidoPersona);

        setDescuentoISSS(salarioMensual > 1000 ? (float) 30 : (float) (salarioMensual * 0.03) );
        setDescuentoAFP((float) (salarioMensual * 0.0725) );

        super.setTotalDescuentos(getDescuentoAFP() + getDescuentoISSS());
        super.setSueldoMensual(salarioMensual);


    }

    public float getDescuentoAFP() {
        return descuentoAFP;
    }

    public void setDescuentoAFP(float descuentoAFP) {
        this.descuentoAFP = descuentoAFP;
    }

    public float getDescuentoISSS() {
        return descuentoISSS;
    }

    public void setDescuentoISSS(float descuentoISSS) {
        this.descuentoISSS = descuentoISSS;
    }

    @Override
    public int getTipoTrabajador() {
        return 1;
    }
}
