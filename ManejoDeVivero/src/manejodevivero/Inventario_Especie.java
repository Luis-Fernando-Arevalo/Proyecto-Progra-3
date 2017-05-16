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
import java.sql.Statement;

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
    private JButton btnAtras, btnGuardar, btnLimpiar;
    private JLabel lblAgregar,lblPrecio,lblCantidad,lblCosto;
    private JTextField txtAgregar,txtPrecio, txtCantidad, txtCosto; 
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
        txtAgregar = new JTextField ();
        txtPrecio = new JTextField ();
        txtCantidad = new JTextField ();
        txtCosto = new JTextField ();     
        tablaPrincipal = new JTable ();
        tablaModelo = new DefaultTableModel();
                               
        menuAgregar.setLayout(null);
        menuBuscar.setLayout(null);
        //Elementos de Tab Buscar
        tablaModelo.addColumn("Especie");
        tablaModelo.addColumn("Cantidad");
        tablaModelo.addColumn("Costo");
        tablaPrincipal.setModel(tablaModelo);
        String sql = "SELECT * FROM especie";
        String datos[]=new String[3];
//        Statement st = cn 
        
        tablaPrincipal.setBounds(30, 50, 510, 250);
        //Elementos de Tab Agregar
        barraMenu.addTab("Agregar", menuAgregar);
        barraMenu.addTab("Modificar", menuModificar);
        barraMenu.addTab("Buscar", menuBuscar);        
        btnAtras.setIcon(new ImageIcon("src/boton.jpg"));
        btnAtras.setBounds(0, 0, 30, 30);
        btnGuardar.setText("Guardar");
        btnGuardar.setBounds(60, 280, 100, 30);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBounds(400, 280, 100, 30);
        lblAgregar.setText("Agregar Especie");
        lblAgregar.setBounds(50, 80, 100, 20);
        txtAgregar.setText("");
        txtAgregar.setBounds(180, 80, 300, 20);
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
        menuAgregar.add(txtAgregar);
        menuAgregar.add(txtCosto);
        menuAgregar.add(txtPrecio);
        menuAgregar.add(txtCantidad);
        menuAgregar.add(btnGuardar);
        menuAgregar.add(btnLimpiar);
        
        menuBuscar.add(tablaPrincipal);
                        
        this.add(barraMenu);                

    }

    private void configurarVentana() {
        this.setTitle("Vivero La Bolivianita");
        this.setSize(600, 400);        
        this.setResizable(true);
        this.setLocationRelativeTo(null); // centered
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    private void initializeComponentAction() {
                
        btnAtras.addActionListener((ActionEvent ev) -> {
            Ventana_Principal v = new Ventana_Principal();
            v.setVisible(true);
            Inventario_Especie.this.setVisible(false);
        });
        
    }
}
