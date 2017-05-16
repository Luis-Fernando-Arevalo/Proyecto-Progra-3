/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorConexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Arevalo
 */
public class ConsultorSQL 
{
    private Connection con;
    private ResultSet rs;
    private ResultSetMetaData mtd;
    private String [] columnas;
    private String consulta, error;
    
    public ConsultorSQL (Connection c,String sql) throws SQLException
    {
        this.con=c;
        this.consulta=sql;
        
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(consulta);        
            mtd = rs.getMetaData();
            error = null;
        } catch (SQLException e) {
            error = e.getMessage();
        }
                
    }
    
    public String getError()
    {
        return this.error;
    }
    
    public ResultSet getResultado ()
    {
        return this.rs;
    }
    
    public String [] getNombresColumnas()
    {
        try {
            int numColumnas = mtd.getColumnCount();
            this.columnas = new String [numColumnas];
            
            for (int i = 0; i < numColumnas; i++) 
            {
                columnas [i] = mtd.getColumnLabel(i+1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return columnas;
    }
            
}
