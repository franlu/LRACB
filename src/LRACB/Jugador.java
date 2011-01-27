/*
* Jugador
*
* Informacion de la version
*
* Fecha
*
* Copyright
*/
package LRACB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Francisco Javier Lucena Lucena
 */
class Jugador {

    private String nombre;
    private String dniPass;
    private GregorianCalendar fechaNac;
    private double altura;
    private String posicion;
    private double peso;
    private String nacionalidad;
    private int numero;
    
    private Club club;

    //TreeMap para agilizar la busqueda de una jornadas
    private Map<Integer,ClasificacionJugador> clasificacionJugador = new TreeMap<Integer,ClasificacionJugador>();


    Jugador(String dniPas, String nombre, GregorianCalendar fechaNac, double altura,
            double peso, String posicion, String nacionalidad , int numero,
            Club cl){

            setNombre(nombre);
            setDniPass(dniPas);
            setFechaNac(fechaNac);
            setAltura(altura);
            setPeso(peso);
            setPosicion(posicion);
            setNacionalidad(nacionalidad);
            setNumero(numero);
            setClub(cl);
    }
    
    //No aparece en DCD pero si en DCol
    ArrayList evolucionJugador(){
    
        ArrayList resultado = new ArrayList();
        
        resultado.add(this.nombre);
        String nombClub = (this.club).getNombre();
        resultado.add(nombClub);
        resultado.add(this.posicion);
        
        if ((this.clasificacionJugador).size() == 0) {

            resultado.add("El jugador no ha participado en ninguna jornada");

        }
        else {
            
             //La Clase TreeMap ordena por numero de Jornada
             ArrayList datosJornada = new ArrayList();
             ClasificacionJugador clj;
             Iterator it = (this.clasificacionJugador).entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry)it.next();
                    clj = (ClasificacionJugador) e.getValue();
                    datosJornada = clj.obtenerDatosJornada();
                    resultado.add(datosJornada);
                }


        }

        return resultado;    
    
    }
    int obtenerNumero(){

        return this.numero;

    }
    
   
    String obtenerPosicion(){

        return (this.posicion);

    }

    String obtenerNombre(){

        return this.nombre;

    }

    
    ArrayList obtenerDatosJugador(){
    
        ArrayList resultado = new ArrayList();
        GregorianCalendar fecha = new GregorianCalendar();
        Date hoy = new Date();//fecha actual
        fecha.setTime(hoy);

            resultado.add(getNombre());
            //Return int edad
            resultado.add(fecha.get(Calendar.YEAR) - getFechaNac().YEAR);
            resultado.add(getAltura());
            resultado.add(getPeso());
            resultado.add(getPosicion());
            resultado.add(getNacionalidad());
            resultado.add(getNumero());
            
       return resultado;    
    
    }

    String obtenerNombClub(){
    
        return (getClub()).getNombre();
    
    }

    //Desaparece este metodo gracias a la clase TreeMap
    //private void ordenarPorJornada(){
    //}
    
    ArrayList obtenerClasificacion(){

        ArrayList resultadosUltimaClasificacion = new ArrayList();
        ClasificacionJugador ultimaClasificacion;

            if ((this.clasificacionJugador).size() != 0) {

                ultimaClasificacion = obtenerUltima();
                resultadosUltimaClasificacion = ultimaClasificacion.obtenerDatosClasificacion();
            }
            else {

                //resultadosUltimaClasificacion = devolver [0,0,0,0]

            }

        return resultadosUltimaClasificacion;

    }
    
    ArrayList obtenerResultados(){

        ArrayList resultado = new ArrayList();

        return resultado;

    }
    
    ClasificacionJugador obtenerUltima(){

        ClasificacionJugador clj = null;
        Iterator it = (this.clasificacionJugador).entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                clj = (ClasificacionJugador) e.getValue();

            }
        return clj;

    }
    
    void incluir(ClasificacionJugador cj){



    }

    void setNombre(String nombre){

        this.nombre = nombre;

    }

    void setDniPass(String dni){

        this.dniPass = dni;

    }

    void setFechaNac(GregorianCalendar fecha){

        this.fechaNac = fecha;

    }

    void setAltura(double altura){

        this.altura = altura;

    }

    void setPosicion(String posicion){

        this.posicion = posicion;

    }

    void setPeso(double peso){

        this.peso = peso;

    }

    void setNacionalidad(String nac){

        this.nacionalidad = nac;

    }

    void setNumero(int num){

        this.numero = num;

    }

    void setClub(Club c){

        this.club = c;

    }

    String getNombre(){

        return this.nombre;

    }

    String getDniPass(){

        return this.dniPass;

    }

    GregorianCalendar getFechaNac(){

        return this.fechaNac;

    }

    double getAltura(){

        return this.altura;

    }

    String getPosicion(){

        return this.posicion;

    }

    double getPeso(){

        return this.peso;

    }

    String getNacionalidad(){

        return this.nacionalidad;

    }

    int getNumero(){

        return this.numero;

    }

    Club getClub(){

        return this.club;

    }
}