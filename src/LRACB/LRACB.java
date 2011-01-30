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
import java.util.GregorianCalendar;
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

    
    public void definirJornada(GregorianCalendar[] listaDeFechas) throws LracbEx{
        
        Jornada jorAnterior = obtenerUltimaJornada();
        Integer numJornada;
        Jornada j;

        
        //Si no hay jornadas definidas
        if (jorAnterior != null){
            
            // esAnterior petaaaaaaaaaaaaa
            // jorAnterior se crea con la listaDeFechas de la que se esta definiendo
            
            boolean anterior = jorAnterior.esAnterior(listaDeFechas);
            
            if (anterior) throw new LracbEx("Fechas anteriores a las de la jornada anterior");
            
            numJornada = (Integer) jorAnterior.getNumero();
            
            if (numJornada == 34) throw new LracbEx("Ya estan definidas las 34 Jornadas.");

            numJornada++;
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
                    //resultadoJorAnterior = jorAnterior.obternerResultado((String)auxNombClub[i]);
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
    //Gregorian Calendar dia, lo dice la profe
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

            resultado = jor.verPartidoDeJornada();

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


            Club cl = buscarClub(nombClubLocal);
            Club cv = buscarClub(nombClubVisi);
            System.out.print("cl encontrao\n");
            System.out.print("cv encontra"+ cv.getNombre()+"\n");
            Jornada jor = buscarJornada(numJornada);
            System.out.print("numJornada "+ jor.getNumero()+ "\n");
            jor.definirPartido(dia, cl, cv, hora, TVEmite);
         
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
