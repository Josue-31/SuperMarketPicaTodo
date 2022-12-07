package com.emergentes.modelo;

public class Detalle_venta {

    private int id_v;
    private double precio;
    private int cantidad;
    private String detalle;
    private int cod_producto;
    private int nro_factura;
    private String nombre_producto;

    public Detalle_venta() {
    }

    public int getId_v() {
        return id_v;
    }

    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(int nro_factura) {
        this.nro_factura = nro_factura;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    @Override
    public String toString() {
        return "Detalle_venta{" + "id_v=" + id_v + ", precio=" + precio + ", cantidad=" + cantidad + ", detalle=" + detalle + ", cod_producto=" + cod_producto + ", nro_factura=" + nro_factura + ", nombre_producto=" + nombre_producto + '}';
    }

}
