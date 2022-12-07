
package com.emergentes.modelo;

public class Detalle_compra {
    private int id;
    private double precio;
    private int cantidad;
    private String observaciones;
    private int cod_producto;
    private int id_factura;
    private String nombre_producto;

    public Detalle_compra() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    @Override
    public String toString() {
        return "Detalle_compra{" + "id=" + id + ", precio=" + precio + ", cantidad=" + cantidad + ", observaciones=" + observaciones + ", cod_producto=" + cod_producto + ", id_factura=" + id_factura + ", nombre_producto=" + nombre_producto + '}';
    }
   
}
