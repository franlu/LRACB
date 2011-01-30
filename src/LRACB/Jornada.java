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
    private Fecha[] fecha = new Fecha[3];
    //key nombre del club compareTo en clase clasficacion con partidos Ganados
    private Map<String,ClasificacionClub> cClub = new HashMap<String,ClasificacionClub>();
    //key nombreJugador no double rendimiento
    private Map<String,ClasificacionJugador> cJugador = new HashMap<String,ClasificacionJugador>();

    
    Jornada(int numJornada, GregorianCalendar[] listaDeFechas){

        setNumero(numJornada);
        setFechas(listaDeFechas);

    }

    boolean esAnterior(GregorianCalendar[] listaDeFechas){

        //recorrer las fechas que hay en fecha y compararlas con cada gregorian calendar
        GregorianCalendar f,fj;
        boolean anterior = false;

        for(int i=0; i<listaDeFechas.length && !anterior; i++){
            f = listaDeFechas[i];
            anterior = (this.fecha[i]).esAnterior(f);
            
        }
        return anterior;

    }

    //int obtenerNumero(){
    int getNumero(){

        return this.numJornada;
    }

    Fecha[] getFechas(){

        return this.fecha;
     }

    void setNumero(int num){
        
        this.numJornada = num;
    }

    void setFechas(GregorianCalendar[] listaDeFechas){
        
        GregorianCalendar dia;
        for(int i=0; i<listaDeFechas.length; i++){
            dia = listaDeFechas[i];
            this.fecha[i] = new Fecha(dia);
        }

    }

    
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

    ArrayList resultadoJugadores(GregorianCalendar dia, String nombClubLocal ){

        ArrayList resultado = new ArrayList();
        ArrayList resultado1 = new ArrayList();
        int i =0;
            resultado.add(this.numJornada);
            //recorrer cada fecha []
            resultado1 = (this.fecha)[i].resultadoJugadores(dia, nombClubLocal);
            resultado.add(resultado1);

            return resultado;

    }

    private Fecha buscarFecha(GregorianCalendar dia){

        Fecha f = null;

        for(int i=0; i<(this.fecha).length; i++){
             if ((this.fecha)[i].getDia().compareTo(dia) == 0)
                 f = (this.fecha)[i];
        }
        
        return f;

    }
    private ClasificacionClub buscarCClub(String nombClub){

       ClasificacionClub cc = null;
       return cc;

    }

    ArrayList verPartidoDeJornada(){

        ArrayList resultado = new ArrayList();
        ArrayList resultado1 = new ArrayList();
        Fecha fech;
        resultado.add(getNumero());
        for(int i=0; i<fecha.length; i++){
            fech = fecha[i];
            resultado1 = fech.partidosDeUnDia();
            resultado.add(resultado1);
        }
        return resultado;

    }
    
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

                while (it.hasNext()) {
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
        //List cjs = (this.cJugador).values();
        //Collections cjs =
        //Collections.sort(cjs);


    }
    void anotarResultadoJugador(Calendar dia,String nombClubLocal, String dniPas,
                                double minutosJugados, int intentos, int puntosConseguidos){}
    void incluirClasificacion(Jugador jug, double minutosTotales, int intentosTotales, int puntosTotales){}
    
    void definirPartido(GregorianCalendar dia, Club cl, Club cv, GregorianCalendar hora,String TVEmite) throws LracbEx{

        boolean participa = false;
        Fecha f1,f2;
        
        for(int i=0; i<(this.fecha).length && !participa; i++){
            f1 = new Fecha(this.fecha[i].getDia());
            System.out.print("antes llamar participaPartido\n");
            participa = f1.participaPartido(cl,cv);
            System.out.print("despues llamar participaPartido\n");
            if (participa) throw new LracbEx("alguno de los club ya participa en otro partido de esa jornada");
        }
        System.out.print("1_jornada.definirPartido\n");
        f2 = buscarFecha(dia);
        f2.definirPartido(cl, cv, hora, TVEmite);
        System.out.print("2__jornada.definirPartido\n");
    }

}
