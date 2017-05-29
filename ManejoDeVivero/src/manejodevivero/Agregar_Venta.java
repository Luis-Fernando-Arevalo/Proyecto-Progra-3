/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;

import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Luis Arevalo
 */
public class Agregar_Venta extends JFrame
{
    private JTextField txtCantidad;
    private JComboBox cbEspecie;
    private JLabel lblCantidad,lblEspecie;
    private JButton btnVenta;
    
    public Agregar_Venta()
    {
        inicializarComponentes();
        configurarVentana();
    }
    
    private void inicializarComponentes()
    {
        txtCantidad = new JTextField ();
        cbEspecie = new JComboBox ();
        lblCantidad = new JLabel("Cantidad");
        
        txtCantidad.setBounds(200,20,300,25);
        cbEspecie.setBounds(200,60,300,25);
        lblCantidad.setBounds(20,20,100,30);
        
        this.add(txtCantidad);
        this.add(cbEspecie);
        this.add(lblCantidad);
    }
    
    private void configurarVentana() {
        this.setTitle("Vivero La Bolivianita");
        this.setSize(600, 300);        
        this.setResizable(true);
        this.setLocationRelativeTo(null); // centered
        this.setLayout(null); // work frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
}
