/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fran
 */
public class Club {

    private String nombre;
    private String entrenador;
    private String pabellon;

    private Map<String,Jugador> jugadores = new HashMap<String,Jugador>();
}
