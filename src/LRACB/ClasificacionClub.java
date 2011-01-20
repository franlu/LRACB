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


    void crear(Club club, int ganados, int perdidos, int puntosAFavor, int puntosEnContra){}
    ArrayList obtenerResultados(){}
    
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
