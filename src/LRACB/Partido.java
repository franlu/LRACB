/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LRACB;

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
    String obtenerNombClubVisi(){}
    ArrayList resultadoJugadores(){}
    ArrayList datosDelPartido(){}
    void anotarResultadoJugador(String dniPas, double minutosJugados, int intentos,
            int puntosConseguidos){}
    boolean participaClub(Club cl, Club cv){}
    public void crear(Club cl, Club cv, Calendar hora, String TVEmite){}
    
}
