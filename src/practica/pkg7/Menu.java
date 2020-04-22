/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static practica.pkg7.BuffersCharacterStreams.leerBuffer;
import static practica.pkg7.CarteleraByteStreams.leerByte;
import static practica.pkg7.CarteleraCharacterStreams.leerCharacter;
import static practica.pkg7.CarteleraObjetos.leerConsEscribirObj;
import static practica.pkg7.CarteleraObjetos.leerEscribirObjetos;
import static practica.pkg7.CarteleraObjetos.leerObjEscribirCons;
import static practica.pkg7.CarteleraObjetos.leerObjEscribirObj;

/**
 *
 * @author Usuario
 */
public class Menu {

    static Scanner lector = new Scanner(System.in);
    static String rutaOrigen = null;
    static String rutaDestino = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Le he quitado esto:  throws ErrorRuta 
        porque me parece que no hace falta.
         */
        // TODO code application logic here

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Lectura y escritura del fichero de cartelera "
                    + "byte a byte (byte Streams).");
            System.out.println("2. Lectura y escritura de fichero de cartelera "
                    + "carácter a carácter (character Streams).");
            System.out.println("3. Lectura y escritura de fichero línea a línea "
                    + "con buffers (character Streams).");
            System.out.println("4. Tratamiento de objetos.");
            System.out.println("");
            System.out.println("5. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = Integer.parseInt(lector.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        pedirRutaOrigen();
                        pedirRutaDestino(); //rutaOrigen y rutaDestino son globales por lo que comparten el resultado.
                        leerByte(rutaOrigen, rutaDestino);
                        resetearRutas();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        pedirRutaOrigen();
                        pedirRutaDestino();
                        leerCharacter(rutaOrigen, rutaDestino);
                        resetearRutas();
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        pedirRutaOrigen();
                        pedirRutaDestino();
                        leerBuffer(rutaOrigen, rutaDestino);
                        resetearRutas();
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        menuObjetos(); //Revisar
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                lector.next();
            } catch (FileNotFoundException ex) {
                if (rutaOrigen == null || rutaOrigen.trim().isEmpty() || rutaDestino == null || rutaDestino.trim().isEmpty()) {
                    try {
                        throw new ErrorRuta(444);
                    } catch (ErrorRuta exNueva) {
                        try {
                            exNueva.imprimirErrores(exNueva.getMensaje());
                            exNueva.escribirErrores(exNueva.getMensaje(), Arrays.toString(exNueva.getStackTrace()));
                        } catch (IOException ex1) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                } else {
                    try {
                        throw new ErrorRuta(333);
                    } catch (ErrorRuta exNueva) {
                        try {
                            exNueva.imprimirErrores(exNueva.getMensaje());
                            exNueva.escribirErrores(exNueva.getMensaje(), Arrays.toString(exNueva.getStackTrace()));
                        } catch (IOException ex1) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String rellenarRuta(String nombre) {
        String ruta;

        System.out.println(nombre);
        ruta = lector.nextLine();

        return ruta;
    }

    public static void pedirRutaOrigen() { //Para reducir memoria
        rutaOrigen = rellenarRuta("Dime la ruta de Origen:");
    }

    public static void pedirRutaDestino() {
        rutaDestino = rellenarRuta("Dime la ruta de Destino:");
    }

    public static void resetearRutas() {
        rutaOrigen = null;
        rutaDestino = null;
    }

    public static void menuObjetos() throws InputMismatchException, FileNotFoundException {
        boolean salir2 = false;
        int opcion2; //Guardaremos la opcion del usuario

        while (!salir2) {

            System.out.println("1. Lectura línea a línea y escritura con "
                    + "objetos (obteniendo ficheroSalObj).");
            System.out.println("2. Lectura de objetos (leyendo "
                    + "ficheroSalObj) y escritura de objetos (obteniendo "
                    + "ficheroSalObj2)");
            System.out.println("3. Lectura de objetos (leyendo "
                    + "ficheroSalObj2) y escritura por consola (comprobaremos "
                    + "por consola que nos ha escrito bien los objetos en los "
                    + "pasos anteriores).");
            System.out.println("4. Lectura por consola y escritura de objetos.");
            System.out.println("5. Volver al menú principal.");

            System.out.println("Escribe una de las opciones");
            opcion2 = Integer.parseInt(lector.nextLine());

            switch (opcion2) {
                case 1:
                    System.out.println("Has seleccionado la opcion 1");
                    pedirRutaOrigen();
                    pedirRutaDestino();
                    leerEscribirObjetos(rutaOrigen, rutaDestino);
                    resetearRutas();
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    pedirRutaOrigen();
                    pedirRutaDestino();
                    leerObjEscribirObj(rutaOrigen, rutaDestino);
                    resetearRutas();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    pedirRutaOrigen();
                    leerObjEscribirCons(rutaOrigen);
                    resetearRutas();
                    break;
                case 4:
                    System.out.println("Has seleccionado la opcion 4");
                    pedirRutaDestino();
                    leerConsEscribirObj(rutaDestino);
                    resetearRutas();
                    break;
                case 5:
                    salir2 = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }

        }
    }
}
