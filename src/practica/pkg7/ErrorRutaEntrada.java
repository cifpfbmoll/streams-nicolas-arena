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
    public int errorCode;

    public ErrorRutaEntrada() {
    }

    public ErrorRutaEntrada(String mensaje, int errorCode) {
        this.mensaje = mensaje;
        this.errorCode = errorCode;
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

}
