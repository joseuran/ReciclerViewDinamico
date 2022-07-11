package com.example.reciclerview;

public class ModeloPersona {

    String nombre;
    int tipoPago;

    public ModeloPersona(String nombre, int tipoPago) {
        this.nombre = nombre;
        this.tipoPago = tipoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }
}
