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
import java.util.Map;

/**
 *
 * @author fran
 */
class Partido {

    private Calendar hora;
    private String TVemite;

    private ResultadoLocal resultadoLocal;
    private ResultadoVisitante resultadoVisitante;
    private Map<int,ResultadoJugador> resultadoJugador = new HashMap<int,ResultadoJugador>();

    void anotarResultado(int puntosLocal, int puntosVisi){}
    
    String obtenerNombClubVisi(){

        return (this.resultadoVisitante).obtenerNombClubVisi();

    }

    ArrayList resultadoJugadores(){
        
        ArrayList resultado1 = new ArrayList();
        String resultado2, resultado3;
            
            resultado2 = (this.resultadoLocal).obtenerNombClubLocal();
            resultado3 = (this.resultadoVisitante).obtenerNombClubVisi();
            resultado1.add(resultado2);
            resultado1.add(resultado3);
            
            if ((this.resultadoJugador).size() != 0 ){
            
            
            }
            
        return resultado1;

    }
    ArrayList datosDelPartido(){}
    void anotarResultadoJugador(String dniPas, double minutosJugados, int intentos,
            int puntosConseguidos){}
    boolean participaClub(Club cl, Club cv){}
    public void crear(Club cl, Club cv, Calendar hora, String TVEmite){}
    
}
