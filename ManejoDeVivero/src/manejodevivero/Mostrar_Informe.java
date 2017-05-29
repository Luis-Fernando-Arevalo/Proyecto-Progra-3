/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Arevalo
 */
public class Mostrar_Informe extends JFrame
{
    private JButton btnAtras;
    private JTable tabla;
    private JScrollPane scroll;
    private DefaultTableModel modelo;
    private JPanel panel;
    
    
    public Mostrar_Informe() {
        super();        
        configurarVentana();
        inicializarComponentes(); 
        initializeComponentAction();
    }    
    
    private void inicializarComponentes() {
        // crea componentes                       
        btnAtras = new JButton ();          
        panel = new JPanel();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id_Especie");
        modelo.addColumn("Especie");
        modelo.addColumn("Ganancia Neta");
        tabla = new JTable(modelo);
        scroll = new JScrollPane (tabla);
        scroll.setBounds(10,10,900,850);
//        panel.add(scroll);
        this.add(scroll);
        
        btnAtras.setText("Atras");
        btnAtras.setBounds(50, 900, 100, 30);
                
        // añade componentes a la ventana               
        this.add(btnAtras);
                
    }
    
    private void configurarVentana() {
        this.setTitle("Vivero La Bolivianita");
        this.setSize(1000, 1000);        
        this.setResizable(true);
        this.setLocationRelativeTo(null); // centered
        this.setLayout(null); // work frame
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
