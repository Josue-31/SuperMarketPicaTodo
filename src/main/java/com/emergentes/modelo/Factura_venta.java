
package com.emergentes.modelo;

import java.sql.Date;

public class Factura_venta {
    private int nro_factura;
    private Date fecha_venta;
    private int ci_nit;
    private double total;
    private String nombres;

    public Factura_venta() {
    }

    public int getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(int nro_factura) {
        this.nro_factura = nro_factura;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCi_nit() {
        return ci_nit;
    }

    public void setCi_nit(int ci_nit) {
        this.ci_nit = ci_nit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Factura_venta{" + "nro_factura=" + nro_factura + ", fecha_venta=" + fecha_venta + ", ci_nit=" + ci_nit + ", total=" + total + ", nombres=" + nombres + '}';
    }
    
    
}
