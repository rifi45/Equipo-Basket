package es.tierno.modelo;

/**
 * Clase abstract que me define lo que es un jugador
 */

public abstract class Jugador {
    protected String id;
    protected String nombre;
    protected int dorsal;
    protected int altura;
    protected int habilidad;
    protected int puntosAnotados;
    protected int faltasCometidas;

    public Jugador(){
        
    }

    public Jugador(String nombre, int dorsal, int altura, int habilidad) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.altura = altura;
        this.habilidad = habilidad;
    }

    //metodo abstracto paraa visualizar los detalles de cada jugador
    public abstract void detalles();

    //metodo que sirve para anotar punntos
    public void anotarPunto(){
        this.puntosAnotados += 1;
    }

    //metodo que sirve para cometer faltas
    public void cometerFalta(){
        this.faltasCometidas += 1; 
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getHabilidad() {
        return habilidad;
    }
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }
    public int getPuntosAnotados() {
        return puntosAnotados;
    }
    public void setPuntosAnotados(int puntosAnotados) {
        this.puntosAnotados = puntosAnotados;
    }
    public int getFaltasCometidas() {
        return faltasCometidas;
    }
    public void setFaltasCometidas(int faltasCometidas) {
        this.faltasCometidas = faltasCometidas;
    }

    @Override
    public String toString() {
        return "NOMBRE: " + getNombre() + "\nDORSAL: " + getDorsal() + "\nALTURA: " + getAltura() + "\nHABILIDAD: " + getHabilidad() + 
        "\nPUNTOS ANOTADOS: " + getPuntosAnotados() + "\nFALTAS COMETIDAS: " + getFaltasCometidas();
    }


    
    
    
}
