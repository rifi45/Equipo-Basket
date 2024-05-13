package es.tierno.modelo;

/**
 * Clase hija de jugador que implementa el metodo abstracto detalles()
 */

public class Escolta extends Jugador{

    public Escolta(String nombre, int dorsal, int altura, int habilidad) {
        super(nombre, dorsal, altura, habilidad);
        //TODO Auto-generated constructor stub
    }

    public Escolta(){
        
    }

    @Override
    public void detalles() {
        System.out.println("----ESCOLTA----\nNOMBRE: " + this.nombre + "\nDORSAL: " + this.dorsal + 
        "\nALTURA: " + this.altura + "\nHABILIDAD: " + this.habilidad + "\nPUNTOS ANOTADOS: " + this.puntosAnotados +
         "\nFALTAS COMETIDAS: " + this.faltasCometidas);
    }
    
}
