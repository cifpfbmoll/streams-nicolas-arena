/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Usuario
 */
public class CarteleraObjetos {

    public static void leerEscribirObjetos(String rutaOrigen, String rutaDestino) throws FileNotFoundException, IOException {
        ObjectInputStream lectura = null;
        File origen = new File(rutaOrigen);
        File destino = new File(rutaDestino);
        FileInputStream entrada = new FileInputStream(origen);
        FileOutputStream salida = new FileOutputStream(destino);
        lectura = new ObjectInputStream(entrada);
        ObjectOutputStream escribir = new ObjectOutputStream(salida);
        lectura.close();
        escribir.close();

    }

    /* No se si hacer uno para cada cosa o ponerlo junto todo
    public static void leerObjetos(String rutaOrigen) {
    }

    public static void escribirObjetos(String rutaDestino) {
    }
     */
}
