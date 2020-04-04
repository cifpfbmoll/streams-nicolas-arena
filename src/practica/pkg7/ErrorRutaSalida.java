/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ErrorRutaSalida extends Exception {

    private String mensaje;
    private String trace;

    public ErrorRutaSalida() {
    }

    public ErrorRutaSalida(String mensaje, String trace) {
        this.mensaje = mensaje;
        this.trace = trace;
        errorSalida(mensaje, trace);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public void errorSalida(String mensaje, String trace) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("errores.txt", true))) {
            //Para trabajar con fechas, ver: https://stackoverflow.com/questions/5683728/convert-java-util-date-to-string
            String plantilla = "MM/dd/yyyy HH:mm:ss";
            DateFormat df = new SimpleDateFormat(plantilla);
            Date fechahora = Calendar.getInstance().getTime();
            String fechahoraString = df.format(fechahora);
            escritor.write(fechahoraString);
            escritor.write(": " + mensaje);
            escritor.write("\n" + trace + "\n\n");
        } catch (IOException ioex) {
            System.out.println("Error al leer el archivo.");
        }
    }
}
