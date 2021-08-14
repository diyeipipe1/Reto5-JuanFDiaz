package utp.misiontic2022.c2.p17.reto4.vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.GridLayout;


public class ListaRequerimientosGUI extends JFrame{
    //Atributos
    private JTable tablaReq;

    //Constructor 
    public ListaRequerimientosGUI(){
        //El constructor se dejó vació porque la construcción de la JTable resulta en diferentes tamaños
        //dependiendo de la consulta. Entonces la ventana se crea al recibir los datos.
    }

    //Métodos
    public void initGUI(int reqnum, String[] columns, String[][] data){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(1,1));
        
        if (reqnum==1){
            setTitle("Reto 5 - Requerimiento 1");
        }
        else if (reqnum==2){
            setTitle("Reto 5 - Requerimiento 2");
        }
        else{
            setTitle("Reto 5 - Requerimiento 3");
        }

        //Si el requerimiento tiene muchas entradas, hay un scrollbar.
        tablaReq= new JTable(data,columns);
        tablaReq.setPreferredScrollableViewportSize(new Dimension(500,50));
        tablaReq.setFillsViewportHeight(true);
        
        JScrollPane scrollPane= new JScrollPane(tablaReq);
        getContentPane().add(scrollPane);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
