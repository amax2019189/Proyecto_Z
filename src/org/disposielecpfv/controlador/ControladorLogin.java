/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.disposielecpfv.controlador;

import java.awt.Button;
import java.awt.TextField;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import org.disposielecpfv.bean.Login;
import org.disposielecpfv.bean.Usuario;
import org.disposielecpfv.db.Conexion;
import org.disposielecpfv.main.Principal;

/**
 *
 * @author Daniel
 */
public class ControladorLogin implements Initializable{
    private Principal escenario;
    private ObservableList<Usuario> listaUsuario;
    
    @FXML private TextField txtUsuario;
    @FXML private TextField txtPassword;
    @FXML private Button btnLogin;
    @FXML private Button btnSignup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public ObservableList<Usuario> getUsuario(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            PreparedStatement procedimiento = Conexion.getInstance().getConexion().prepareCall("call sp_iniciar_sesion ()");
            ResultSet resultado = procedimiento.executeQuery();
            while(resultado.next()){
                lista.add(new Usuario(resultado.getInt("id_persona"),
                                        resultado.getString("nombre_usuario"),
                                        resultado.getString("contrasenia"),
                                        resultado.getString("email"),
                                        resultado.getInt("rol"),
                                        resultado.getBoolean("activo"),
                                        resultado.getDate("fecha_nacimineto"),
                                        resultado.getDate("creado"),
                                        resultado.getDate("actualizado")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaUsuario = FXCollections.observableArrayList(lista);
    }
    
    @FXML
    private void sesion() {
        Login login = new Login();
        int x = 0;
        boolean bandera = false;
        login.setUsuario(txtUsuario.getText());
        login.setContrasenia(txtPassword.getText());
        while(x < getUsuario().size()){
            String user = getUsuario().get(x).getNombre_usuario();
            String pass = getUsuario().get(x).getContrasena();
            if (user.equals(login.getUsuario()) && pass.equals(login.getContrasenia())) {
                JOptionPane.showMessageDialog(null, "Sesion Iniciada\n"
                    +getUsuario().get(x).getNombre_usuario()+ " \n" +
                    "Bienvenido!!!");
                escenario.menuPrincipal();
                x = getUsuario().size();
                bandera = true;
            }
        }
    }
}
