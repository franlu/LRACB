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
    //planterse el TreeSet para ordenar
    //con un ArrayList puede ir fino, casi que no usar map
    private Map<GregorianCalendar,Partido> Partidos = new HashMap<GregorianCalendar,Partido>();

    
    Fecha(GregorianCalendar dia){

        setDia(dia);

    }

    /**
     *Determina si una fecha es anterior a la del propio objeto la invoca
     * @param ant fecha para comparar
     * @return true si el objeto fecha es anterior a ant
     *         false en caso contrario
     */
    boolean esAnterior(GregorianCalendar ant){
        
        int opcion = this.dia.compareTo(ant);
        if (opcion < 0)
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
    ArrayList resultadoJugadores(GregorianCalendar dia, String nombClubLocal){

        Partido par = buscarPartido(nombClubLocal);
        ArrayList resultado1 = par.resultadoJugadores();

        return resultado1;

    }
    private Partido buscarPartido(String nombClubLocal){
    //pendiente de hacer
        Partido par = null;
        return par;

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
    boolean participaPartido(Club cl, Club cv){

       Boolean participa = false;//Si no hay partidos return false
       Partido par;

            Iterator it = (this.Partidos).entrySet().iterator();
            while (it.hasNext() && !participa) {
                Map.Entry e = (Map.Entry)it.next();
                par = (Partido) e.getValue();
                participa = par.participaClub(cl, cv);
            }
            System.out.print("participa en fecha.participaPartido:  " + participa+ "___");
       return participa;

    }
    
    
    void definirPartido(Club cl, Club cv, GregorianCalendar hora, String TVEmite){
        
        Partido par = new Partido(cl,cv,hora,TVEmite);
        
            (this.Partidos).put(hora, par);
            
    }

    void setDia(GregorianCalendar dia){

       this.dia = dia;

    }

    GregorianCalendar getDia(){

       return this.dia;

    }
}
