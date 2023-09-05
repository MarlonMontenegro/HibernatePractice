package com.tienda.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("all")
@Entity
@Table(name = "productos")
@NamedQuery(name = "Producto.consultaDePrecio", query = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String description;
    private BigDecimal precio;
    private final LocalDate fechaDeRegistro = LocalDate.now();
    @ManyToOne
    private Categoria categoria;

    public Producto(String nombre, String description, BigDecimal precio, Categoria categoria) {
        this.nombre = nombre;
        this.description = description;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }


}
