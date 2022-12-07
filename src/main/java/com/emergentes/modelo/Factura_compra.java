
package com.emergentes.modelo;

import java.sql.Date;

public class Factura_compra {
    private int id_factura;
    private Date fecha_compra;
    private int nit;
    private double total;
    private int nro_factura;
    private String nombre;

    public Factura_compra() {
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(int nro_factura) {
        this.nro_factura = nro_factura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Factura_compra{" + "id_factura=" + id_factura + ", fecha_compra=" + fecha_compra + ", nit=" + nit + ", total=" + total + ", nro_factura=" + nro_factura + ", nombre=" + nombre + '}';
    }
    
    
}
