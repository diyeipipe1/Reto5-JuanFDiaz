package utp.misiontic2022.c2.p17.reto4.vista;

import java.util.ArrayList;

import utp.misiontic2022.c2.p17.reto4.controlador.ControladorRequerimientos;

import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p17.reto4.modelo.vo.Requerimiento_3;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1(){
        try {
            ArrayList<Requerimiento_1> req1list= new ArrayList<>();
            req1list= controlador.consultarRequerimiento1();
            for (Requerimiento_1 req1 : req1list) {
                System.out.println(req1.getNombre()+" "+req1.getCargo()+" "+req1.getNumproyectos());
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento2(){
        try {
            ArrayList<Requerimiento_2> req2list= new ArrayList<>();
            req2list= controlador.consultarRequerimiento2();
            for (Requerimiento_2 req2 : req2list) {
                System.out.println(req2.getId_matconstruc()+" "+req2.getNommaterial()+" "+req2.getCantidad()+" "+req2.getPrecio_unit()+" "+req2.getPrecio_total());                
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento3(){
        try {
            ArrayList<Requerimiento_3> req3list= new ArrayList<>();
            req3list= controlador.consultarRequerimiento3();
            for (Requerimiento_3 req3 : req3list) {
                System.out.println(req3.getId_proyecto()+" "+req3.getCiudad()+" "+req3.getClasificacion()+" "+req3.getCosto_proyecto());
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
