/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fran
 */
class Fecha {

    private Calendar dia;
    private Map<Calendar,Partido> Partidos = new HashMap<Calendar,Partido>();

    void crear(Calendar dia){}
    boolean esAnterior(Calendar dia){

        return true;

    }
    String obtenerNombClubVisi(String nombClubLocal){}
    void anotarResultado(int puntosLocal, int puntosVisi){}
    ArrayList resultadoJugadores(Calendar dia, String nombClubLocal){}
    private Partido buscarPartido(String nombClubLocal){}
    ArrayList partidosDeUnDia(){}
    void anotarResultadoJugador(String nombClubLocal, String dniPas, double minutosJugados,
            int intentos, int puntosConseguidos){}
    // Errata en DCDiseño
    boolean participaPartido(Club cl, Club cv){}
    void definirPartido(Club cl, Club cl, Date hora, String TVEmite){}
    
}
