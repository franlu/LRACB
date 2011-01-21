package LRACB;

import java.util.ArrayList;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class ClasificacionClub {

    private int partidosGanados;
    private int partidosPerdidos;
    private int puntosAFavor;
    private int puntosEnContra;

    private Jornada jornada;
    private Club club;


    ClasificacionClub(Club club, int ganados, int perdidos, int puntosAFavor, int puntosEnContra){


    }

    int[] obtenerResultado(){

        int[] resultado;


        return resultado;
    
    }
    
    ArrayList obtenerDatosClasificacion(){

        ArrayList datosClasificacion = new ArrayList();
        String nombre = (this.club).getNombre();

                datosClasificacion.add(nombre);
                datosClasificacion.add(this.partidosGanados);
                datosClasificacion.add(this.partidosPerdidos);
                datosClasificacion.add(this.puntosAFavor);
                datosClasificacion.add(this.puntosEnContra);

        return datosClasificacion;

    }
    
}
