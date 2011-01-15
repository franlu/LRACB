
package LRACB;

import java.util.HashMap;
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

    Club(String nombre, String entrenador, String pabellon){

        this.nombre = nombre;
        this.entrenador = entrenador;
        this.pabellon = pabellon;
    }

    String getNombre(){

        return this.nombre;

    }

    String getEntrenador(){

        return this.entrenador;

    }

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

    void crear(String nombre, String entrenador, String pabellon ){}
    void ficharJugador(Jugador ju){}
    String obtenerNombre(){}
    String obtenerPabellon(){}
    ArrayList jugadoresDeClub(){}
}
