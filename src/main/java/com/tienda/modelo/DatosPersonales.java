package com.tienda.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DatosPersonales {

    private String nombre;
    private String dui;

    public DatosPersonales() {
    }

    public DatosPersonales(String nombre, String dui) {
        this.nombre = nombre;
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
}

