
package GestionLRACB;

import LRACB.*;
/**
 *
 * @author Fco Javier Lucena Lucena
 */
public class GestionLRACB {

    public static void main(String[] args){

        LRACB ligaACB = LRACB.getLRACB();
        int opcion = 0;


        do{
            try{

                //ligaACB.incluirClub("CB Granada", "Trifon", "Palacio Deportes");
                //ligaACB.verJugadoresDeClub("CB Granada");
            }catch (Exception ex){
                System.err.println(ex.getMessage());
            }


        }while (opcion != 0);


    }//main
}