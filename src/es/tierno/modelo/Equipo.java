package es.tierno.modelo;

import java.util.ArrayList;
import java.util.Stack;

import es.tierno.modelo.comprobaciones.Comprobaciones;


/**
 * La clase Equipo que me define un equipo
 */

public class Equipo {
    private String nombre;
    private String direccion;
    private ArrayList<Jugador> jugadores;
    private Stack<Partido> partidos;

    public Equipo(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.jugadores = new ArrayList<>();
        this.partidos = new Stack<>();
    }

    //Se añade un partido a la pila de partidos
    public void jugarPartido(Partido partido){
        this.partidos.add(partido);
    }

    //Se añade un jugador a la lista de jugadores
    public void anadirJugador(Jugador jugador){
        boolean encontrado = Comprobaciones.jugadorEncontrado(this.jugadores, jugador);

        if(this.jugadores.size() <= 15){
            if(!encontrado){
                this.jugadores.add(jugador);
            }else{
                System.out.println("EL JUGADOR YA EXISTE");
            }
        }
        
    }

    // se elimina un jugador de la lista de jugadores
    public void eliminarJugador(Jugador jugador){
        boolean encontrado = Comprobaciones.jugadorEncontrado(this.jugadores, jugador);

        if(!this.jugadores.isEmpty()){
            if(encontrado){
                this.jugadores.remove(jugador);
                System.out.println("SE HA ELIMINADO CORRECTAMENTE. ");
            }else{
                System.out.println("NO SE HA ENCONTRADO NINGUN JUGADOR");
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Stack<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Stack<Partido> partidos) {
        this.partidos = partidos;
    }

    

    
}
