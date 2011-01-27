/*
* ClasificacionJugador
*
* verison 0.1
*
* 27 Enero 2011
*
* Fco Javier Lucena Lucena
*/

package LRACB;

import java.util.ArrayList;


class ClasificacionJugador implements Comparable {

    private int puntosTotales;
    private int intentosTotales;
    private double minutosTotales;
    private double rendimiento;

    private Jugador jugador;
    private Jornada jornada;


    ClasificacionJugador(Jugador jug, Jornada jor, double minutosTotales,
            int intentosTotales, int puntosTotales){

        setJugador(jug);
        setJornada(jor);
        setMinutosTotales(minutosTotales);
        setIntentosTotales(intentosTotales);
        setPuntosTotales(puntosTotales);
        setRendimiento(intentosTotales / puntosTotales);
    

    }

    ArrayList obtenerDatosClasificacion(){

        ArrayList datosClasificacion = new ArrayList();
        String nombrej, nomClub, posicion;

            nombrej = getJugador().obtenerNombre();
            datosClasificacion.add(nombrej);
            nomClub = getJugador().obtenerNombClub();
            datosClasificacion.add(nomClub);
            posicion = getJugador().obtenerPosicion();
            datosClasificacion.add(posicion);
            datosClasificacion.add(getPuntosTotales());
            datosClasificacion.add(getIntentosTotales());
            datosClasificacion.add(getMinutosTotales());
            datosClasificacion.add(getRendimiento());

        return datosClasificacion;

    }

    ArrayList obtenerDatosJornada(){

        ArrayList datosJornada = new ArrayList();
        int numJornada = getJornada().getNumero();
        datosJornada.add(numJornada);
        datosJornada.add(getPuntosTotales());
        datosJornada.add(getIntentosTotales());
        datosJornada.add(getMinutosTotales());
        datosJornada.add(getRendimiento());

        return datosJornada;

    }


    public int compareTo(Object o){

        ClasificacionJugador cj = (ClasificacionJugador) o;

        if (getRendimiento() == cj.getRendimiento())
            return 0;

        if (getRendimiento() > cj.getRendimiento())
            return -1;

        return 1;

    }

    int getPuntosTotales(){

        return this.puntosTotales;

    }

    int getIntentosTotales(){

        return this.intentosTotales;

    }

    double getMinutosTotales(){

        return this.minutosTotales;

    }

    double getRendimiento(){

        return this.rendimiento;

    }

    Jugador getJugador(){

        return this.jugador;

    }

    Jornada getJornada(){

        return this.jornada;

    }

    void setPuntosTotales(int puntos){

        this.puntosTotales = puntos;

    }

    void setIntentosTotales(int intentos){

        this.intentosTotales = intentos;

    }

    void setMinutosTotales(double min){

        this.minutosTotales = min;

    }

    void setRendimiento(double rend){

        this.rendimiento = rend;

    }

    void setJugador(Jugador jug){

        this.jugador = jug;

    }

    void setJornada(Jornada jor){

        this.jornada = jor;

    }

}
