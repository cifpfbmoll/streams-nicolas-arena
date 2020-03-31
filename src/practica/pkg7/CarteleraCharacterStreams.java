/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class CarteleraCharacterStreams {

    public static void leerCharacter(String rutaOrigen, String rutaDestino) throws ErrorRutaEntrada, ErrorRutaSalida{
        File entrada = new File(rutaOrigen);
        File salida = new File(rutaDestino);
        String enunciado = "Cartelera de CineFBMoll";
        String apartado[] = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", "Reparto: ", "Sesión: "};
        int texto;
        int i = 0;
        try (FileReader leer = new FileReader(entrada);
                FileWriter escribir = new FileWriter(salida)) {
            for (int j = 0; j < enunciado.length(); j++) {
                escribir.write(enunciado.charAt(j));
            }
            escribir.write(System.getProperty( "line.separator" ));
            do {
                texto = leer.read();
                if (texto != -1) {
                    if (Character.toString((char) texto).equals("#")) {
                        escribir.write(System.getProperty( "line.separator" ));
                        if (i >= 0 && i < 6) {
                            for (int j = 0; j < apartado[i].length(); j++) {
                                escribir.write(apartado[i].charAt(j));
                            }
                        }
                        i++;

                    } else if (Character.toString((char) texto).equals("{")) {
                        escribir.write(System.getProperty( "line.separator" ));
                        escribir.write(System.getProperty( "line.separator" ));
                        i = 0;
                    } else {
                        escribir.write(texto);
                    }
                }
            } while (texto != -1);
        } catch (IOException exc) {
            System.out.println("Error al leer el archivo");
            System.out.println(exc.getMessage());
        }
    }
}
