/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import AdministradorConexion.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *DefaultTableModelo datos = new DefaultTableModel();
  JTable tabla = new JTable(datos);
 * @author Luis Arevalo
 */
public class Inventario_Especie extends JFrame
{
    private Coneccion con;
    private Connection cn;
    private JTabbedPane barraMenu;
    private JPanel menuAgregar,menuModificar,menuBuscar;
    private JButton btnAtras, btnGuardar, btnLimpiar,btnBuscar;
    private JLabel lblAgregar,lblPrecio,lblCantidad,lblCosto,lblBuscar;
    private JTextField txtEspecie,txtPrecio, txtCantidad, txtCosto, txtBuscador; 
    private JTable tablaPrincipal;
    private DefaultTableModel tablaModelo;    
    
    public Inventario_Especie() {
        super();        
        configurarVentana();
        inicializarComponentes(); 
        initializeComponentAction();
    }    
    
    private void inicializarComponentes() {
        
        // crea componentes              
        con = new Coneccion();
        cn = con.conexion();
        barraMenu = new JTabbedPane();
        menuAgregar = new JPanel();
        menuModificar = new JPanel();
        menuBuscar = new JPanel();
        btnAtras = new JButton ();
        btnGuardar = new JButton ();
        btnLimpiar = new JButton ();
        lblAgregar =new JLabel ();
        lblPrecio =new JLabel ();
        lblCantidad =new JLabel ();
        lblCosto =new JLabel ();
        txtEspecie = new JTextField ();
        txtPrecio = new JTextField ();
        txtCantidad = new JTextField ();
        txtCosto = new JTextField ();     
        txtBuscador = new JTextField();
        lblBuscar= new JLabel("BUSCAR");
        btnBuscar = new JButton ();        
        tablaModelo = new DefaultTableModel();
                               
        menuAgregar.setLayout(null);
        menuBuscar.setLayout(null);
        
        //Elementos de Tab Buscar        
        tablaPrincipal = new JTable (tablaModelo);
        JScrollPane scroll = new JScrollPane(tablaPrincipal);
//        JPanel contenedor = new JPanel();
        scroll.setBounds(30, 50, 510, 110);
        txtBuscador.setBounds(90,10,400,30);
        lblBuscar.setBounds(10,10,100,30);
        btnBuscar.setIcon(new ImageIcon("src/buscar.gif"));
        btnBuscar.setBounds(500,10,30,30);
//        contenedor.add(scroll);          
        mostrarTabla();
        
        
        //Elementos de Tab Agregar
        barraMenu.addTab("Agregar", menuAgregar);
//        barraMenu.addTab("Modificar", menuModificar);
        barraMenu.addTab("Modificar", menuBuscar);        
        btnAtras.setIcon(new ImageIcon("src/boton.jpg"));
        btnAtras.setBounds(0, 0, 30, 30);
        btnGuardar.setText("Guardar");
        btnGuardar.setBounds(60, 280, 100, 30);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBounds(400, 280, 100, 30);
        lblAgregar.setText("Agregar Especie");
        lblAgregar.setBounds(50, 80, 100, 20);
        txtEspecie.setText("");
        txtEspecie.setBounds(180, 80, 300, 20);
        lblPrecio.setText("Precio");
        lblPrecio.setBounds(50, 120, 100, 20);
        txtPrecio.setText("");
        txtPrecio.setBounds(180, 120, 300, 20);
        lblCantidad.setText("Cantidad");
        lblCantidad.setBounds(50, 160, 100, 20);
        txtCantidad.setText("");
        txtCantidad.setBounds(180, 160, 300, 20);
        lblCosto.setText("Costo");
        lblCosto.setBounds(50, 200, 100, 20);
        txtCosto.setText("");
        txtCosto.setBounds(180, 200, 300, 20);
        
        
        menuAgregar.add(lblAgregar);
        menuAgregar.add(btnAtras);
        menuAgregar.add(lblCosto);
        menuAgregar.add(lblPrecio);
        menuAgregar.add(lblCantidad);
        menuAgregar.add(txtEspecie);
        menuAgregar.add(txtCosto);
        menuAgregar.add(txtPrecio);
        menuAgregar.add(txtCantidad);
        menuAgregar.add(btnGuardar);
        menuAgregar.add(btnLimpiar);
        
        menuBuscar.add(scroll);
        menuBuscar.add(txtBuscador);
        menuBuscar.add(lblBuscar);
        menuBuscar.add(btnBuscar);
                        
        this.add(barraMenu);                

    }
    
    private void mostrarTabla ()
    {
        tablaModelo = new DefaultTableModel();
        tablaModelo.addColumn("ID_Especie");
        tablaModelo.addColumn("Especie");
        tablaModelo.addColumn("Cantidad");
        tablaModelo.addColumn("Costo");                
        tablaPrincipal.setModel(tablaModelo);                          
       
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
                tablaModelo.addRow(datos);
            }
//            tablaPrincipal.setModel(tablaModelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionesSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
//        tablaPrincipal.setBounds(10, 30, 550, 300);
//        this.add(tablaPrincipal);
    }    
        
    private void configurarVentana() {
        this.setTitle("Vivero La Bolivianita");
        this.setSize(600, 400);        
        this.setResizable(true);
        this.setLocationRelativeTo(null); // centered
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    private void limpiar()
    {
        txtEspecie.setText("");
        txtCantidad.setText("");
        txtCosto.setText("");
        txtPrecio.setText("");
    }
    
    private void initializeComponentAction() {
                
        btnAtras.addActionListener((ActionEvent ev) -> {
            Ventana_Principal v = new Ventana_Principal();
            v.setVisible(true);
            Inventario_Especie.this.setVisible(false);
        });
        
        btnLimpiar.addActionListener((e) -> 
        {
            limpiar();
        });
        
        btnGuardar.addActionListener((ActionEvent ev) -> {
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
            limpiar();           
            mostrarTabla();
        });   
        
    }
}
