/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.disposielecpfv.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.disposielecpfv.main.Principal;

/**
 *
 * @author alejo
 */
public class ControladorMenuPrincipal implements Initializable{
    private Principal escenario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public Principal getEscenario() {
        return escenario;
    }

    public void setEscenario(Principal escenario) {
        this.escenario = escenario;
    }
}
