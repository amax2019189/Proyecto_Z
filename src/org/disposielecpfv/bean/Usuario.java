/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.disposielecpfv.bean;

import java.sql.Date;

/**
 *
 * @author Daniel
 */
public class Usuario {
    private int id_persona; 
    private String nombre_usuario; 
    private String contrasena; 
    private String email;
    private int rol; 
    private Boolean activo;
    private Date fecha_nacimiento;
    private Date creado;
    private Date actualizado;

    public Usuario() {
    }

    public Usuario(int id_persona, String nombre_usuario, String contrasena, String email, int rol, Boolean activo, Date fecha_nacimiento, Date creado, Date actualizado) {
        this.id_persona = id_persona;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.rol = rol;
        this.activo = activo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_persona=" + id_persona + ", nombre_usuario=" + nombre_usuario + ", contrasena=" + contrasena + ", email=" + email + ", rol=" + rol + ", activo=" + activo + ", fecha_nacimiento=" + fecha_nacimiento + ", creado=" + creado + ", actualizado=" + actualizado + '}';
    }
}