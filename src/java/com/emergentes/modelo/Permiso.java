package com.emergentes.modelo;

public class Permiso {
    private int id;
    private int id_rol;
    private int id_usuario;
    private String rol;
    private String usuario;

    public Permiso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Permiso{" + "id=" + id + ", id_rol=" + id_rol + ", id_usuario=" + id_usuario + ", rol=" + rol + ", usuario=" + usuario + '}';
    }
    
}
