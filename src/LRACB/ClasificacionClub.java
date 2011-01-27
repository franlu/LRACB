package LRACB;

import java.util.ArrayList;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class ClasificacionClub implements Comparable{

    private int partidosGanados;
    private int partidosPerdidos;
    private int puntosAFavor;
    private int puntosEnContra;

    private Jornada jornada;
    private Club club;


    ClasificacionClub(Club club, int ganados, int perdidos, int puntosAFavor, int puntosEnContra){

        //usar modificadores operaciones set
        //asignarClub(club);
        //modificarGanados(ganados); setGanados(ganados);


        this.club = club;
        this.partidosGanados = ganados;
        this.partidosPerdidos = perdidos;
        this.puntosAFavor = puntosAFavor;
        this.puntosEnContra = puntosEnContra;

    }

    int[] obtenerResultados(){

        int[] resulJorAnterior = new int[4];

            resulJorAnterior[0] = this.partidosGanados;
            resulJorAnterior[1] = this.partidosPerdidos;
            resulJorAnterior[2] = this.puntosAFavor;
            resulJorAnterior[3] = this.puntosEnContra;

        return resulJorAnterior;
    
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

    public int compareTo(Object obj){

        ClasificacionClub cc = (ClasificacionClub) obj;

        if (getPartidosGanados() == cc.getPartidosGanados())
            return 0;

        if (getPartidosGanados() > cc.getPartidosGanados())
            return -1;

        return 1;

    }

    int getPartidosGanados(){

        return this.partidosGanados;

    }
}
