package es.tierno.modelo.factories;

import es.tierno.modelo.Alero;
import es.tierno.modelo.Base;
import es.tierno.modelo.Escolta;
import es.tierno.modelo.Jugador;
import es.tierno.modelo.Pitot;
import es.tierno.modelo.Pivot;

/**
 * La factory de jugadores que devuelve instancias segun datos, y maximo 3 jugadores por instancia
 */

public class FactoryJugador {
    static final int LIMITE_JUGADOR_POSICION = 3;
    static int base = 0;
    static int escolta = 0; 
    static int alero = 0;
    static int pitot = 0;
    static int pivot = 0;

    public static Jugador crearJugador(int altura, int habilidad){
        if (altura < 185 && habilidad >= 4 && base < 3) {
            base++;
            return new Base();
        } else if (altura < 190 && habilidad >= 3 && escolta < 3) {
            escolta++;

            return new Escolta();
        } else if (altura < 195 && habilidad >= 2 && alero < 3) {
            alero++;
            return new Alero();
        } else if (altura < 200 && habilidad >= 1 && pitot < 3) {
            pitot++;
            return new Pitot();
        } else {
            if(pivot < 3){
                pivot++;
                return new Pivot();
            }else if(base < 3){
                base++;
                return new Base();
            }else if(escolta < 3){
                escolta++;
                return new Escolta();
            }else if(alero < 3){
                alero++;
                return new Alero();
            }else{
                return new Pitot();
            }
            
        }
        
    }
}
