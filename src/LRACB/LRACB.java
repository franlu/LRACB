/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author fran
 */
public class LRACB {

    void definirJornada(Calendar listaDeFechas ){


    }

    void incluirJugador(String nombClub,String dniPass, String nomJugador,
                       Calendar fechaNac, double altura, double peso, String posicion,
                       String nacionalidad, int numero){


    }

    void anotarResultado(int numJornada, Calendar dia, String nombClubLocal, int puntosLocal, int puntosVisi){

       String nombClubVisitante;
       Jornada jor1 = buscarJornada(numJornada);
           jor1.anotarResultado(....);
           nombClubVisitante = obtenerNombClubVisitante(....);
           if (numJornada != 1)
               Jornada jorAnterior = buscarJornada(numJornada -1);
           String[] auxNombClub = new String[2];
           auxNombClub[0] = nombClubLocal;
           auxNombClub[1] = nombClubVisitante;
  

           Club club = buscarClub(auxNombClub[i]);
           // Lineas en folio de apuntes de clase
           // before search object Club
           int ganados = resultadoAnterior[0];
           int perdidos = resultadoAnterior[1];
           int puntosAFavor = resultadoAnterior[2];
           int puntosEnContra = resultadoAnterior[3];          
 
           if (i==1){ // Local
            if (puntosLocal > puntosVisitante)
                ganados++;
            else
                perdidos++; 


           } 
           

           jor1.definirClasificacion(club,ganados,perdidos,puntosAFavor,puntosEnContra);

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
