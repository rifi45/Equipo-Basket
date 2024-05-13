package es.tierno.modelo.factories;

import es.tierno.modelo.Exhibicion;
import es.tierno.modelo.Oficial;
import es.tierno.modelo.Partido;

/**
 * Factory de partidos que devuelve un partido segun opcion.
 */

public class FactoryPartido {
    public static Partido crearPartido(int opcion){
        if(opcion == 1){
            return new Oficial();
        }else{
            return new Exhibicion();
        }
    }
}
