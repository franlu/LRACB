/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

import java.util.Date;
import java.util.List;

/**
 *
 * @author fran
 */
public class LRACB {

    void definirJornada(Date listaDeFechas ){


    }

    void incluirJugador(String nombClub,String dniPass, String nomJugador,
                       Date fechaNac, double altura, double peso, String posicion,
                       String nacionalidad, int numero){


    }

    void anotarResultado(int numJornada, Calendar dia, String nombClubLocal, int puntosLocal, int puntosVisi){

       String nombClubVisitante:
       Jornada jor1 = buscarJornada(numJornada);
           jor1.anotarResultado(....);
           nombClubVisitante = obtenerNombClubVisitante(....);
           if (numJornada != 1)
               Jornada jorAnterior = buscarJornada(numJornada -1);
           String[] auxNombClub = new String[2];
           auxNombClub[0] = nombClubLocal;
           auxNombClub[1] = nombClubVisitante;
  


    }

    List resultadoJugadores(int numJornada, Date dia, String nombClubLocal){

        List aux = null;
        
        return aux;

    }
    Jornada buscarJornada(int numJornada){
        Jornada j = new Jornada();
        return j;
    }
    boolean existeJugador(String dniPass){

        boolean existe = true;
        return existe;
    }

}
