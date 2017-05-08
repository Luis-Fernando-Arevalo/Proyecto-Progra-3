/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coneccionMSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Arevalo
 */
public class Coneccion 
{    
    public void coneccion ()
    {
        String url = "jdbc:mysql://localhost:3306/manejovivero";
        String username = "Luis";
        String password = "Admin123";
        
        System.out.println("Cargando driver...");
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Cargado");
            Connection connection = DriverManager.getConnection(url,username, password);
            System.out.println("Base de Datos Conectada! ");
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException ("No se encontro el driver/Base de Datos! en el Classpath", e); 
        }
    }
    
}
