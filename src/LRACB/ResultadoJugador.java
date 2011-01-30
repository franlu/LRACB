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
    
    ArrayList obtenerResultadoJugador(String nombClub){

        ArrayList resultado5 = new ArrayList();



        if (nombClub.equals((this.jugador).obtenerNombre())){

            resultado5.add(this.jugador.obtenerNumero());
            resultado5.add(this.jugador.getNombre());
            resultado5.add(this.jugador.obtenerPosicion());
            resultado5.add(this.minutosJugados);
            resultado5.add(this.intentos);
            resultado5.add(this.puntos);

            double rendimiento;

            rendimiento = (this.puntos - this.intentos) / this.minutosJugados;
            resultado5.add(rendimiento);


        }
        

        return resultado5;
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
