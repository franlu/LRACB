/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author fran
 */
class Jornada {

    private int numJornada;
    private Fecha fecha;
    private ClasificacionClub cClub;
    private ClasificacionJugador cJugador;

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

    void anotarResultado(){
    }

    String obtenerNombClubVisi(){}

    void definirClasificacionClub(){}

    ArrayList resultadoJugadores(){}

    private Fecha buscarFecha(){}
    private ClasificacionClub buscarCClub(String nombClub){}

    ArrayList verPartidoDeJornada(){}
    ArrayList clasificacionGeneral(){}
    void ordenarPorPartidosGanados(){}
    ArrayList rankingAnotadores(){}
    void ordenaPorRendimiento(){}
    void anotarResultadoJugador(){}
    void incluirClasificacion(){}
    void definirPartido(){}
}
