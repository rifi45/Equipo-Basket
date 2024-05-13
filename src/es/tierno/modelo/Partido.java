package es.tierno.modelo;

import java.util.Random;

/**
 * Clase abstract que me define lo que es un jugador
 */

public abstract class Partido {
    protected boolean ganado;
    protected int puntosAFavor;
    protected int puntosEnContra;

    public Partido(){
        
    }

    //Metodos abstractos de la clase
    public abstract void jugar(Random r);
    public abstract void detalles();


    //metodo que sirve para desarrollar un juego
    protected void desarrolloJuego(Random r){
        //MAXIMOS PUNTOS REAL 150.
        final int MAXIMO_PNTS = 115;
        final int MINIMO_PNTS = 35;

        //MAXIMOS PUNTOS REALES 100.
        final int MAX_PNTS_PROB = 30;
        final int MIN_PNTS_PROB = 70;
    
        int probalidadResultadoNormal = r.nextInt(10)+1;

        int puntosAnotados = 0;
        int puntosRecibidos = 0;

        /**
         * Si el partido esta ganado o no y se asignan puntos segun eso
         * Los puntos asignados son aleatorios
         */
        if(this.ganado){
            do{
                puntosAnotados = r.nextInt(MAXIMO_PNTS)+ MINIMO_PNTS + 1;

                puntosRecibidos = r.nextInt(MIN_PNTS_PROB)+ MINIMO_PNTS + 21;

                if(puntosAnotados >= MINIMO_PNTS || puntosAnotados <= 150){
                    if(probalidadResultadoNormal <= 8){
                        puntosAnotados = r.nextInt(MAX_PNTS_PROB) + MIN_PNTS_PROB + 1;
                        this.puntosAFavor = puntosAnotados;
                    }else{
                        this.puntosAFavor = puntosAnotados;
                    }
                }

                this.puntosEnContra = puntosRecibidos;

                
            }while(puntosAnotados <= puntosRecibidos);
            
        }else{
            do{
                puntosRecibidos = r.nextInt(MAXIMO_PNTS)+ MINIMO_PNTS + 1;

                puntosAnotados = r.nextInt(MIN_PNTS_PROB)+ MINIMO_PNTS + 21;

                if(puntosRecibidos >= MINIMO_PNTS || puntosRecibidos <= 150){
                    if(probalidadResultadoNormal <= 8){
                        puntosRecibidos = r.nextInt(MAX_PNTS_PROB) + MIN_PNTS_PROB + 1;
                        this.puntosEnContra = puntosRecibidos;
                    }else{
                        this.puntosEnContra = puntosRecibidos;
                    }
                }

                this.puntosAFavor = puntosAnotados;

                
            }while(puntosRecibidos <= puntosAnotados);
        }

        
    }
    
    public boolean isGanado() {
        return ganado;
    }
    public void setGanado(boolean ganado) {
        this.ganado = ganado;
    }
    public int getPuntosAFavor() {
        return puntosAFavor;
    }
    public void setPuntosAFavor(int puntosAFavor) {
        this.puntosAFavor = puntosAFavor;
    }
    public int getPuntosEnContra() {
        return puntosEnContra;
    }
    public void setPuntosEnContra(int puntosEnContra) {
        this.puntosEnContra = puntosEnContra;
    }

    
}
