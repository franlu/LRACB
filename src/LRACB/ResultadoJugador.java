package LRACB;

import java.util.ArrayList;

/**
 *
 * @author Francisco Javier Lucena Lucena
 */
class ResultadoJugador {

    private double minutosJugados;
    private int puntos;
    private int intentos;

    private Jugador jugador;

    ResultadoJugador(Jugador jug, double minutosJugados, int intentos, int puntosConseguidos){
    
        this.jugador = jug;
        this.minutosJugados = minutosJugados;
        this.intentos = intentos;
        this.puntos = puntosConseguidos;
    
    
    }
    // En DCDiseño se le pasas un nc (creo que nombre club)
    ArrayList obtenerResultadoJugador(){

        ArrayList resultado = new ArrayList();

        resultado.add(this.minutosJugados);
        resultado.add(this.intentos);
        resultado.add(this.puntos);

        return resultado;
    }

    double getMinutosJugados(){

        return this.minutosJugados;

    }

    int getIntentos(){

        return this.intentos;

    }

    int getPuntos(){

        return this.puntos;

    }

    void setMinutosJugados(double minutos){

        this.minutosJugados = minutos;

    }

    void setIntentos(int intentos){

        this.intentos = intentos;

    }

    void setPuntos(int puntos){

        this.puntos = puntos;

    }
}
