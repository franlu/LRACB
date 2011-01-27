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
    //key nombre del club
    private Map<String,ClasificacionClub> cClub = new HashMap<String,ClasificacionClub>();
    //key nombreJugador no double rendimiento
    private Map<String,ClasificacionJugador> cJugador = new HashMap<String,ClasificacionJugador>();

    
    Jornada(int numJornada, Fecha[] listaDeFechas){

        setNumero(numJornada);
        setFecha(listaDeFechas);

    }

    boolean esAnterior(GregorianCalendar[] listaDeFechas){

        GregorianCalendar f;
        boolean anterior = false;
        //mejora_proteccion: condicion bucle i<2
        for(int i=0; i<listaDeFechas.length && !anterior; i++){
            f = listaDeFechas[i];
            //necesito objetos de tipo Fecha para llamar a esAnterior de la clase Fecha
            //anterior = f.esAnterior(f));
            //anterior = f.esAnterior(f));
        }
        return anterior;

    }

    //int obtenerNumero(){
    int getNumero(){

        return this.numJornada;
    }

    Fecha[] getFecha(){

        return this.fecha;
     }

    void setNumero(int num){

        this.numJornada = num;
    }

    void setFecha(Fecha[] listaDeFechas){

        Fecha f;
        //mejora_proteccion: condicion bucle i<2
        for(int i=0; i<listaDeFechas.length; i++){
            f = listaDeFechas[i];
            this.fecha[i]= f;
        }

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
            //pendiente del tipo de dato para dia
            //resultado1 = (this.fecha).resultadoJugadores(dia, nombClubLocal);
            resultado.add(resultado1);

            return resultado;

    }

    private Fecha buscarFecha(Calendar dia){

        Fecha f = null;

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
        return resultado1;

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
    
    void definirPartido(Calendar dia, Club cl, Club cv, Calendar hora,String TVEmite) throws LracbEx{

        boolean participa = false;
        Fecha f1,f2;

        for(int i=0; i<fecha.length && !participa; i++){
            f1 = fecha[i];
            participa = f1.participaPartido(cl,cv);
            if (participa) throw new LracbEx("alguno de los club ya participa en otro partido de esa jornada");
        }

        f2 = buscarFecha(dia);
        //tipo de dato hora
        //f2.definirPartido(cl, cv, hora, TVEmite);

    }

}
