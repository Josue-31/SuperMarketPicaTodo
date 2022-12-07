package com.emergentes.modelo;

public class Personal {

    private int id_personal;
    private String nombres_personal;
    private String usuario;
    private String password;
    private String celular;
    private String direccion;
    private int cod_cargo;
    private String nombre_cargo;
    private String estado;

    public Personal() {
        this.id_personal = 0;
        this.nombres_personal = "";
        this.usuario = "";
        this.password = "";
        this.celular = "";
        this.direccion = "";
        this.cod_cargo = 0;
        this.nombre_cargo = "";
        this.estado = "";
    }

    

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public String getNombres_personal() {
        return nombres_personal;
    }

    public void setNombres_personal(String nombres_personal) {
        this.nombres_personal = nombres_personal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Personal{" + "id_personal=" + id_personal + ", nombres_personal=" + nombres_personal + ", usuario=" + usuario + ", password=" + password + ", celular=" + celular + ", direccion=" + direccion + ", cod_cargo=" + cod_cargo + ", nombre_cargo=" + nombre_cargo + ", estado=" + estado + '}';
    }
    
    
}
