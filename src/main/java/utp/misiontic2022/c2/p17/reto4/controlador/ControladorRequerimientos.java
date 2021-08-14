package utp.misiontic2022.c2.p17.reto4.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.text.View;

import utp.misiontic2022.c2.p17.reto4.modelo.dao.Requerimiento_1Dao;
import utp.misiontic2022.c2.p17.reto4.modelo.dao.Requerimiento_2Dao;
import utp.misiontic2022.c2.p17.reto4.modelo.dao.Requerimiento_3Dao;
import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p17.reto4.vista.ListaRequerimientosGUI;
import utp.misiontic2022.c2.p17.reto4.vista.VistaRequerimientosGUI;

public class ControladorRequerimientos implements ActionListener{
    private final Requerimiento_1Dao requerimiento_1Dao;
    private final Requerimiento_2Dao requerimiento_2Dao;
    private final Requerimiento_3Dao requerimiento_3Dao;
    
    private final VistaRequerimientosGUI vista;
    private final ListaRequerimientosGUI vistalista;

    public ControladorRequerimientos(){
        this.requerimiento_1Dao= new Requerimiento_1Dao();
        this.requerimiento_2Dao= new Requerimiento_2Dao();
        this.requerimiento_3Dao= new Requerimiento_3Dao();
        this.vista= new VistaRequerimientosGUI();
        this.vistalista= new ListaRequerimientosGUI();
    }
    
    public ArrayList<Requerimiento_1> consultarRequerimiento1() throws SQLException {
        //4_2 El método requerimiento 1 crea un ArrayList y recibe el ArrayList del parámetro 
        //requerimiento_1Dao que es de la clase Requerimiento_1Dao.
        ArrayList<Requerimiento_1> reqlist1= new ArrayList<>();
        reqlist1= requerimiento_1Dao.requerimiento1();
        return reqlist1;
    }

    public ArrayList<Requerimiento_2> consultarRequerimiento2() throws SQLException {
        return requerimiento_2Dao.requerimiento2();
    }

    public ArrayList<Requerimiento_3> consultarRequerimiento3() throws SQLException {
        ArrayList<Requerimiento_3> reqlist3= new ArrayList<>();
        reqlist3= requerimiento_3Dao.requerimiento3();
        return reqlist3;
    }

    public void iniciar(){
        //2_Con el parámetro vista que es un objeto JFrame o sea una ventana, se llamá el método iniciar
        // Que es el que lo vuelve visible.
        vista.iniciar(this);
    }


    public void actionPerformed(ActionEvent e){
        //4_Este es el método que recibe el botón como tal. Primero compara a ver cúal botón fue activado
        //para así deicidir qué hacer. Tiene un try catch para mostrar todo tipo de error generado en el dao
        //o con el Swing al invocar el método mostrarExcepción de la Vista. Ese método mostrando el error y 
        //por eso en esa clase.
        try {
            if(e.getSource()==vista.getBtnRequerimiento1()){
                //Cierra la ventana anterior 
                vista.dispose();

                //Crea un ArrayList con objetos vo de la clase Requerimiento_1
                ArrayList<Requerimiento_1> req1list= new ArrayList<>();
                //Llena el ArrayList con los objetos usando el método de consultarRequerimiento1.. 04_1
                req1list= consultarRequerimiento1();

                //Crea los contenedores de tamaño de los resultados de la consulta
                int tamano= req1list.size();
                String[] columns= {"Nombre","Cargo","#Proyectos"};
                String[][] data= new String[tamano][tamano];

                //Llena los contenedores recorriendo los objetos uno a uno y asignando los valores uno a uno

                int cont= 0;
                for (Requerimiento_1 req1 : req1list) {
                    data[cont][0]=req1.getNombre();
                    data[cont][1]=req1.getCargo();
                    data[cont][2]=String.valueOf(req1.getNumproyectos());
                    cont+=1;
                }

                //5_Manda los datos a el método para inicializar la ventana ListaRequerimientos y mostrarla
                vistalista.initGUI(1,columns,data);

            }
            else if(e.getSource()==vista.getBtnRequerimiento2()){

                vista.dispose();

                ArrayList<Requerimiento_2> req2list= new ArrayList<>();
                req2list= consultarRequerimiento2();

                int tamano= req2list.size();
                String[] columns= {"ID material","Nombre","Cantidad","Precio unitario","Precio total"};
                String[][] data= new String[tamano][tamano];

                int cont= 0;
                for (Requerimiento_2 req2 : req2list) {
                    data[cont][0]=String.valueOf(req2.getId_matconstruc()); 
                    data[cont][1]=req2.getNommaterial(); 
                    data[cont][2]=String.valueOf(req2.getCantidad()); 
                    data[cont][3]=String.valueOf(req2.getPrecio_unit()); 
                    data[cont][4]=String.valueOf(req2.getPrecio_total()); 
                    cont+=1;
                }

                vistalista.initGUI(2,columns,data);

            }
            else if(e.getSource()==vista.getBtnRequerimiento3()){

                vista.dispose();

                ArrayList<Requerimiento_3> req3list= new ArrayList<>();
                req3list= consultarRequerimiento3();
                
                int tamano= req3list.size();
                String[] columns= {"ID proyecto","Ciudad","Clasificación","Costo del proyecto"};
                String[][] data= new String[tamano][tamano];

                int cont= 0;
                for (Requerimiento_3 req3 : req3list) {
                    data[cont][0]=String.valueOf(req3.getId_proyecto()); 
                    data[cont][1]=req3.getCiudad(); 
                    data[cont][2]=req3.getClasificacion(); 
                    data[cont][3]=String.valueOf(req3.getCosto_proyecto()); 

                    cont+=1;
                }

                vistalista.initGUI(3,columns,data);  
            }
        } catch (Exception ex) {
            vista.mostrarExcepcion(ex);
        }
    }


}