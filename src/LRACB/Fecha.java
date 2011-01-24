/*
* Fecha
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class Fecha {

    //TreeSet ordena por gregorian calendar
    private GregorianCalendar dia = new GregorianCalendar();
    //hora,partido
    private Map<Calendar,Partido> Partidos = new HashMap<Calendar,Partido>();

    
    Fecha(GregorianCalendar dia){

        setDia(dia);

    }

    boolean esAnterior(GregorianCalendar ant){

         if ((ant.get(Calendar.YEAR) <= dia.get(Calendar.YEAR)) &&
              (ant.get(Calendar.MONTH) <= dia.get(Calendar.DAY_OF_MONTH)) &&
              (ant.get(Calendar.DAY_OF_MONTH) < dia.get(Calendar.DAY_OF_MONTH)))

            return true;
         else
            return false;

    }
    String obtenerNombClubVisi(String nombClubLocal){

        Partido par = buscarPartido(nombClubLocal);
        return par.obtenerNombClubVisi();

    }

    void anotarResultado(String nombClubLocal, int puntosLocal, int puntosVisi){

        Partido par = buscarPartido(nombClubLocal);
        par.anotarResultado(puntosLocal, puntosVisi);
        
    }

    // en diagrama de colaboracion no aparece el parametro dia
    ArrayList resultadoJugadores(Calendar dia, String nombClubLocal){

        Partido par = buscarPartido(nombClubLocal);
        ArrayList resultado1 = par.resultadoJugadores();

        return resultado1;

    }
    private Partido buscarPartido(String nombClubLocal){



    }
    ArrayList partidosDeUnDia(){

        ArrayList resultado1 = new ArrayList();
        ArrayList resultado2 = new ArrayList();

        resultado1.add(getDia());
        if((this.Partidos).size() == 0){

            resultado1.add("No esta definidos los partidos de este dia");

        }
        else{

            Partido par;

            Iterator it = (this.Partidos).entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                par = (Partido) e.getValue();
                resultado2 = par.datosDelPartido();
                resultado1.add(resultado2);
            }

        }

        return resultado1;

    }
    void anotarResultadoJugador(String nombClubLocal, String dniPas, double minutosJugados,
            int intentos, int puntosConseguidos){}
    // Errata en DCDiseño
    boolean participaPartido(Club cl, Club cv){}
    void definirPartido(Club cl, Club cl, Date hora, String TVEmite){}

    void setDia(GregorianCalendar dia){

       this.dia = dia;

    }

    GregorianCalendar getDia(){

       return this.dia;

    }
}
