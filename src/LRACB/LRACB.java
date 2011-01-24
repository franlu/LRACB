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
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
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


    private Jornada obtenerUltimaJornada(){

        Iterator it = (this.Jornadas).entrySet().iterator();
        Jornada j = null;
        while (it.hasNext()) {
           Map.Entry e = (Map.Entry)it.next();
           j = (Jornada) e.getValue();
        }
        return j;
    }

    public void definirJornada(Fecha[] listaDeFechas) throws LracbEx{

        Jornada jorAnterior = obtenerUltimaJornada();
        Boolean anterior = jorAnterior.esAnterior(listaDeFechas);
        Integer numJornada;
        Jornada j;

        //Si no hay jornadas definidas
        if (jorAnterior != null){

            if (anterior) throw new LracbEx("Fechas anteriores a las de la jornada anterior");

            numJornada = (Integer) jorAnterior.getNumero();
            if (numJornada == 34) throw new LracbEx("Ya estan definidas las 34 Jornadas.");

            j = new Jornada(numJornada,listaDeFechas);

        }
        else{
            //crear la primera Jornada
            numJornada = 1;
            j = new Jornada(numJornada,listaDeFechas);
        }

        (this.Jornadas).put(numJornada, j);

    }

    public void incluirJugador(String nombClub,String dniPas, String nomJugador,
                       Calendar fechaNac, double altura, double peso, String posicion,
                       String nacionalidad, int numero) throws LracbEx {

        if ((this.Jugadores).containsKey(dniPas))
            throw new LracbEx("Ya existe el Jugador con el DNI introducido");
        Club club = (this.Clubes).get(nombClub);
        Jugador ju = new Jugador(dniPas,nomJugador,fechaNac,altura,peso,posicion,
                nacionalidad,numero,club);
        club.ficharJugador(ju);
        (this.Jugadores).put(dniPas, ju);
    }

    public void anotarResultado(int numJornada, Calendar dia, String nombClubLocal, int puntosLocal, int puntosVisi){

        /* String nombClubVisitante;
       Jornada jor1 = buscarJornada(numJornada);
           jor1.anotarResultado(dia,nombClubLocal,puntosLocal,puntosVisi);
           nombClubVisitante = jor1.obtenerNombClubVisitante(dia,nombClubLocal);
           if (numJornada != 1){
               Jornada jorAnterior = buscarJornada(numJornada-1);
           }
           String[] auxNombClub = new String[2];
           auxNombClub[0] = nombClubLocal;
           auxNombClub[1] = nombClubVisitante;
  
         for(int i=0; i<1;i++){
                int[] resultadoAnterior;
                if (numJornada != 1){
                    resultadoAnterior = jorAnterior.obternerResultado(auxNombClub[i]);
                }
                else
                    resultadoAnterior = [0,0,0,0];
           }
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
           */

           //jor1.definirClasificacionClub(club,ganados,perdidos,puntosAFavor,puntosEnContra);

    }

    public ArrayList resultadoJugadores(int numJornada, Calendar dia, String nombClubLocal){
        
        ArrayList resultado1;
        Jornada jor;

            jor = (this.Jornadas).get(numJornada);
            resultado1 = jor.resultadoJugadores(dia, nombClubLocal);
        
        return resultado1;

    }
    private Jornada buscarJornada(int numJornada){
        
        return (this.Jornadas).get(numJornada);
    }

    // Errata en diagrama diseño
    private Club buscarClub(String nombClub){ 

        return (this.Clubes).get(nombClub);

    }

    //true si existe
    //false si no existe
    private boolean existeJugador(String dniPas){

        return (this.Jugadores).containsKey(dniPas);
    }

    private Jugador buscarJugador(String dniPas){

        return (this.Jugadores).get(dniPas);
    }

    public ArrayList verPartidoDeJornada(int numJornada){

        ArrayList resultado = new ArrayList();
        Jornada jor = buscarJornada(numJornada);

            //resultado = jor.

        return resultado;

    }

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
    
    public void anotarResultadoJugador(int numJornada, Date dia,String nombClubLocal,
            String dniPas,double minutosJugados, int intentos,int puntosConseguidos){}
    public void definirPartido(int numJornada, Date dia,String nombClubLocal,
            String nombClubVisi, Date hora, String TVEmite){
    
   
        
   }


    public void incluirClub(String nombre, String entrenador, String pabellon) throws LracbEx {

        boolean existeC = this.existeClub(nombre);

        if (existeC) throw new LracbEx("Ya existe un club con ese nombre");

        Club cl = new Club(nombre,entrenador,pabellon);

        (this.Clubes).put(nombre, cl);
    

    }

    private boolean existeClub(String nombre){

        return (this.Clubes).containsKey(nombre);

    }
}
