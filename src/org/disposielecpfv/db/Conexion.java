/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.disposielecpfv.db;

/**
 *
 * @author Carlos Zeta
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    
    private Connection conexion;
    private static Conexion instancia;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBTonysKinal2023?userSSL=false","root","$oport3");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DispositivosElectronicosPFV?userSSL=false","root","admin");
            System.out.println("Conexion exitosa");
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DispositivosElectronicosPFV?userSSL=false","root","123456");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(InstantiationException e){
            e.printStackTrace();
        } catch(IllegalAccessException e){
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Conexion getInstance(){
        if (instancia == null)
            instancia = new Conexion();
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}