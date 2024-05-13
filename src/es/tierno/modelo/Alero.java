package es.tierno.modelo;

/**
 * Clase hija de jugador que implementa el metodo abstracto detalles()
 */
public class Alero extends Jugador{

    public Alero(String nombre, int dorsal, int altura, int habilidad) {
        super(nombre, dorsal, altura, habilidad);
        
    }
    
    public Alero(){
        
    }

    @Override
    public void detalles() {
        System.out.println("----ALERO----\nNOMBRE: " + this.nombre + "\nDORSAL: " + this.dorsal + 
        "\nALTURA: " + this.altura + "\nHABILIDAD: " + this.habilidad + "\nPUNTOS ANOTADOS: " + this.puntosAnotados +
         "\nFALTAS COMETIDAS: " + this.faltasCometidas);
    }
}
