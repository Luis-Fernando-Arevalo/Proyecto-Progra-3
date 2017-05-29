/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorConexion;

import java.awt.event.ActionEvent;
import javax.swing.*;
import AdministradorConexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Arevalo
 */
public class TransaccionesSQL extends JFrame
{
    private JButton btnInsertar, btnLimpiar, btnModificar, btnGuardar, btnEliminar;
    private Coneccion con;
    private Connection cn;
    private JTextField txtEspecie, txtCantidad, txtCosto,txtID;
    private JLabel lblEspecie, lblCantidad, lblCosto;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JScrollPane barra;
    private JPanel panel;
    
    public TransaccionesSQL() {
        super();        
        configurarVentana();
        inicializarComponentes();  
        initializeComponentAction();
        mostrarTabla();
    }  
    
    private void configurarVentana() {
        this.setTitle("Vivero La Bolivianita");
        this.setSize(650, 600);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null); // centered
        this.setLayout(null); // work frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    private void inicializarComponentes() {
        // crea componentes               
        btnInsertar = new JButton();  
        con = new Coneccion();
        cn = con.conexion();
        txtEspecie = new JTextField();
        txtCantidad = new JTextField();
        txtCosto = new JTextField();
        lblEspecie = new JLabel();
        lblCantidad = new JLabel();
        lblCosto = new JLabel ();
        btnLimpiar = new JButton();
        btnModificar = new JButton();
        btnGuardar = new JButton();
        txtID = new JTextField();
        tabla = new JTable();
        btnEliminar = new JButton ();
        
                        
        // configurar componentes        
        btnInsertar.setText("Insertar");
        btnInsertar.setBounds(20, 500, 100, 30);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBounds(140,500,100,30);
        btnModificar.setText("Modificar");
        btnModificar.setBounds(260, 500, 100, 30);
        btnGuardar.setText("Guardar");
        btnGuardar.setBounds(380, 500, 100, 30);
        btnEliminar.setText("Eliminar");
        btnEliminar.setBounds(500,500,100,30);
        txtEspecie.setBounds(180, 350, 300, 30);
        txtCantidad.setBounds(180, 400, 300, 30);
        txtCosto.setBounds(180, 450, 300, 30);
        txtID.setBounds(600, 600, 100, 30);
        lblEspecie.setText("Especie");
        lblEspecie.setBounds(50, 350, 200, 30);
        lblCantidad.setText("Cantidad");
        lblCantidad.setBounds(50, 400, 200, 30);
        lblCosto.setText("Costo");
        lblCosto.setBounds(50, 450, 200, 30);        
                                
        // añade componentes a la ventana        
        this.add(btnInsertar);   
        this.add(txtEspecie);
        this.add(txtCantidad);
        this.add(txtCosto);
        this.add(lblEspecie);
        this.add(lblCantidad);
        this.add(lblCosto);
        this.add(btnLimpiar);
        this.add(btnModificar);
        this.add(btnGuardar);
        this.add(txtID);
        this.add(btnEliminar);
    }
    
    private void mostrarTabla ()
    {                
        
        modelo = new DefaultTableModel();        
        modelo.addColumn("ID_Especie");
        modelo.addColumn("Especie");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Costo");                
        tabla.setModel(modelo);                   

        String sql = "SELECT * FROM especie";        
        
        String datos[]= new String [4];
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);                
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla.setBounds(10, 30, 550, 300);
        this.add(tabla);
        
    }
    
    private void Limpiar()
    {
        txtEspecie.setText("");
        txtCantidad.setText("");
        txtCosto.setText("");
        txtID.setText("");
    }
     
     private void initializeComponentAction() {
                
        btnInsertar.addActionListener((ActionEvent ev) -> {
            try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO especie(Nombre,Cantidad,Costo) VALUES (?,?,?)");
                pps.setString(1, txtEspecie.getText());
                pps.setString (2, txtCantidad.getText());
                pps.setString (3, txtCosto.getText());                
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos guardados");
            } catch (SQLException ex) {
                Logger.getLogger(TransaccionesSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarTabla();
            Limpiar();
        });          
        
        btnLimpiar.addActionListener((ActionEvent ev) -> {
            Limpiar(); 
            mostrarTabla();
        });      
        
        btnModificar.addActionListener((ActionEvent ev) -> {
            int fila = tabla.getSelectedRow();
            if (fila>=0) 
            {
                txtID.setText(tabla.getValueAt(fila, 0).toString());
                txtEspecie.setText(tabla.getValueAt(fila, 1).toString());
                txtCantidad.setText(tabla.getValueAt(fila, 2).toString());
                txtCosto.setText(tabla.getValueAt(fila, 3).toString());                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        });
        
        btnGuardar.addActionListener((ActionEvent ev) -> {
            try {
                PreparedStatement pps = cn.prepareStatement("UPDATE especie SET Nombre='"+txtEspecie.getText()+"',Cantidad='"+txtCantidad.getText()+"',Costo='"+txtCosto.getText()+"' WHERE idEspecie='"+txtID.getText()+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
                Limpiar();               
            } catch (SQLException ex) {
                Logger.getLogger(TransaccionesSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarTabla();
        });   
        
        btnEliminar.addActionListener((ActionEvent ev) ->{
            int fila = tabla.getSelectedRow();
            String valor = tabla.getValueAt(fila, 0).toString();
            if (fila>=0) 
            {
                try {
                    PreparedStatement pps = cn.prepareStatement("DELETE FROM especie WHERE idEspecie='"+valor+"'");
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Dato Eliminado");
                } catch (SQLException ex) {
                    Logger.getLogger(TransaccionesSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarTabla();
            }
        });
        
    }
}
