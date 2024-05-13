package es.tierno.modelo;

import java.util.Random;

/**
 * Clase hija de Partido que implementa sus metodos abstractos
 */

public class Oficial extends Partido {
    private boolean local;

    public Oficial(boolean local) {
        this.local = local;
    }

    public Oficial(){
        
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    //jugar un partido si es local hay mas probalidad y se decide si es partido ganado o no.
    @Override
    public void jugar(Random r) {
        int probalidadGanado = r.nextInt(10)+ 1;
        
        if(this.local){
            if(probalidadGanado <= 7){
                this.ganado = true;
            }else{
                this.ganado = false;
            }
        }else{
            if(probalidadGanado <= 3){
                this.ganado = true;
            }else{
                this.ganado = false;
            }
        }


        desarrolloJuego(r);

    }

    @Override
    public void detalles() {
        System.out.println("PARTIDO OFICIAL: \nLOCALES : " + ((this.local)? " SI" : " NO") + "\nHEMOS GANADO: " + ((this.ganado)? " SI" : " NO") + "\nPUNTOS A FAVOR : " + this.puntosAFavor + 
        "\nPUNTOS EN CONTRA : " + this.puntosEnContra);
    }

    
    
}
