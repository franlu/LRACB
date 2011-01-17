/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

/**
 *
 * @author Francisco Javier Lucena Lucena
 */
class Jugador {

    private String nombre;
    private String dniPass;
    private Calendar fechaNac;
    private double altura;
    private String posicion;
    private double peso;
    private String nacionalidad;
    private int numero;
    
    private Club club;

    private Map<double,ClasifiacionJugador> clasificacionJugador = new HashMap<>(double,ClasifiacionJugador);

    Jugador(String dniPas, String nombre, Calendar fechaNac, double altura, 
            double peso, String posicion, String nacionalidad , int numero,
            Club cl){}
    int obtenerNumero(){}
    
    //String obtenerNombre(){}
    String getNombre(){

        return this.nombre;

    }
    String obtenerPosicion(){}
    ArrayList obtenerDatosJugador(){}
    String obtenerNombClub(){}
    private void ordenarPorJornada(){}
    ArrayList obtenerClasificacion(){}
    ArrayList obtenerResultados(){}
    ClasificacionJugador obtenerUltima(){}
    void incluir(ClasificacionJugador cc){}
}