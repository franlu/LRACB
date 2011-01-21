package LRACB;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class ResultadoVisitante {

    private int puntos;

    private Club club;
    //crear
    ResultadoVisitante(Club cv){}
    
    void modificarResultado(int puntosVisi){

        this.puntos = puntosVisi;

    }
    ArrayList obtenerResultadoNomClub(){}
    String obtenerNombClubVisi(){}
    //No esta en DCDiseño obtenerPabellon
    String obtenerPabellon(){}
    Jugador obtenerJugador(String dniPas){}
    boolean perteneceJugador(String dniPas){}
    boolean participaClub(Club cl, Club cv){}

}
