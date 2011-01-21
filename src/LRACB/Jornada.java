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
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class Jornada {

    private int numJornada;
    private Fecha fecha;
    //key nombre del club
    private Map<String,ClasificacionClub> cClub = new HashMap<String,ClasificacionClub>();
    //key nombreJugador no double rendimiento
    private Map<String,ClasificacionJugador> cJugador = new HashMap<String,ClasificacionJugador>();

    //DC definirJornada
    Jornada(int numJornada, Calendar[] listaDeFechas){

    
            
    
    }

    boolean esAnterior(Calendar[] listaDeFechas){

        return true;

    }

    //int obtenerNumero(){
    int getNumero(){

        return this.numJornada;
    }

    //ojo con este int vector de 4 posiciones
    int[] obtenerResultado(String nombClub){

        ClasificacionClub cc = buscarCClub(nombClub);
        return cc.obtenerResultados();
    }

    void anotarResultado(GregorianCalendar dia, String nombClubLocal,int puntosLocal, int puntosVisi){

        Fecha fech = buscarFecha(dia);

        fech.anotarResultado(nombClubLocal,puntosLocal, puntosVisi);

    }

    String obtenerNombClubVisitante(GregorianCalendar dia, String nombClubLocal){

        Fecha fech = buscarFecha(dia);

        return fech.obtenerNombClubVisi(nombClubLocal);

    }

    void definirClasificacionClub(Club cl, int ganados, int perdidos, int puntosAFavor, int puntosEnContra){

        ClasificacionClub cc = new ClasificacionClub(cl,ganados,perdidos,puntosAFavor,puntosEnContra);

        (this.cClub).put(cl.getNombre(),cc);

    }

    ArrayList resultadoJugadores(Calendar dia, String nombClubLocal ){

        ArrayList resultado = new ArrayList();
        ArrayList resultado1 = new ArrayList();

            resultado.add(this.numJornada);
            resultado1 = (this.fecha).resultadoJugadores(dia, nombClubLocal);
            resultado.add(resultado1);

            return resultado;

    }

    private Fecha buscarFecha(Calendar dia){



    }
    private ClasificacionClub buscarCClub(String nombClub){}

    ArrayList verPartidoDeJornada(){}
    
    ArrayList clasificacionGeneral(){

        ArrayList resultado = new ArrayList();
        resultado.add(this.numJornada);
            if ((this.cClub).size() == 0) {

                resultado.add("No hay clasificacion para esa Jornada");

            }
            else{

                ordenarPorPartidosGanados();
                ArrayList datosClasificacion = new ArrayList();
                Iterator it = (this.cClub).entrySet().iterator();
                ClasificacionClub clc;

                while (it.hasNext()) {// Ojo con los casting
                    Map.Entry e = (Map.Entry)it.next();
                    clc= (ClasificacionClub) e.getValue();
                    datosClasificacion = clc.obtenerDatosClasificacion();
                    resultado.add(datosClasificacion);
                }

            }

        return resultado;
    }

    //private por DC ClasificacionGeneral
    private void ordenarPorPartidosGanados(){

    }

    ArrayList rankingAnotadores(){
    
        ArrayList resultado = new ArrayList();
        
            resultado.add(this.numJornada);
            if ((this.cJugador).size() == 0) {
                
                resultado.add("No existe la clasificacion para esa Jornada");          
            
            }
            else{
            
                ordenarPorRendimiento();
                ArrayList datosClasificacion = new ArrayList();
                Iterator it = (this.cJugador).entrySet().iterator();
                ClasificacionJugador clj;

                while (it.hasNext()) {// Ojo con los casting
                    Map.Entry e = (Map.Entry)it.next();
                    clj = (ClasificacionJugador) e.getValue();
                    datosClasificacion = clj.obtenerDatosClasificacion();
                    resultado.add(datosClasificacion);
                }
            
            }
        
        
        return resultado;   
    
    }
    //DC rankingAnotadores ----- ordenar Map por key no se puede porque la key es String
    private void ordenarPorRendimiento(){

        //Dejara un documento en swad
        List cjs = (this.cJugador).values();
        Collections cjs =
        Collections.sort(cjs);


    }
    void anotarResultadoJugador(Calendar dia,String nombClubLocal, String dniPas,
                                double minutosJugados, int intentos, int puntosConseguidos){}
    void incluirClasificacion(Jugador jug, double minutosTotales, int intentosTotales, int puntosTotales){}
    void definirPartido(Calendar dia, Club cl, Club cv, Calendar hora,String TVEmite){}
}
