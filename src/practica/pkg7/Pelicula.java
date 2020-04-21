/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Pelicula implements Serializable {

    static Scanner lector = new Scanner(System.in);

    //Atributos de la pelicula
    private String titulo = "";
    private String anio = ""; //año
    private String director = "";
    private String duracion = "";
    private String sinopsis = "";
    private String reparto = "";
    private String sesion = "";

    public Pelicula() {
    }

    public Pelicula(String titulo, String anio, String director, String duracion, String sinopsis, String reparto, String sesion) {
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.sesion = sesion;
    }

    public Pelicula(Pelicula p) {
        this.titulo = p.titulo;
        this.anio = p.anio;
        this.director = p.director;
        this.duracion = p.duracion;
        this.sinopsis = p.sinopsis;
        this.reparto = p.reparto;
        this.sesion = p.sesion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public void pedirPelicula() {
        System.out.println("Introduce el titulo de la pelicula: ");
        this.setTitulo(lector.nextLine());
        System.out.println("Introduce el año: ");
        this.setAnio(lector.nextLine());
        System.out.println("Introduce la duración: ");
        this.setDuracion(lector.nextLine());
        System.out.println("Introduce la sinopsis: ");
        this.setSinopsis(lector.nextLine());
        System.out.println("Introduce el reparto: ");
        this.setReparto(lector.nextLine());
        System.out.println("Introduce la sesion: ");
        this.setSesion(lector.nextLine());
    }

    public void mostrarPelicula() {
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Año: " + this.getAnio());
        System.out.println("Duración: " + this.getDuracion());
        System.out.println("Sinopsis: " + this.getSinopsis());
        System.out.println("Reparto: " + this.getReparto());
        System.out.println("Sesión: " + this.getSesion());
    }
}
