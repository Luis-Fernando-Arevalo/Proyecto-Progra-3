/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;

//import Clases.Conectar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Luis Arevalo
 */
public class Ventana extends JFrame
{
    
    private JButton btnInventario_Especie, btnMostrar_Informe, btnAgregar_Venta;          
    
    public Ventana() {
        super();        
        configurarVentana();
        inicializarComponentes();  
        initializeComponentAction();
    }    

    private void configurarVentana() {
        this.setTitle("Vivero La Bolivianita");
        this.setSize(400, 400);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null); // centered
        this.setLayout(null); // work frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    private void inicializarComponentes() {
        // crea componentes               
        btnInventario_Especie = new JButton();
        btnMostrar_Informe = new JButton();
        btnAgregar_Venta = new JButton();        
                
        // configurar componentes        
        btnInventario_Especie.setText("Inventario Especie");
        btnInventario_Especie.setBounds(100, 100, 200, 30);
        
        btnMostrar_Informe.setText("Mostrar Informe");
        btnMostrar_Informe.setBounds(100, 150, 200, 30);
        
        btnAgregar_Venta.setText("Mostrar Informe");
        btnAgregar_Venta.setBounds(100, 200, 200, 30);
                
        // añade componentes a la ventana        
        this.add(btnInventario_Especie);
        this.add(btnMostrar_Informe);
        this.add(btnAgregar_Venta);                
    }
     
     private void initializeComponentAction() {
                
        btnInventario_Especie.addActionListener((ActionEvent ev) -> {
            Inventario_Especie ie = new Inventario_Especie();
            ie.setVisible(true);
            this.setVisible(false);
        });
        
    }    
        
}
