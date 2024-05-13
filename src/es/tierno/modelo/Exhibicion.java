package es.tierno.modelo;

import java.util.Random;

/**
 * Clase hija de Partido que implementa sus metodos abstractos
 */

public class Exhibicion extends Partido {

    public Exhibicion(){
        
    }

    // metodo jugar que se decide si es ganado o no, 50% probalidad de ganar o perder
    @Override
    public void jugar(Random r) {
        int probalidad = r.nextInt(10) + 1;

        if(probalidad <= 5) this.ganado = true;
            else this.ganado = false;

            
        desarrolloJuego(r);
    }

    @Override
    public void detalles() {
        System.out.println("PARTIDO EXHIBICION: \nHEMOS GANADO: " + ((this.ganado)? " SI" : " NO") + "\nPUNTOS A FAVOR : " + this.puntosAFavor + 
        "\nPUNTOS EN CONTRA : " + this.puntosEnContra);
    }
    
}
