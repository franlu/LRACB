/*
* LRACB
*
* Informacion de la version
*
* Fecha
*
* Copyright
*/
package LRACB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class Fecha {

    private Calendar dia;
    //hora,partido
    private Map<Calendar,Partido> Partidos = new HashMap<Calendar,Partido>();

    void crear(Calendar dia){}
    boolean esAnterior(Calendar dia){

        return true;

    }
    String obtenerNombClubVisi(String nombClubLocal){}

    void anotarResultado(String nombClubLocal, int puntosLocal, int puntosVisi){

        Partido par = buscarPartido(nombClubLocal);
        par.anotarResultado(puntosLocal, puntosVisi);
        
    }

    // en diagrama de colaboracion no aparece el parametro dia
    ArrayList resultadoJugadores(Calendar dia, String nombClubLocal){

        Partido par = buscarPartido(nombClubLocal);
        ArrayList resultado1 = par.resultadoJugadores();

        return resultado1;

    }
    private Partido buscarPartido(String nombClubLocal){



    }
    ArrayList partidosDeUnDia(){}
    void anotarResultadoJugador(String nombClubLocal, String dniPas, double minutosJugados,
            int intentos, int puntosConseguidos){}
    // Errata en DCDiseño
    boolean participaPartido(Club cl, Club cv){}
    void definirPartido(Club cl, Club cl, Date hora, String TVEmite){}
    
}
