
package com.emergentes.modelo;

public class Proveedores {
    private int nit;
    private String nombre;
    private String nro_telefono;
    private String direccion;

    public Proveedores() {
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNro_telefono() {
        return nro_telefono;
    }

    public void setNro_telefono(String nro_telefono) {
        this.nro_telefono = nro_telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "nit=" + nit + ", nombre=" + nombre + ", nro_telefono=" + nro_telefono + ", direccion=" + direccion + '}';
    }
    
    
}
