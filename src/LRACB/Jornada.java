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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fran
 */
class Jornada {

    private int numJornada;
    private Fecha fecha;
    private Map<String,ClasificacionClub> cClub = new HashMap<String,ClasificacionClub>();
    private Map<String,ClasificacionJugador> cJugador = new HashMap<String,ClasificacionJugador>();

    Jornada(int numJornada, Calendar listaDeFechas){
    
        this.numJornada = numJornada;
    
    
    }

    boolean esAnterior(Calendar listaDeFechas){

        return true;

    }

    int obtenerNumero(){

        return this.numJornada;
    }

    ArrayList obtenerResultados(String nombClub){

    }

    void anotarResultado(Calendar dia, String nombClubLocal,int puntosLocal, int puntosVisi){
    }

    String obtenerNombClubVisitante(Calendar dia, String nombClubLocal){


    }

    void definirClasificacionClub(Club cl, int ganados, int perdidos, int puntosAFavor, int puntosEnContra){

    }

    ArrayList resultadoJugadores(Calendar dia, String nombClubLocal ){

        ArrayList resultado = new ArrayList();
        ArrayList resultado1 = new ArrayList();

            resultado.add(this.numJornada);
            resultado1 = (this.fecha).resultadoJugadores(dia, nombClubLocal);
            resultado.add(resultado1);

            return resultado;

    }

    private Fecha buscarFecha(Calendar dia){}
    private ClasificacionClub buscarCClub(String nombClub){}

    ArrayList verPartidoDeJornada(){}
    ArrayList clasificacionGeneral(){}
    void ordenarPorPartidosGanados(){}
    ArrayList rankingAnotadores(){}
    void ordenaPorRendimiento(){}
    void anotarResultadoJugador(Calendar dia,String nombClubLocal, String dniPas,
                                double minutosJugados, int intentos, int puntosConseguidos){}
    void incluirClasificacion(Jugador jug, double minutosTotales, int intentosTotales, int puntosTotales){}
    void definirPartido(Calendar dia, Club cl, Club cv, Calendar hora,String TVEmite){}
}
