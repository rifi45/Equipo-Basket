package es.tierno.vista;

import java.util.Random;

import es.tierno.modelo.Equipo;
import es.tierno.modelo.Jugador;
import es.tierno.modelo.Oficial;
import es.tierno.modelo.Partido;
import es.tierno.modelo.comprobaciones.Comprobaciones;
import es.tierno.modelo.entrada_datos.Entrada;
import es.tierno.modelo.factories.FactoryJugador;
import es.tierno.modelo.factories.FactoryPartido;
import es.tierno.modelo.listas.Listas;

/**
 * @author Mohamed Afallah
 * @version 1.0
 */

 /*
  * Esta es mi clase App que es el main del proyecto
  */

public class App {

    //instancia estatica de Equipo con la cual llevaremos todo el trabajo
    static Equipo equipoA = new  Equipo("Parla Basket", "Tierno Galvan");
    public static void main(String[] args) {
        int opcion;

        //el menu del proyecto
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. AÑADIR NUEVO JUGADOR");
            System.out.println("2. ELIMINAR UN JUGADOR");
            System.out.println("3. JUGAR UN PARTIDO");
            System.out.println("4. MOSTRAR RESUMEN DEL ÚLTIMO PARTIDO");
            System.out.println("5. MOSTRAR HISTÓRICO DE LA TEMPORADA");
            System.out.println("6. MOSTRAR RESUMEN JUGADOR");
            System.out.println("0. SALIR");
            System.out.print("OPCION: ");
            opcion = Entrada.leerNumero();

            switch (opcion) {
                case 1:
                    anadirJugador();
                    break;
                case 2:
                    eliminarJugador();
                    break;
                case 3:
                    jugarPartido();
                    break;
                case 4:
                    visualizarUltimoPartido();
                    break;
                case 5:
                    visualizarPartidos();
                    break;
                case 6:
                    visualizarJugador();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    //metodo que sirve para añadir jugadores a la lista.
    private static void anadirJugador(){
        boolean comprobarDorsal = false;
        int altura = 0;
        int habilidad = 0;
        int dorsal = 0;


        //establecer el limite de 15 personas por equipo
        if(equipoA.getJugadores().size() < 15){
            System.out.println("JUGADORES "+ equipoA.getJugadores().size() + "/15");
            System.out.print("INTRODUZCA EL NOMBRE: ");
            String nombre = Entrada.leerTexto();
            do{
                System.out.print("INTRODUZCA EL DORSAL: ");
                dorsal = Entrada.leerNumero();
                //comrpobar dorsal unico.
                comprobarDorsal = Comprobaciones.comprobarDorsal(equipoA, dorsal);
                if(!comprobarDorsal){
                    System.out.println("DORSAL YA ASIGNADO, INTENTELO DE NUEVO.");
                }
            }while(!comprobarDorsal);

            //Comrpobar altura en el rango correcto
            do{
                System.out.print("INTRODUZCA LA ALTURA(MIN: 170/MAX: 240): ");
                altura = Entrada.leerNumero();
                if(altura < 170 || altura > 240){
                    System.out.println("ALTURA INCORRECTA. INTENTELO DE NUEVO.");
                }
            }while(altura < 170 || altura > 240);
            
            //comrpobar habilidad en el rango correcto
            do{
                System.out.print("INTRODUZCA LA HABILIDAD(MIN: 1/MAX: 5): ");
                habilidad = Entrada.leerNumero();

                if(habilidad < 1 || habilidad > 5){
                    System.out.println("HABILIDAD INCORRECTA, INTENTELO DE NUEVO.");
                }
            }while(habilidad < 1 || habilidad > 5);
            

            //crear una instancia de jugador segun sus datos.
            Jugador jugador = FactoryJugador.crearJugador(altura, habilidad);

            //setear al jugador sus datos
            jugador.setNombre(nombre);
            jugador.setDorsal(dorsal);
            jugador.setAltura(altura);
            jugador.setHabilidad(habilidad);

            equipoA.anadirJugador(jugador);
        }else{
            System.out.println("NO SE PUEDEN AÑADIR MAS DE 15 JUGADORES");
        }
        
    }

    //metodo que sirve para eliminar un jugador
    private static void eliminarJugador(){
        //metoso de la clase Listas devuelve un jugador
        Jugador j = Listas.listarJugadores(equipoA);

        if(!equipoA.getJugadores().isEmpty()){
            equipoA.eliminarJugador(j);
        }
       
    }

    //metodo que sirve para jugar un partido
    private static void jugarPartido(){
        
        //controlar que se añadan al menos 5 jugadores
        if(equipoA.getJugadores().size() >= 5){
            //elegir oficial o exhibicion
            int opcionPartido = Listas.elegirOpcionPartido();
            boolean locales = false;
            //devolver una instancia de partido segun la opcion elegida 
            Partido partido = FactoryPartido.crearPartido(opcionPartido);
            //invocar la clase Random para usar datos aleatorios
            Random r = new Random();


            // si es oficial se accede 
            if(opcionPartido == 1){

                    System.out.print("SOMOS LOCALES(Si/No): ");
                    locales = Entrada.leerSiNo();
                    ((Oficial) partido).setLocal(locales);
            }


            //jugar un partido
            partido.jugar(r);    
            equipoA.jugarPartido(partido);
            //Asignar puntos a los jugadores
            anotarPuntos(r, partido.getPuntosAFavor());
            cometerFalta(r);

            // informar si se ha ganado o se ha perdido
            System.out.println("PARTIDO " + ((partido.isGanado())? "GANADO" : "PERDIDO"));
        }else{
            System.out.println("DEBES AÑADIR AL MENOS 5 JUGADORES");
        }

    }

    // metodo que sirve para visualizar un partido
    private static void visualizarUltimoPartido(){
        if(!equipoA.getJugadores().isEmpty()){
            System.out.println("----RESUMEN UN PARTIDO----");
            equipoA.getPartidos().peek().detalles();
        }else{
            System.out.println("NO SE HAN JUGADO PARTIDOS");
        }
    }

    //metodo que sirve para visualizar todos los partidos
    private static void visualizarPartidos(){
        if(!equipoA.getPartidos().isEmpty()){
            System.out.println("----RESUMEN TEMPORADA(PARTIDOS)");
            for(Partido j : equipoA.getPartidos()){
                j.detalles();
                System.out.println("------------------------------");
            }
        }else{
            System.out.println("NO SE HAN JUGADO PARTIDOS TODAVIA");
        }
    }

    //metodo que sirve para visualizar un jugador
    private static void visualizarJugador(){
        Jugador p = Listas.listarJugadores(equipoA);

        if(!equipoA.getJugadores().isEmpty()){
            System.out.println("----RESUMEN TEMPORADA(JUGADOR)----");
            p.detalles();
        }

    }

    //METODOS PARA ANOTAR PUNTOS Y FALTAS PARA CADA JUGADOR.

    private static void anotarPuntos(Random r,int puntosAFavor){
        //SE ELEIJE UN JUGADOR ALEATORIAMENTE AL CUAL SE LE ASIGNA UN PUNTO
        for(int i = 0; i < puntosAFavor; i++){
            equipoA.getJugadores().get(r.nextInt(equipoA.getJugadores().size())).anotarPunto();
        }
    }

    private static void cometerFalta(Random r){
        //MAXIMO DE FALTAS A COMETER 30, MINIMO 5
        int numeroFaltas = r.nextInt(26) + 5;

        // SE ASIGNA ALEATORIAMENTE EL NUMERO DE FALTAS Y TAMBIEN SE ASIGNA ALEATORIAMENTE A UN JUGADOR.
        for(int i = 0; i < numeroFaltas; i++){
            equipoA.getJugadores().get(r.nextInt(equipoA.getJugadores().size())).cometerFalta();
        }
    }

}
