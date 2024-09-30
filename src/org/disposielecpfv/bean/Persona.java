/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.disposielecpfv.bean;

import java.sql.Date;

/**
 *
 * @author Carlos Zeta
 */
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private int id_genero;
    private Date fecha_nacimiento;
    private String email;
    private Date creado;
    private Date actualizado;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String direccion, int id_genero, Date fecha_nacimiento, String email, Date creado, Date actualizado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.id_genero = id_genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getId_genero() {
        return id_genero;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreado() {
        return creado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }
    
    
}
