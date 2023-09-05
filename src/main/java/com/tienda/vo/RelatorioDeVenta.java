package com.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {

    private String nombreDelProducto;
    private Long cantidadDeProducto;
    private LocalDate fechasDeUltimaVenta;

    public RelatorioDeVenta(String nombreDelProducto, Long cantiadadDeProducto, LocalDate fechasDeUltimaVenta) {
        this.nombreDelProducto = nombreDelProducto;
        this.cantidadDeProducto = cantiadadDeProducto;
        this.fechasDeUltimaVenta = fechasDeUltimaVenta;
    }


    @Override
    public String toString() {
        return "RelatorioDeVenta{" +
                "nombreDelProducto='" + nombreDelProducto + '\'' +
                ", cantidadDeProducto=" + cantidadDeProducto +
                ", fechasDeUltimaVenta=" + fechasDeUltimaVenta +
                '}';
    }

}
