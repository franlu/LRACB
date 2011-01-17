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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class Club {

    private String nombre;
    private String entrenador;
    private String pabellon;

    private Map<String,Jugador> jugadores = new HashMap<String,Jugador>();

    //void crear(String nombre, String entrenador, String pabellon )
    Club(String nombre, String entrenador, String pabellon){

        this.nombre = nombre;
        this.entrenador = entrenador;
        this.pabellon = pabellon;
    }

    //String obtenerNombre(){}
    String getNombre(){

        return this.nombre;

    }

    String getEntrenador(){

        return this.entrenador;

    }

    //String obtenerPabellon(){}
    String getPabellon(){

        return this.pabellon;

    }

    void setNombre(String nombre){

        this.nombre = nombre;

    }

    void setEntrenador(String entrenador){

        this.entrenador = entrenador;

    }

    void setPabellon(String pabellon){

        this.pabellon = pabellon;

    }

    
    void ficharJugador(Jugador ju){

        (this.jugadores).put(ju.getNombre(),ju);

    }
    
    
    ArrayList jugadoresDeClub(){

        ArrayList jug = new ArrayList();
        Iterator it = (this.jugadores).entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            jug.add(e);
        }
        
        return jug;

    }
}
