package es.tierno.modelo.listas;

import es.tierno.modelo.Equipo;
import es.tierno.modelo.Jugador;
import es.tierno.modelo.entrada_datos.Entrada;

/**
 * Clase que sirve para las listas de opciones, listado de opciones
 */

public class Listas {
    //mostrar el listado de jugadores y devolver el elegido
    public static Jugador listarJugadores(Equipo e){
        int i = 1;
        int opcion = 0;

        if(!e.getJugadores().isEmpty()){
            System.out.println("ELIGES UN JUGADOR :");
            for(Jugador f : e.getJugadores()){
                System.out.println(i + ". " + f.getNombre());
                i++;
            }

            System.out.print("OPCION: ");
            opcion = Entrada.leerNumero();
        }else{
            System.out.println("NO HAY JUGADORES");
        }
        
        
        if(opcion > e.getJugadores().size() || opcion == 0){
            return null;
        }else{
            return e.getJugadores().get(opcion - 1);
        }
    }

    //devuelve la eleccion entre oficial y exhibicion
    public static int elegirOpcionPartido(){
        int opcion = 0;
        do{
            System.out.print("1. PARTIDO OFICIAL\n2. PARTIDO EXHIBICION\nOPCION: ");
            opcion = Entrada.leerNumero();
        }while(opcion <= 0 || opcion >= 3);

        return opcion;
    }
}
