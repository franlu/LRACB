/*
* @(#)LRACB.java 0.1 01/02/2011
*
* Copyright
*/


package LRACB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
* Implementa el patron singleton.
*
* @version 0.1 01/02/2011
* @author Fco Javier Lucena Lucena
*/

public class LRACB {

    private static LRACB miLRACB = null;
    private Map<Integer,Jornada> Jornadas = new TreeMap<Integer,Jornada>();
    private Map<String,Club> Clubes = new HashMap<String,Club>();
    private Map<String,Jugador> Jugadores = new HashMap<String,Jugador>();


    private LRACB(){}

    public  static LRACB  getLRACB(){
        if(miLRACB==null)
            miLRACB = new LRACB();
        return miLRACB;
    }

    /**
     * Recuperar la ultima jornada definida en la liga regular
     * @return ultima jornada definida
     *         null, si hay jornadas definidas
     */
     private Jornada obtenerUltimaJornada(){

        Iterator it = (this.Jornadas).entrySet().iterator();
        Jornada j = null;
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                j = (Jornada) e.getValue();
            }

        return j;
            
    }
    
    public void definirJornada(GregorianCalendar[] listaDeFechas) throws LracbEx{
        
        Jornada     jorAnterior = obtenerUltimaJornada();
        Integer     numJornada;
        Jornada     j;

        //Si no hay jornadas definidas
        if (jorAnterior == null){
            Jornada j1 = new Jornada(1,listaDeFechas);
            (this.Jornadas).put(1, j1);
            System.out.print("JorAnterior es igual a null\n");
             
        }
        else{

            System.out.print("JorAnterior es distinto de null\n");
            List fec = jorAnterior.getFechas();
            Fecha f1;
            Iterator itList= fec.iterator();
            while(itList.hasNext()){
                f1 = (Fecha) itList.next();
                
            }

            boolean anterior = jorAnterior.esAnterior(listaDeFechas);
            
            if (!anterior) throw new LracbEx("Las Fechas son anteriores a las de la ultima jornada.");

            numJornada = (Integer) jorAnterior.getNumero();

            if (numJornada == 34) throw new LracbEx("Ya estan definidas las 34 Jornadas.");

            numJornada++;
            j = new Jornada(numJornada,listaDeFechas);
            (this.Jornadas).put(numJornada, j);
        }
    }

    /**
     * Incluye un nuevo jugador en un club determinado
     * @param nombClub nombre del club al que pertenecera el jugador
     * @param dniPas documento de identificacion
     * @param nomJugador nombre y apellidos
     * @param fechaNac fecha de nacimiento
     * @param altura altura del jugador
     * @param peso kilogramos de peso
     * @param posicion Situacion del jugador dentro de la pista de juego
     * @param nacionalidad Lugar de procedencia
     * @param numero aparecera en la camiseta del jugador
     * @throws LracbEx
     */
    public void incluirJugador(String nombClub,String dniPas, String nomJugador,
                       GregorianCalendar fechaNac, double altura, double peso, String posicion,
                       String nacionalidad, int numero) throws LracbEx {

        if ((this.Jugadores).containsKey(dniPas))
            throw new LracbEx("Ya existe el Jugador con el DNI introducido");
        Club club = (this.Clubes).get(nombClub);
        Jugador ju = new Jugador(dniPas,nomJugador,fechaNac,altura,peso,posicion,
                nacionalidad,numero,club);
        club.ficharJugador(ju);
        (this.Jugadores).put(dniPas, ju);
    }

    public void anotarResultado(int numJornada, GregorianCalendar dia, String nombClubLocal, int puntosLocal, int puntosVisi){

       String nombClubVisitante;
       Jornada jor1 = buscarJornada(numJornada);
       int[] resultadoJorAnterior = new int[4];
       Jornada jorAnterior;
           
           jor1.anotarResultado(dia,nombClubLocal,puntosLocal,puntosVisi);
           nombClubVisitante = jor1.obtenerNombClubVisitante(dia,nombClubLocal);
           if (numJornada != 1){
               jorAnterior = buscarJornada(numJornada-1);
           }
           String[] auxNombClub = new String[2];
           auxNombClub[0] = nombClubLocal;
           auxNombClub[1] = nombClubVisitante;
  
           for(int i=0; i<1;i++){
             
                if (numJornada != 1){
                    resultadoJorAnterior = jorAnterior.obternerResultado((String)auxNombClub[i]);
                }
                else{ // Primera Jornada
                    int[] resultadoAux = new int[4];
                    for(int j=0; j<3;j++)
                        resultadoAux[j] = 0;
                    
                    resultadoJorAnterior = resultadoAux;
                }
           
                Club club = buscarClub(auxNombClub[i]);
           
               int ganados = resultadoJorAnterior[0];
               int perdidos = resultadoJorAnterior[1];
               int puntosAFavor = resultadoJorAnterior[2];
               int puntosEnContra = resultadoJorAnterior[3];
 
               if (i==0){ // Club Local
                    if (puntosLocal > puntosVisi){ //gana Local
                        ganados++;
                        puntosAFavor += puntosLocal;
                        puntosEnContra += puntosVisi;
                    }
                    else{ //gana Visitante
                        perdidos++;
                        puntosAFavor += puntosLocal;
                        puntosEnContra += puntosVisi;
                    }
               }
               else{//Club Visitante

                   if (puntosLocal > puntosVisi){ //gana Local
                        perdidos++;
                        puntosAFavor += puntosVisi;
                        puntosEnContra += puntosLocal;
                    }
                    else{ //gana Visitante
                        ganados++;
                        puntosAFavor += puntosVisi;
                        puntosEnContra += puntosLocal;
                    }


                }


                jor1.definirClasificacionClub(club,ganados,perdidos,puntosAFavor,puntosEnContra);
           }//for
    }
    //Gregorian Calendar dia
    public ArrayList resultadoJugadores(int numJornada, GregorianCalendar dia, String nombClubLocal){
        
        ArrayList resultado1;
        Jornada jor;

            jor = (this.Jornadas).get(numJornada);
            resultado1 = jor.resultadoJugadores(dia, nombClubLocal);
        
        return resultado1;

    }
    private Jornada buscarJornada(int numJornada){
        
        return (this.Jornadas).get(numJornada);
    }

    /**
     * Busca un club perteneciente a la liga regular
     * @param nombClub nombre del club
     * @return el club
     */
    private Club buscarClub(String nombClub){ 

        return (this.Clubes).get(nombClub);

    }

    
    private boolean existeJugador(String dniPas){

        return (this.Jugadores).containsKey(dniPas);
    }

    private Jugador buscarJugador(String dniPas){

        return (this.Jugadores).get(dniPas);
    }

    public ArrayList verPartidoDeJornada(int numJornada){

        ArrayList resultado = new ArrayList();
        Jornada jor = buscarJornada(numJornada);

            resultado = jor.verPartidoDeJornada();

        return resultado;

    }

    /**
     * Recoger la informacion referente a los jugadores de un club
     * @param nombClub nombre del club
     * @return informacion sobre los jugadores que pertenecen al club
     *         en caso de que el club no tenga jugadores se mostrara un
     *         mensaje informando de esta situacion
     */
    public ArrayList verJugadoresDeClub(String nombClub){
    
        ArrayList resultado = new ArrayList();
        Club club = buscarClub(nombClub);
        
            resultado = club.jugadoresDeClub();
        
        return resultado;    
    
    }

    public ArrayList clasificacionGeneral(int numJornada){

        ArrayList resultado = new ArrayList();
        Jornada jor = buscarJornada(numJornada);

            resultado = jor.clasificacionGeneral();

        return resultado;

    }
    
    public ArrayList rankingAnotadores(int numJornada){

        ArrayList resultado = new ArrayList();
        Jornada jor = buscarJornada(numJornada);

            resultado = jor.rankingAnotadores();

        return resultado;

    }


    public ArrayList evolucionJugador(String dniPas){

        Jugador ju = buscarJugador(dniPas);

        //El metodo evolucionJugador no aparecen en la clase Jugador del DCD
        ArrayList resultado = ju.evolucionJugador();

        return resultado;

    }
    
    public void anotarResultadoJugador(int numJornada, GregorianCalendar dia,String nombClubLocal,
            String dniPas,double minutosJugados, int intentos,int puntosConseguidos){

            Jornada jor = buscarJornada(numJornada);
            Jugador jug = buscarJugador(dniPas);
            ArrayList resultadoUltimaClasificicacion = new ArrayList();

                jor.anotarResultadoJugador(dia, nombClubLocal, dniPas, minutosJugados, intentos, puntosConseguidos);
                resultadoUltimaClasificicacion = jug.obtenerClasificacion();
                jor.incluirClasificacion(jug, minutosJugados, intentos, puntosConseguidos);

    }
    
    public void definirPartido(int numJornada, GregorianCalendar dia, String nombClubLocal,
            String nombClubVisi, GregorianCalendar hora, String TVEmite) throws LracbEx{

            Club        cl = buscarClub(nombClubLocal);
            Club        cv = buscarClub(nombClubVisi);
            Jornada     jor = buscarJornada(numJornada);
            
            jor.definirPartido(dia, cl, cv, hora, TVEmite);
         
   }

   /**
    * Incluir un nuevo club en la lista de clubes de la liga ACB
    * @param nombre El nombre del nuevo club
    * @param entrenador El nombre del entrenador del club
    * @param pabellon El nombre del lugar donde se celebraran los partidos
    * @throws LracbEx
    */
   public void incluirClub(String nombre, String entrenador, String pabellon) throws LracbEx {

        boolean existeC = this.existeClub(nombre);

        if (existeC) throw new LracbEx("Ya existe un club con ese nombre");

        Club cl = new Club(nombre,entrenador,pabellon);

        (this.Clubes).put(nombre, cl);
    

    }

   /**
    * Verificar la existen de un Club
    * @param nombre representa el nombre del club
    * @return true si el club esta incluido en la lista de clubes
    * @return false en caso de no estar incluido
    */
    private boolean existeClub(String nombre){

        return (this.Clubes).containsKey(nombre);

    }
}
