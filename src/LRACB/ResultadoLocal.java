/*
* ResultadoLocal
*
* Informacion de la version
*
* Fecha
*
* Copyright
*/
package LRACB;

import java.util.ArrayList;

/**
 *
 * @author fran
 */
class ResultadoLocal {

    private int puntos;

    private Club club;

    //crear
    ResultadoLocal(Club cl){

        this.club = cl;

    }
    void modificarResultado(int puntosLocal){

        this.puntos = puntosLocal;

    }
    ArrayList obtenerResultadoNomClub(){

        ArrayList resultado = new ArrayList();


        return resultado;

    }
    String obtenerNombClubLocal(){

        return this.club.getNombre();

    }
    String obtenerPabellon(){

        return this.club.getPabellon();

    }
    Jugador obtenerJugador(String dniPas){

        Jugador jug = null;
        return jug;

    }
    boolean perteneceJugador(String dniPas){

        return true;
    }
    
    boolean participaClub(Club cl, Club cv){

        if (this.club == cv)
            return true;
        else
            return false;
    }
}
