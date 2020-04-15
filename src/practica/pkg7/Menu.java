/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static void main(String[] args) throws ErrorRuta {
        // TODO code application logic here

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        String rutaOrigen = null;
        String rutaDestino = null;

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
                        rutaOrigen = rellenarRuta("Dime la ruta de Origen:");
                        rutaDestino = rellenarRuta("Dime la ruta de Destino:");
                        //pedirRuta(); Lo que quiero poner en vez de las dos lineas de arriba
                        leerByte(rutaOrigen, rutaDestino);
                        rutaOrigen = null;
                        rutaDestino = null;
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        rutaOrigen = rellenarRuta("Dime la ruta de Origen:");
                        rutaDestino = rellenarRuta("Dime la ruta de Destino:");
                        leerCharacter(rutaOrigen, rutaDestino);
                        rutaOrigen = null;
                        rutaDestino = null;
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        rutaOrigen = rellenarRuta("Dime la ruta de Origen:");
                        rutaDestino = rellenarRuta("Dime la ruta de Destino:");
                        leerBuffer(rutaOrigen, rutaDestino);
                        rutaOrigen = null;
                        rutaDestino = null;
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
            } catch (FileNotFoundException ex) {
                if (rutaOrigen == null || rutaOrigen.trim().isEmpty() || rutaDestino == null || rutaDestino.trim().isEmpty()) {
                    try {
                        throw new ErrorRuta(444);
                    } catch (ErrorRuta exNueva) {
                        try {
                            System.out.println(exNueva.getMensaje());
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
                            System.out.println(exNueva.getMensaje());
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

    /*
    public static void pedirRuta() { //Tengo que arreglar este metodo que estoy intentado hacer para reducir codigo
        rutaOrigen = rellenarRuta("Dime la ruta de Origen:");
        rutaDestino = rellenarRuta("Dime la ruta de Destino:");
    }
     */
}
