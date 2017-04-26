/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejodevivero;

//import Clases.Conectar;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Luis Arevalo
 */
public class Ventana_Principal extends JFrame
{
    
    private JButton btnInventario_Especie, btnMostrar_Informe, btnAgregar_Venta;          
    
    public Ventana_Principal() {
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
        
        btnMostrar_Informe.setText("Informe de Ganancia");
        btnMostrar_Informe.setBounds(100, 150, 200, 30);
        
        btnAgregar_Venta.setText("Agregar Venta");
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
            this.dispose();
        });
        
        btnMostrar_Informe.addActionListener((ActionEvent ev) -> {
            Mostrar_Informe mi = new Mostrar_Informe();
            mi.setVisible(true);
            this.dispose();
        });
        
    }    
        
}
