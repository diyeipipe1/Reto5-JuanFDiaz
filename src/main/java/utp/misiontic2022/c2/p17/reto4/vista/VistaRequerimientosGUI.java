package utp.misiontic2022.c2.p17.reto4.vista;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utp.misiontic2022.c2.p17.reto4.controlador.ControladorRequerimientos;

public class VistaRequerimientosGUI extends JFrame{
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;
    private JLabel txtTitulo;
    private JLabel txtSubTitulo;
    private JLabel txtReq1;
    private JLabel txtReq2;
    private JLabel txtReq3;

    public VistaRequerimientosGUI(){
        initGUI();
    }

    public void initGUI(){
        setTitle("Reto 5 - GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(5,1));

        btnRequerimiento1= new JButton("Generar");
        btnRequerimiento2= new JButton("Generar");
        btnRequerimiento3= new JButton("Generar");

        txtReq1= new JLabel("Requerimiento 1");
        txtReq2= new JLabel("Requerimiento 2");
        txtReq3= new JLabel("Requerimiento 3");

        txtTitulo= new JLabel("Reto 5 - Juan F Diaz");
        txtTitulo.setFont(new Font("Serif", Font.PLAIN, 24));
        txtSubTitulo= new JLabel("Consultas");
        txtSubTitulo.setFont(new Font("Serif", Font.PLAIN, 20));

        JPanel panel = new JPanel();
        panel.add(txtTitulo); 
        getContentPane().add(panel);

        panel = new JPanel();
        panel.add(txtSubTitulo); 
        getContentPane().add(panel); 

        panel = new JPanel();
        panel.add(txtReq1);
        panel.add(btnRequerimiento1);
        getContentPane().add(panel);

        panel = new JPanel();
        panel.add(txtReq2);
        panel.add(btnRequerimiento2);
        getContentPane().add(panel);

        panel = new JPanel();
        panel.add(txtReq3);
        panel.add(btnRequerimiento3);
        getContentPane().add(panel); 

        setSize(450,350);
        setLocationRelativeTo(null);

    }

    public void iniciar(ControladorRequerimientos controlador){
        //3_La ventana se creó cuando el controlador creó la variable tipo VistaRequerimietoGUI vista
        //Este método activa los action listeners y les da la clase que implementa el action listener como 
        //parámetro, siento la clase controlador. Luego activa la ventana volviendola visible. Al click un botón 
        //se genera una acción.
        btnRequerimiento1.addActionListener(controlador);
        btnRequerimiento2.addActionListener(controlador);
        btnRequerimiento3.addActionListener(controlador);

        setVisible(true);

    }

    public void mostrarExcepcion(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Reto 5 - GUI", JOptionPane.ERROR_MESSAGE);
    }

    public JButton getBtnRequerimiento1(){
        return btnRequerimiento1;
    }
    public JButton getBtnRequerimiento2(){
        return btnRequerimiento2;
    }
    public JButton getBtnRequerimiento3(){
        return btnRequerimiento3;
    }

    
}
