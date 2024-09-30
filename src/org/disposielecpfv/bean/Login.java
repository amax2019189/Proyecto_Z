/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.disposielecpfv.bean;

/**
 *
 * @author Carlos Zeta
 */
public class Login {
    private String _usuario;
    private String _contrasenia;

    public Login() {
    }

    public Login(String _usuario, String _contrasenia) {
        this._usuario = _usuario;
        this._contrasenia = _contrasenia;
    }

    public String getUsuario() {
        return _usuario;
    }

    public void setUsuario(String _usuario) {
        this._usuario = _usuario;
    }

    public String getContrasenia() {
        return _contrasenia;
    }

    public void setContrasenia(String _contrasenia) {
        this._contrasenia = _contrasenia;
    }

    @Override
    public String toString() {
        return "Login{" + "_usuario=" + _usuario + ", _contrasenia=" + _contrasenia + '}';
    }
}