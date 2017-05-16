/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luis Arevalo
 */
public class Coneccion 
{    
    Connection cn;
    public Connection conexion ()
    {
        String url = "jdbc:mysql://localhost:3306/manejovivero";
        String username = "Luis";
        String password = "Admin123";        
        
        System.out.println("Cargando driver...");
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Cargado");
            cn = DriverManager.getConnection(url,username, password);
            System.out.println("Base de Datos Conectada! ");
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery("selected * from especie");
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException ("No se encontro el driver/Base de Datos! en el Classpath", e); 
        }
        return cn;
    }
    
    Statement createStatement()
    {
        throw new UnsupportedOperationException("No soportado");
    }
    
}
