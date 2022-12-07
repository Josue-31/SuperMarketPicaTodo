
package com.emergentes.modelo;

public class Cargo {
    private int cod_cargo;
    private String nombre_cargo;
    private int sueldo;

    public Cargo() {
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "cod_cargo=" + cod_cargo + ", nombre_cargo=" + nombre_cargo + ", sueldo=" + sueldo + '}';
    }
      
}
