/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class CarteleraByteStreams {

    public static void leerByte(String rutaOrigen, String rutaDestino) throws FileNotFoundException, IOException {
        String enunciado = "Cartelera de CineFBMoll";
        byte[] enunciado_convertido = enunciado.getBytes();
        String apartado[] = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", "Reparto: ", "Sesión: "};
        int texto;
        int i = 0;
        FileInputStream leer = new FileInputStream(rutaOrigen);
        FileOutputStream escribir = new FileOutputStream(rutaDestino);
        escribir.write(enunciado_convertido);
        escribir.write((char) 10);
        do {
            texto = leer.read();
            if (texto != -1) {
                if (Character.toString((char) texto).equals("#")) {
                    escribir.write((char) 10);
                    if (i >= 0 && i < 6) {
                        byte[] apartado_convertido = apartado[i].getBytes();
                        escribir.write(apartado_convertido);
                    }
                    i++;

                } else if (Character.toString((char) texto).equals("{")) {
                    escribir.write((char) 10);
                    escribir.write((char) 10);
                    i = 0;
                } else {
                    escribir.write(texto);
                }
            }
        } while (texto != -1);
        escribir.close();
    }
}
