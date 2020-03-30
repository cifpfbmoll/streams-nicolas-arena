/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.util.InputMismatchException;
import java.util.Scanner;
import static practica.pkg7.BuffersCharacterStreams.leerBuffer;
import static practica.pkg7.CarteleraByteStreams.leerByte;
import static practica.pkg7.CarteleraCharacterStreams.leerCharacter;

/**
 *
 * @author Usuario
 */
public class Menu {

    static Scanner lector = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            System.out.println("");
            System.out.println("4. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = Integer.parseInt(lector.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        leerByte(rellenarRuta("Dime la ruta de Origen:"), rellenarRuta("Dime la ruta de Destino:"));
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        leerCharacter(rellenarRuta("Dime la ruta de Origen:"), rellenarRuta("Dime la ruta de Destino:"));
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        leerBuffer(rellenarRuta("Dime la ruta de Origen:"), rellenarRuta("Dime la ruta de Destino:"));
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                lector.next();
            }
        }
    }

    public static String rellenarRuta(String nombre) {
        String ruta;

        System.out.println(nombre);
        ruta = lector.nextLine();

        return ruta;
    }

}
