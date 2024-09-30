/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.disposielecpfv.main;

import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.disposielecpfv.db.Conexion;

/**
 *
 * @author Carlos Zeta
 */
public class Principal extends Application{
    private final String PAQUETE_VISTA = "/org/disposielecpfv/org.disposielecpfv.vista/";
    private Stage escenario;
    private Scene escena;

    @Override
    public void start(Stage  Escenario) throws Exception {
        this.escenario = Escenario;
        this.escenario.setTitle("Dispositivos Electronicos - 2021001");
        escenario.getIcons().add(new Image("/org/disposielecpfv/imagenes/LogoPrincipal.png"));
        escenario.setResizable(false);
        escenario.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public Initializable cambiarEscena (String fxml, int ancho, int alto) throws Exception{
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivos = Principal.class.getResourceAsStream(PAQUETE_VISTA+fxml);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        escena = new Scene((AnchorPane)cargadorFXML.load(archivos),ancho,alto);
        escenario.setScene(escena);
        escenario.sizeToScene();
        return resultado;
    }
}