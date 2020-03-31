/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

/**
 *
 * @author Usuario
 */
public class ErrorRutaEntrada extends Exception {

    public String mensaje;

    public ErrorRutaEntrada(String mensaje) {
        this.setMensaje("Has tenido un error al poner la ruta de origen");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
