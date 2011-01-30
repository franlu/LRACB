package LRACB;

import java.util.ArrayList;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class ResultadoVisitante {

    private int puntos;

    private Club club;
    //crear
    ResultadoVisitante(Club cv){}
    
    void modificarResultado(int puntosVisi){

        this.puntos = puntosVisi;

    }
    ArrayList obtenerResultadoNomClub(){

        ArrayList resultado = new ArrayList();


        return resultado;

    }
    String obtenerNombClubVisi(){

        return this.club.getNombre();

    }
    //No esta en DCDiseño obtenerPabellon Generalizar clase
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
        
        if (this.club == cl)
            return true;
        else
            return false;
    }

}
