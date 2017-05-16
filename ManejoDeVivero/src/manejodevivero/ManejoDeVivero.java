/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;
import AdministradorConexion.*;
/**
 *
 * @author Luis Arevalo
 */
public class ManejoDeVivero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
//        Ventana_Principal v = new Ventana_Principal ();
//        Coneccion con = new Coneccion ();
//        con.conexion();         
        TransaccionesSQL ejem = new TransaccionesSQL();
        ejem.setVisible(true);
//        v.setVisible(true);            
        
                
    }
    
}
