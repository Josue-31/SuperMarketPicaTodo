
package com.emergentes.modelo;

public class Cliente {
    private int CINIT;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String direccion;

    public Cliente() {
    }

    public int getCINIT() {
        return CINIT;
    }

    public void setCINIT(int CINIT) {
        this.CINIT = CINIT;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "CINIT=" + CINIT + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", direccion=" + direccion + '}';
    }
       
}
