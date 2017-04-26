/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Luis Arevalo
 */
public class Inventario_Especie extends JFrame
{
    private JMenuBar barraMenu;
    private JMenu menuAgregar,menuModificar,menuMostrar;
    private JButton btnAtras;
     
    public Inventario_Especie() {
        super();        
        configurarVentana();
        inicializarComponentes(); 
        initializeComponentAction();
    }    
    
    private void inicializarComponentes() {
        // crea componentes               
        barraMenu =new JMenuBar();   
        menuAgregar = new JMenu ("Agregar");
        menuModificar = new JMenu ("Modificar");
        menuMostrar = new JMenu ("Historial");
        btnAtras = new JButton ();
                                
        btnAtras.setText("Atras");
        btnAtras.setBounds(50, 900, 100, 30);
                
        // añade componentes a la ventana       
        this.add(barraMenu);
        this.barraMenu.add(this.menuAgregar);
        this.barraMenu.add(this.menuModificar);       
        this.barraMenu.add(this.menuMostrar);
        this.setJMenuBar(this.barraMenu);
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
