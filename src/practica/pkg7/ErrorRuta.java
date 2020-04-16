/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ErrorRuta extends Exception {

    private String mensaje;
    private int errorCode;

    public ErrorRuta() {
    }

    public ErrorRuta(String mensaje, int errorCode) {
        this.mensaje = mensaje;
        this.errorCode = errorCode;
    }

    public ErrorRuta(int errorCode) {
        if (errorCode == 333) {
            this.setMensaje("No se encuentra el archivo");
        } else if (errorCode == 444) {
            this.setMensaje("Ruta no introducida");
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public static void escribirErrores(String mensajeDeError, String stackTrace) throws IOException {
        File finErrores = new File("errores.txt");
        FileWriter escritorErrores = new FileWriter(finErrores, true);
        Date fecha = new Date();
        escritorErrores.write("\n" + mensajeDeError + " " + fecha.toString() + " " + stackTrace); //He arreglado lo del stackTrace y he puesto el metodo en la clase del error
        escritorErrores.close();

    }

    public static void imprimirErrores(String mensajeError) {
        System.err.println(mensajeError);
    }
}
