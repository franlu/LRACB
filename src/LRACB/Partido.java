/*
* Partido
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
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class Partido {

    private Calendar hora;
    private String TVemite;

    private ResultadoLocal resultadoLocal;
    private ResultadoVisitante resultadoVisitante;
    private Map<Integer,ResultadoJugador> resultadoJugador = new HashMap<Integer,ResultadoJugador>();


    Partido(Club cl, Club cv, Calendar hora, String TVEmite){



    }

    void anotarResultado(int puntosLocal, int puntosVisi){

        (this.resultadoLocal).modificarResultado(puntosLocal);
        (this.resultadoVisitante).modificarResultado(puntosVisi);
      
    }
    
    String obtenerNombClubVisi(){

        return (this.resultadoVisitante).obtenerNombClubVisi();

    }

    ArrayList resultadoJugadores(){
        
        ArrayList resultado1 = new ArrayList();
        ArrayList resultado5 = new ArrayList();
        String resultado2, resultado3,resultado4;

            
            resultado2 = (this.resultadoLocal).obtenerNombClubLocal();
            resultado3 = (this.resultadoVisitante).obtenerNombClubVisi();
            resultado1.add(resultado2);
            resultado1.add(resultado3);
            String[] nombres = new String[2];
            nombres[0] = resultado2;
            nombres[1] = resultado3;
            
            if ((this.resultadoJugador).size() != 0 ){
                String nc;
                for(int i=0; i<2; i++){
                    nc = nombres[i];
                    //resultado 4 = nc; linea anterior
                    Iterator it = (this.resultadoJugador).entrySet().iterator();
                    ResultadoJugador rj;

                    resultado5.add(nc);
                    while (it.hasNext()) {// Ojo con los casting
                       Map.Entry e = (Map.Entry)it.next();
                       rj = (ResultadoJugador) e.getValue();
                       resultado5 = rj.obtenerResultadoJugador(nc);
                       resultado1.add(resultado5);
                    }
                }
            
            }
            else{

                resultado1.add("No estan los resultados de los jugadores");

            }
            
        return resultado1;

    }
    ArrayList datosDelPartido(){}

    void anotarResultadoJugador(String dniPas, double minutosJugados, int intentos,
            int puntosConseguidos){
    
    
    
    
    }
    
    boolean participaClub(Club cl, Club cv){}
    
    
}
