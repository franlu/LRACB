/*
* LRACB
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
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fco Javier Lucena Lucena
 */
class Jornada {

    private int numJornada;
    private List fecha = new ArrayList();
    //key nombre del club compareTo en clase clasficacion con partidos Ganados
    private Map<String,ClasificacionClub> cClub = new HashMap<String,ClasificacionClub>();
    //key nombreJugador no double rendimiento
    private Map<String,ClasificacionJugador> cJugador = new HashMap<String,ClasificacionJugador>();

    
    Jornada(int numJornada, GregorianCalendar[] listaDeFechas){

        setNumero(numJornada);
        setFechas(listaDeFechas);

    }

    /**
     * Comprueba si una lista de fechas es anterior a las fechas en las que se celebra
     * la jornada actual
     * @param listaDeFechas
     * @return true si listaDeFechas es anterior a las Fechas de la Jornada actual
     *         false en otro caso
     */
    boolean esAnterior(GregorianCalendar[] listaDeFechas){

        //recorrer las fechas que hay en fecha y compararlas con cada gregorian calendar
        boolean anterior = false;// las fechas no son anteriores a la actual
        GregorianCalendar dia;
        Fecha f ;
      
        for(int i=0; i<listaDeFechas.length && !anterior ; i++){
            dia = listaDeFechas[i];
            System.out.print("dia en lista fechas = "+ dia.get(Calendar.DAY_OF_MONTH) +"_\n");
            System.out.print("mes en lista fechas = "+ dia.get(Calendar.MONTH) +"_\n");
            System.out.print("año en lista fechas = "+ dia.get(Calendar.YEAR) +"__\n");

           Iterator itList= getFechas().iterator();
            while(itList.hasNext() && !anterior){
                f = (Fecha) itList.next();
                System.out.print("antes del casting = "+ f.getDia().get(Calendar.DAY_OF_MONTH) +"_\n");
                System.out.print("mes = "+ f.getDia().get(Calendar.MONTH) +"_\n");
                System.out.print("año= "+ f.getDia().get(Calendar.YEAR) +"__\n");
                anterior = f.esAnterior(dia);
                System.out.print("bucle whilejornada..esanterior__"+ anterior+"__");
            }

        }
        return anterior;
    }

  
    int getNumero(){

        return this.numJornada;
    }

    List getFechas(){

        return this.fecha;
     }

    void setNumero(int num){
        
        this.numJornada = num;
    }

    void setFechas(GregorianCalendar[] listaDeFechas){
        
        GregorianCalendar dia;
        for(int i=0; i<listaDeFechas.length; i++){
            dia = listaDeFechas[i];
            Fecha f = new Fecha(dia);
            this.fecha.add(f);
        }

    }

    
    int[] obtenerResultado(String nombClub){

        ClasificacionClub cc = buscarCClub(nombClub);
        return cc.obtenerResultados();
    }

    void anotarResultado(GregorianCalendar dia, String nombClubLocal,int puntosLocal, int puntosVisi){

        Fecha fech = buscarFecha(dia);

        fech.anotarResultado(nombClubLocal,puntosLocal, puntosVisi);

    }

    String obtenerNombClubVisitante(GregorianCalendar dia, String nombClubLocal){

        Fecha fech = buscarFecha(dia);

        return fech.obtenerNombClubVisi(nombClubLocal);

    }

    void definirClasificacionClub(Club cl, int ganados, int perdidos, int puntosAFavor, int puntosEnContra){

        ClasificacionClub cc = new ClasificacionClub(cl,ganados,perdidos,puntosAFavor,puntosEnContra);

        (this.cClub).put(cl.getNombre(),cc);

    }

    ArrayList resultadoJugadores(GregorianCalendar dia, String nombClubLocal ){

        ArrayList resultado = new ArrayList();
        ArrayList resultado1 = new ArrayList();
        int i =0;
            resultado.add(this.numJornada);
            //recorrer cada fecha []
           // resultado1 = (this.fecha)[i].resultadoJugadores(dia, nombClubLocal);
            resultado.add(resultado1);

            return resultado;

    }

    /**
     *
     * @param dia parametro a buscar
     * @return Fecha si son iguales
     *         null si son distintos
     */
    private Fecha buscarFecha(GregorianCalendar dia){

        Fecha       f = null;
        Iterator    itList= getFechas().iterator();
        boolean     encontrado = false;

            while(itList.hasNext() && !encontrado){
                f = (Fecha) itList.next();
                if (f.getDia().compareTo(dia) == 0)
                    encontrado = true;
            }
        
        return f;

    }
    private ClasificacionClub buscarCClub(String nombClub){

       ClasificacionClub cc = null;
       return cc;

    }

    ArrayList verPartidoDeJornada(){

        ArrayList resultado = new ArrayList();
        ArrayList resultado1 = new ArrayList();
        Fecha fech;
        resultado.add(getNumero());
        for(int i=0; i<fecha.length; i++){
            fech = fecha[i];
            resultado1 = fech.partidosDeUnDia();
            resultado.add(resultado1);
        }
        return resultado;

    }
    
    ArrayList clasificacionGeneral(){

        ArrayList resultado = new ArrayList();
        resultado.add(this.numJornada);
            if ((this.cClub).size() == 0) {

                resultado.add("No hay clasificacion para esa Jornada");

            }
            else{

                ordenarPorPartidosGanados();
                ArrayList datosClasificacion = new ArrayList();
                Iterator it = (this.cClub).entrySet().iterator();
                ClasificacionClub clc;

                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry)it.next();
                    clc= (ClasificacionClub) e.getValue();
                    datosClasificacion = clc.obtenerDatosClasificacion();
                    resultado.add(datosClasificacion);
                }

            }

        return resultado;
    }

    //private por DC ClasificacionGeneral
    private void ordenarPorPartidosGanados(){

    }

    ArrayList rankingAnotadores(){
    
        ArrayList resultado = new ArrayList();
        
            resultado.add(this.numJornada);
            if ((this.cJugador).size() == 0) {
                
                resultado.add("No existe la clasificacion para esa Jornada");          
            
            }
            else{
            
                ordenarPorRendimiento();
                ArrayList datosClasificacion = new ArrayList();
                Iterator it = (this.cJugador).entrySet().iterator();
                ClasificacionJugador clj;

                while (it.hasNext()) {// Ojo con los casting
                    Map.Entry e = (Map.Entry)it.next();
                    clj = (ClasificacionJugador) e.getValue();
                    datosClasificacion = clj.obtenerDatosClasificacion();
                    resultado.add(datosClasificacion);
                }
            
            }
        
        
        return resultado;   
    
    }
    //DC rankingAnotadores ----- ordenar Map por key no se puede porque la key es String
    private void ordenarPorRendimiento(){

        //documento en swad
        //List cjs = (this.cJugador).values();
        //Collections cjs =
        //Collections.sort(cjs);


     }
    void anotarResultadoJugador(Calendar dia,String nombClubLocal, String dniPas,
                                double minutosJugados, int intentos, int puntosConseguidos){}
    void incluirClasificacion(Jugador jug, double minutosTotales, int intentosTotales, int puntosTotales){}
    
    void definirPartido(GregorianCalendar dia, Club cl, Club cv, GregorianCalendar hora,String TVEmite) throws LracbEx{

        boolean     participa = false;
        Fecha       f1;
        Fecha       f2;
        Iterator    itList= getFechas().iterator();
            
            while(itList.hasNext() && !participa){
                f1 = (Fecha) itList.next();
                participa = f1.participaPartido(cl,cv);
                if (participa) throw new LracbEx("alguno de los club ya participa en otro partido de esa jornada");
            }
        System.out.print("definirPartido_antes buscardia\n");
        f2 = buscarFecha(dia);
        if (f2 == null) throw new LracbEx("No se ha definido jornada para este dia.\n");
        f2.definirPartido(cl, cv, hora, TVEmite);
        System.out.print("f2 de jornada ha ejecutao definirPartido OK\n");
    }

}
