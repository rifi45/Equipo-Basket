package es.tierno.modelo.comprobaciones;

import java.util.ArrayList;

import es.tierno.modelo.Equipo;
import es.tierno.modelo.Jugador;


/**
 * Clase que sirve para realizar comprobaciones
 */
public class Comprobaciones {
    //Comprobar que un jugador esta en la lista
    public static boolean jugadorEncontrado(ArrayList<Jugador> jugadores, Jugador jugador){
        boolean encontrado = false;
        for(Jugador j : jugadores){
            if(j == jugador){
                encontrado = true;
                break;
            }else{
                encontrado = false;
            }
        }

        return encontrado;
    }

    //comprobar que un dorsal es unico
    public static boolean comprobarDorsal(Equipo a, int dorsal){
        boolean comprobar = false;
        if(!a.getJugadores().isEmpty()){
            for(Jugador j : a.getJugadores()){
                if(j.getDorsal() == dorsal){
                    comprobar = false;
                    break;
                }else{
                    comprobar = true;
                }
            }
        }else{
            comprobar = true;
        }

        return comprobar;
    }
}
