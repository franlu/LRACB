
package GestionLRACB;

import LRACB.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author Fco Javier Lucena Lucena
 */
public class GestionLRACB {

    private static int menuInicial() throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
            System.out.println("\n===========================================\n"+
             "1. Definir una Jornada para la liga Regular"+"\n"+
             "2. Incluir un Club"+"\n"+
             "3. Incluir un Jugador en un Club"+"\n"+
             "4. Definir un Partido"+"\n"+
             "5. Anotar el resultado de un partido"+"\n"+
             "6. Anotar el resultado de un Jugador en un Partido" +"\n"+
             "7. Obtener los Partidos de una determinada Jornada" +"\n"+
             "8. Ver los Jugadores de un Club" +"\n"+
             "9. Mostrar la Clasificacion General" +"\n"+
             "10. Obtener el resultado de los Jugadores en un Partido" +"\n"+
             "11. Listar el ranking de Anotadores" +"\n"+
             "12. Mostrar la evolucion de un Jugador" +"\n"+
             "0. Terminar\n"+
            "====================================================\n");
        return(Integer.parseInt(in.readLine()));
    }


    public static void main(String[] args){

        LRACB             ligaACB = LRACB.getLRACB();
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        GregorianCalendar aux = new GregorianCalendar();
        String            nombClub;
        String            nombJug;
        String            nombEntre;
        String            dniPas;
        int               opcion = 0;
        int               anio;
        int               mes;
        int               dia;
        int               numJornada;
        int               puntosLocal;
        int               puntosVisi;
        int               intentos;
        int               puntos;
        double            minutosJug;
        

        do{
            try{

                opcion = menuInicial();
                
                switch (opcion){
                
                    case 1:
                        System.out.print("¿Durante cuantos dias se celebra la jornada? ");
                        int dias = Integer.parseInt(in.readLine());

                        while (dias<1 || dias>3){
                            System.out.print("Minimo Uno, Maximo tres :)");
                            dias = Integer.parseInt(in.readLine());
                        }
                       
                        GregorianCalendar[] listaDeFechas = new GregorianCalendar[dias];

                        for(int i=0;i<dias; i++){
                            System.out.print("Fecha " + (i+1) + " :\n");
                            System.out.print("Indica el Dia \n");
                            dia = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Mes \n");
                            mes = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Año \n");
                            anio = Integer.parseInt(in.readLine());
                            aux.set(anio,mes,dia);
                            listaDeFechas[i] = aux;
                        }

                        ligaACB.definirJornada(listaDeFechas);
                        System.out.print("La Jornada ha sido definida correctamente.");
                        System.out.println();
                        break;

                    case 2:
                        System.out.print("Introduce el nombre del Club:  ");
                        nombClub = in.readLine();
                        System.out.print("Introduce el nombre del Entrenador:  ");
                        nombEntre = in.readLine();
                        System.out.print("Introduce el nombre del Pabellon :  ");
                        String nombPab = in.readLine();
                        ligaACB.incluirClub(nombClub, nombEntre, nombPab);
                        System.out.print("El club se ha añadido a la liga.");
                        System.out.println();
                        break;

                    case 3:
                        System.out.print("Introduce el nombre del Club:  ");
                        nombClub = in.readLine();
                        System.out.print("Introduce el DNI/PAS del Jugador :  ");
                        dniPas = in.readLine();
                        System.out.print("Introduce el nombre del Jugador:  ");
                        nombJug = in.readLine();
                        System.out.print("Introduce la Fecha de Nacimiento:  \n");
                            System.out.print("Indica el Dia \n");
                            dia = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Mes \n");
                            mes = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Año \n");
                            anio = Integer.parseInt(in.readLine());
                            aux.set(anio,mes,dia);
                        System.out.print("Introduce la altura del Jugador:  ");
                        double altura = Double.parseDouble(in.readLine());
                        System.out.print("Introduce el peso :  ");
                        double peso = Double.parseDouble(in.readLine());
                        System.out.print("Introduce la posicion:  ");
                        String posicion = in.readLine();
                        System.out.print("Introduce la nacionalidad:  ");
                        String nacionalidad = in.readLine();
                        System.out.print("Introduce el numero :  ");
                        int num = Integer.parseInt(in.readLine());
                        ligaACB.incluirJugador(nombClub, dniPas , nombJug, aux, altura , peso, posicion, nacionalidad, num);
                        System.out.print("El " + nombClub + " ha fichado un nuevo Jugador.");
                        System.out.println();
                        break;

                    case 4:
                        System.out.print("Introduce el numero de la Jornada: ");
                        numJornada = Integer.parseInt(in.readLine());
                        System.out.print("Introduce la fecha de la Jornada  \n");
                            System.out.print("Indica el Dia \n");
                            dia = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Mes \n");
                            mes = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Año \n");
                            anio = Integer.parseInt(in.readLine());
                            aux.set(anio,mes,dia);
                        System.out.print("Introduce el nombre del Club Local:  ");
                        nombClub = in.readLine();
                        System.out.print("Introduce el nombre del Club Visitante:  ");
                        String nombClubVisi = in.readLine();
                        System.out.print("Introduce la hora del Partido:  ");
                            System.out.print("Hora:  ");
                            int hora = Integer.parseInt(in.readLine());
                            System.out.print("Minutos:  ");
                            int minutos = Integer.parseInt(in.readLine());
                            aux.set(anio,mes,dia,hora,minutos);
                        System.out.print("Indica la TV que emite el partido:  ");
                        String tv = in.readLine();
                        ligaACB.definirPartido(numJornada, aux, nombClub, nombClubVisi, aux, tv);
                        System.out.print("Definido un nuevo partido para la jornada " + numJornada + "\n");
                        break;

                    case 5:
                        System.out.print("Introduce el numero de la Jornada: ");
                        numJornada = Integer.parseInt(in.readLine());
                        System.out.print("Introduce la fecha de la Jornada  \n");
                            System.out.print("Indica el Dia \n");
                            dia = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Mes \n");
                            mes = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Año \n");
                            anio = Integer.parseInt(in.readLine());
                            aux.set(anio,mes,dia);
                        System.out.print("Introduce el nombre del Club Local:  ");
                        nombClub = in.readLine();
                        System.out.print("Introduce los puntos del equipo Local: ");
                        puntosLocal = Integer.parseInt(in.readLine());
                        System.out.print("Introduce los puntos del equipo visitante: ");
                        puntosVisi = Integer.parseInt(in.readLine());
                        ligaACB.anotarResultado(numJornada, aux, nombClub, puntosLocal, puntosVisi);
                        break;

                    case 6:
                        System.out.print("Introduce el numero de la Jornada: ");
                        numJornada = Integer.parseInt(in.readLine());
                        System.out.print("Introduce la fecha de la Jornada  \n");
                            System.out.print("Indica el Dia \n");
                            dia = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Mes \n");
                            mes = Integer.parseInt(in.readLine());
                            System.out.print("Indica el Año \n");
                            anio = Integer.parseInt(in.readLine());
                            aux.set(anio,mes,dia);
                        System.out.print("Introduce el nombre del Club Local:  ");
                        nombClub = in.readLine();
                        System.out.print("Introduce el DNI/PAS del Jugador :  ");
                        dniPas = in.readLine();
                        System.out.print("Introduce los minutos jugados: ");
                        minutosJug = Double.parseDouble(in.readLine());
                        System.out.print("Introduce el numero de intentos: ");
                        intentos = Integer.parseInt(in.readLine());
                        System.out.print("Introduce el numero de puntosConseguidos: ");
                        puntos = Integer.parseInt(in.readLine());
                        ligaACB.anotarResultadoJugador(numJornada, aux, nombClub, dniPas, minutosJug, intentos, puntos);
                        break;

                    case 7:
                        System.out.print("Introduce el numero de la Jornada: ");
                        numJornada = Integer.parseInt(in.readLine());
                        ArrayList partidos = ligaACB.verPartidoDeJornada(numJornada);
                        ArrayList resultado = new ArrayList();

                        Iterator it = partidos.listIterator();
                        while (it.hasNext()) {}
                        //    Map.Entry e = (Map.Entry)it.next();
                          //  par = (Partido) e.getValue();
                            //resultado2 = par.datosDelPartido();
                            //resultado1.add(resultado2);
                        break;

                    case 8:
                        System.out.print("Introduce el nombre del Club:  ");
                        nombClub = in.readLine();
                        ArrayList   datosJugadores = ligaACB.verJugadoresDeClub(nombClub);

                        System.out.print("\nNombre del Club: " + datosJugadores.get(0));
                        System.out.print("\n===========================================\n");

                        //datosJugadores.get(1).getClass().isArray()
                        if (ArrayList.class == datosJugadores.get(1).getClass()){
                            ArrayList   jugadores = (ArrayList) datosJugadores.get(1);
                            Iterator    ite = jugadores.listIterator();
                            ArrayList   jugador = new ArrayList();
                            while (ite.hasNext()) { // para cada jugador
                                System.out.print("aaaaaaaaaaaa " + ite.next());
                                  jugador = (ArrayList) ite.next();
                                  System.out.print("Nombre: " + jugador.get(0));
                                  System.out.print("Edad: " + jugador.get(1));
                                  System.out.print("Altura: " + jugador.get(2));
                                  System.out.print("Peso: " + jugador.get(3));
                                  System.out.print("Posicion: " + jugador.get(4));
                                  System.out.print("Nacionalidad: " + jugador.get(5));
                                  System.out.print("Numero: " + jugador.get(6));
                                  System.out.print("\n===========================================\n");
                                                             
                            }
                        }
                        else
                            System.out.print(datosJugadores.get(1));
                        break;

                    case 9:
                        System.out.print("Introduce el numero de la Jornada: ");
                        numJornada = Integer.parseInt(in.readLine());
                        ArrayList clasificacion = ligaACB.clasificacionGeneral(numJornada);
                        break;

                    case 10:
                        ligaACB.resultadoJugadores(opcion, null, null);
                        break;

                    case 11:
                        System.out.print("Introduce el numero de la Jornada: ");
                        numJornada = Integer.parseInt(in.readLine());
                        ligaACB.rankingAnotadores(numJornada);
                        break;

                    case 12:
                        System.out.print("Introduce el nombre del Jugador:  ");
                        nombJug = in.readLine();
                        ligaACB.evolucionJugador(nombJug);
                        break;

                    case 0:
                        break;

                    default: System.out.println("Opcion no valida");
                               break;
                    }
            }catch (Exception ex){
                System.err.println(ex.getMessage());
            }


        }while (opcion != 0);


    }//main
}
