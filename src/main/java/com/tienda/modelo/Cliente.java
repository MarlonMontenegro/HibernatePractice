package com.tienda.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private DatosPersonales datosPersonales;

    public Cliente(String nombre, String dui) {
        this.datosPersonales = new DatosPersonales(nombre, dui);
    }

    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return datosPersonales.getNombre();
    }

    public void setNombre(String nombre) {
        this.datosPersonales.setNombre(nombre);
    }

    public String getDui() {
        return datosPersonales.getDui();
    }

    public void setDui(String dui) {
        this.datosPersonales.setDui(dui);
    }
}
