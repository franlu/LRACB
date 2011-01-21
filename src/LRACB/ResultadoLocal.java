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
    ArrayList obtenerResultadoNomClub(){}
    String obtenerNombClubLocal(){}
    String obtenerPabellon(){}
    Jugador obtenerJugador(String dniPas){}
    boolean perteneceJugador(String dniPas){}
    boolean participaClub(Club cl, Club cv){}
}
