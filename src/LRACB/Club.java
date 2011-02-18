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

    void ficharJugador(Jugador ju){

        (this.jugadores).put(ju.getNombre(),ju);

    }

    /**
     * Recoge informacion sobre los jugadores del club
     * @return informacion sobre los jugadores del club
     */
    ArrayList jugadoresDeClub(){

        ArrayList   resultado = new ArrayList();

            resultado.add(this.nombre);

            if ((this.jugadores).size() == 0) {
                resultado.add("El club no ha fichado jugadores.");
            }
            else {
                Iterator    it = (this.jugadores).entrySet().iterator();
                ArrayList   datosJugador = new ArrayList();
                Map.Entry   e;
                Jugador     ju;

                while (it.hasNext()) {
                    e = (Map.Entry)it.next();
                    ju = (Jugador) e.getValue();
                    datosJugador = ju.obtenerDatosJugador();
                    resultado.add(datosJugador);
                }
            }
            
            return resultado;
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

    
    
}
