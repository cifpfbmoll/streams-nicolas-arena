/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class BuffersCharacterStreams {

    public static void leerBuffer(String rutaOrigen, String rutaDestino) throws ErrorRutaEntrada, ErrorRutaSalida {
        File entrada = new File(rutaOrigen);
        File salida = new File(rutaDestino);
        String enunciado = "Cartelera de CineFBMoll";
        String apartado[] = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", "Reparto: ", "Sesión: "};
        int texto;
        int i = 0;
        try (BufferedReader leer = new BufferedReader(new FileReader(entrada));
                BufferedWriter escribir = new BufferedWriter(new FileWriter(salida))) {
            String lineaLeida = leer.readLine();
            String[] peliculas = lineaLeida.split("\\{");
            String[][] apartados_peliculas = new String[peliculas.length][apartado.length + 1];
            escribir.write(enunciado, 0, enunciado.length());

            escribir.newLine();

            for (int p = 0; p < peliculas.length; p++) {
                apartados_peliculas[p] = peliculas[p].split("#");
            }
            escribir.newLine();

            for (int j = 0; j < apartados_peliculas.length; j++) {
                for (int m = 0; m < apartados_peliculas[j].length; m++) {

                    escribir.write(apartados_peliculas[j][m]);
                    escribir.newLine();
                    if (i < 6) {
                        escribir.write(apartado[i]);
                        i++;
                    } else {
                        i = 0;
                    }
                }
                escribir.newLine();
            }

        } catch (FileNotFoundException exf) {
            throw new ErrorRutaEntrada(exf + "Error en la ruta de entrada", Arrays.toString(exf.getStackTrace()));
        } catch (IOException exc) {
            System.out.println("Error al leer el archivo");
            System.out.println(exc.getMessage());
        }
    }
}
