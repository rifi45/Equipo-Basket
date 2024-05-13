package es.tierno.modelo.entrada_datos;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que sirve para la entrada de datos, actua como un Scanner
 */

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static int leerNumero(){
        int numero = 0;
        boolean comprobar = false;

        do{
            try{
                numero = scanner.nextInt();

                if(numero < 0) throw new InputMismatchException();
                comprobar = true;

            }catch(InputMismatchException e){
                System.out.println("-----ERROR-----");
                System.out.print("Introduzcalo de nuevo : ");
            }finally{
                scanner.nextLine();
            }
        }while(comprobar == false);

        return numero;
    }

    public static String leerTexto(){
        return scanner.nextLine();
    }

    public static Boolean leerSiNo(){
        while(true){
            String cadena = scanner.nextLine();

            if(cadena.length()==2)
                if(cadena.equalsIgnoreCase("si")) return true;
                if(cadena.equalsIgnoreCase("no")) return false;

            System.out.println("DEBE INTRODUCIR SI O NO");
        }
    }
}
