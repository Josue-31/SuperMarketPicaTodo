package com.emergentes.modelo;

import java.sql.Date;

public class Producto {
    private int cod_producto;
    private int stock;
    private String tipo;
    private Date fecha_vencimiento;
    private Date fecha_elaboracion;
    private int id_personal;
    private String nombre_producto;
    private String nombre;
    private String imagen;
    private String estado;
    
    public Producto() {
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Date getFecha_elaboracion() {
        return fecha_elaboracion;
    }

    public void setFecha_elaboracion(Date fecha_elaboracion) {
        this.fecha_elaboracion = fecha_elaboracion;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "cod_producto=" + cod_producto + ", stock=" + stock + ", tipo=" + tipo + ", fecha_vencimiento=" + fecha_vencimiento + ", fecha_elaboracion=" + fecha_elaboracion + ", id_personal=" + id_personal + ", nombre_producto=" + nombre_producto + ", nombre=" + nombre + ", imagen=" + imagen + ", estado=" + estado + '}';
    }
    
    
}
