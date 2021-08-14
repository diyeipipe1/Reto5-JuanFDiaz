package utp.misiontic2022.c2.p17.reto4;

import utp.misiontic2022.c2.p17.reto4.controlador.ControladorRequerimientos;

/**
 * Disclaimer: Me rehuso a usar Netbeans, siento que no es aprenderx. Entonces con el ejemplo de calculadora
 * de imaster y mucho muuuuuuucho google (y ppts de imaster) logré hacer algo decente. Pongo link de algunos 
 * videos para uso y referencia futura propia, pero en el proceso de intento hasta lograr pueden haberse perdido algunos.
 * https://www.youtube.com/watch?v=wniqpx8OQxo- JTable
 * https://www.youtube.com/watch?v=HgkBvwgciB4- Otra ventana
 * https://github.com/cesardiaz-utp/MisionTIC2022-Ciclo2-Unidad5-MVC
 */
public class App 
{
    public static void main( String[] args )
    {
        //Crea un controlador para manejar la vista y modelos desde ahí, como en el ejemplo de calculadora
        var controladorr= new ControladorRequerimientos();
        //1_Se llama el método inciar del controlador que inicia la GUI de VistaRequerimientos
        controladorr.iniciar();
        
    }
}
