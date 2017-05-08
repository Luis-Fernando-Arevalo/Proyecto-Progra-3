/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *DefaultTableModelo datos = new DefaultTableModel();
  JTable tabla = new JTable(datos);
 * @author Luis Arevalo
 */
public class Inventario_Especie extends JFrame
{
    private JTabbedPane barraMenu;
    private JPanel menuAgregar,menuModificar,menuBuscar;
    private JButton btnAtras, btnGuardar, btnLimpiar;
    private JLabel lblAgregar,lblPrecio,lblCantidad,lblCosto;
    private JTextField txtAgregar,txtPrecio, txtCantidad, txtCosto; 
    private JTable tabla;
    private DefaultTableModel datos;
     
    public Inventario_Especie() {
        super();        
        configurarVentana();
        inicializarComponentes(); 
        initializeComponentAction();
    }    
    
    private void inicializarComponentes() {
        // crea componentes               
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
        
        datos = new DefaultTableModel( new String [5], ABORT);
        tabla = new JTable (datos);
        
        menuAgregar.setLayout(null);
        menuBuscar.setLayout(null);
        //Elementos de Tab Buscar
        tabla.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
            },
        new String [] {
        "Especie", "Cantidad", "Precio", "Costo"
         }
        )); 
        tabla.setBounds(30, 50, 510, 250);
        //Elementos de Tab Agregar
        barraMenu.addTab("Agregar", menuAgregar);
        barraMenu.addTab("Modificar", menuModificar);
        barraMenu.addTab("Buscar", menuBuscar);        
        btnAtras.setIcon(new ImageIcon("/start/boton.jpg"));
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
        
        menuBuscar.add(tabla);
                        
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
            this.setVisible(false);
        });
        
    }
}
