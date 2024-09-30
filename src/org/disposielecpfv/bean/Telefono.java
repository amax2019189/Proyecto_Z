/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.disposielecpfv.bean;

/**
 *
 * @author Daniel
 */
public class Telefono {
    private int id;
    private String numero;
    private Enum tipo;
    private int id_persona;

    public Telefono() {
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Enum getTipo() {
        return tipo;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    
    
}
