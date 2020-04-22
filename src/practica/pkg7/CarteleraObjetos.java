/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg7;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Usuario
 */
public class CarteleraObjetos {

    /**
     * Lo pongo porque lo explica muy bien, lo he hecho todo mirando lo del
     * profe porque no lo entendia.
     *
     * Método de lectura de un fichero con buffer y escritura de objetos.
     *
     * Leerá un fichero con BufferedReader y escribirá en otro con
     * ObjectOutputStream
     *
     * @see java.io.BufferedReader
     * @see java.io.ObjectOutputStream
     *
     * Proceso a seguir:
     * <ol>
     * <li>Pedirá la ruta del fichero a leer.</li>
     * <li>Pedirá la ruta del fichero a escribir.</li>
     * <li>Leerá línea a línea el fichero de entrada.</li>
     * <li>Creará una instacia de Pelicula que irá rellenando con lo que
     * lea</li>
     * <li>Escribirá el objeto creado en un fichero de objetos</li>
     * <li>Repetirá los pasos 3 a 5 hasta llegar al final del fichero de
     * entrada</li>
     * </ol>
     *
     * @throws RutaInvalida Excepción lanzada cuando no encuentra el fichero de
     * entrada
     */
    public static void leerEscribirObjetos(String rutaOrigen, String rutaDestino) throws FileNotFoundException {
        //No se si tengo que poner en el throw el ErrorRuta o dejar lo que he puesto
        try (BufferedReader lectorBuffer = new BufferedReader(new FileReader("rutaOrigen"));
                ObjectOutputStream objectSalida = new ObjectOutputStream(new FileOutputStream("rutaDestino"))) {
            boolean eof = false;
            String lineaLeida;
            String[] peliculas;
            String[] texto;
            int i = 0; //indice de campos
            Pelicula p = new Pelicula();
            /*inicializa una pelicula. No entiendo 
            esto, se supone que crea el objeto pero al hacerlo aqui no lo hara
            una sola vez? --> La respuesta esta mas abajo
             */
            while (!eof) {
                lineaLeida = lectorBuffer.readLine(); //lee una linea
                if (lineaLeida != null) {
                    peliculas = lineaLeida.split("\\{"); //separa por peliculas con la clave
                    for (int j = 0; j < peliculas.length; j++) {
                        texto = peliculas[j].split("#"); //divide por campos
                        for (int k = 0; k < texto.length; k++) {
                            switch (i) {//Añade el texto en el campo correspondiente
                                case 0:
                                    p.setTitulo(p.getTitulo() + texto[k] + " "); //No entiendo bien lo de estos geters.
                                    break;
                                case 1:
                                    p.setAnio(p.getAnio() + texto[k] + " ");
                                    break;
                                case 2:
                                    p.setDirector(p.getDirector() + texto[k] + " ");
                                    break;
                                case 3:
                                    p.setDuracion(p.getDuracion() + texto[k] + " ");
                                    break;
                                case 4:
                                    p.setSinopsis(p.getSinopsis() + texto[k] + " ");
                                    break;
                                case 5:
                                    p.setReparto(p.getReparto() + texto[k] + " ");
                                    break;
                                case 6:
                                    p.setSesion(p.getSesion() + texto[k] + " ");
                                    break;
                            }
                            if (k < texto.length - 1) {/*Con esto hago que el campo
                                cambie al siguiente al repetirse lo de las opciones
                                y cuando llegue al ultimo entonces ya no aumentara
                                 */
                                i++;
                            }
                        }
                        if (j < peliculas.length - 1) {/*Lo mismo que el anterior
                            pero con las peliculas, sino es la ultima pelicula
                            pasara a la siguiente
                             */
                            objectSalida.writeObject(p);/*Asi escribira el objeto
                            en el archivo de salida
                             */
                            p = new Pelicula();//Crea un nuevo objeto de pelicula
                            i = 0; //Pone los campos a 0 para reiniciarlo
                        }
                    }
                } else {
                    eof = true;
                }
            }
            objectSalida.writeObject(p); //Escribe en el archivo de salida la ultima pelicula
            //p.mostrarPelicula() //Esto puede servir por si quieres comprobar que se han escrito bien
        } catch (EOFException ex) {//Sale este error cuando llega al final de fichero
            System.err.println("Fin de fichero");
        } catch (IOException ex) {
            System.err.println("Error de lectura/escritura");
        }
    }

    /**
     * Método de lectura de un fichero de objetos y escritura en otro fichero de
     * objetos.
     *
     * Leerá un fichero con ObjectInputStream y escribirá en otro con
     * ObjectOutputStream
     *
     * @see java.io.ObjectInputStream
     * @see java.io.ObjectOutputStream
     *
     * Proceso a seguir:
     * <ol>
     * <li>Pedirá la ruta del fichero a leer.</li>
     * <li>Pedirá la ruta del fichero a escribir.</li>
     * <li>Leerá un objeto del fichero de entrada</li>
     * <li>Escribirá el objeto leido en el fichero de salida</li>
     * <li>Repetirá los pasos 3 y 4 hasta llegar al final del fichero de
     * entrada</li>
     * </ol>
     *
     * @throws RutaInvalida Excepción lanzada cuando no encuentra el fichero de
     * entrada
     */
    public static void leerObjEscribirObj(String rutaOrigen, String rutaDestino) throws FileNotFoundException {//No se que poner en los throws
        try (ObjectInputStream objectEntrada = new ObjectInputStream(new FileInputStream(rutaOrigen));
                ObjectOutputStream objectSalida = new ObjectOutputStream(new FileOutputStream(rutaDestino))) {
            boolean eof = false;
            while (!eof) {//El error del EOFException te saca a la fuerza
                objectSalida.writeObject(new Pelicula((Pelicula) objectEntrada.readObject()));//Lee el objeto lo convierte y lo mete en otro objeto luego lo escribe en otro fichero
            }
        } catch (EOFException e) {
            System.err.println("Fin de fichero");
        } catch (IOException ex) {
            System.err.println("Error de lectura/escritura");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de clase");
        }
    }

    /**
     * Método de lectura de un fichero de objetos y escritura por consola.
     *
     * Leerá un fichero con ObjectInputStream y lo mostrará por consola.
     *
     * @see java.io.ObjectInputStream
     *
     * Proceso a seguir:
     * <ol>
     * <li>Pedirá la ruta del fichero a leer.</li>
     * <li>Leerá un objeto del fichero de entrada</li>
     * <li>Mostrará por consola el objeto leido</li>
     * <li>Repetirá los pasos 2 y 3 hasta llegar al final del fichero de
     * entrada</li>
     * </ol>
     *
     * @throws RutaInvalida Excepción lanzada cuando no encuentra el fichero de
     * entrada
     */
    public static void leerObjEscribirCons(String rutaOrigen) throws FileNotFoundException {
        try (ObjectInputStream objectEntrada = new ObjectInputStream(new FileInputStream(rutaOrigen))) {
            boolean eof = false;
            Pelicula p = new Pelicula();
            while (!eof) {
                p = (Pelicula) objectEntrada.readObject();//Sobrescribe los valores
                p.mostrarPelicula();
            }
        } catch (EOFException e) {
            System.err.println("Fin de Fichero");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de clase");
        } catch (IOException ex) {
            System.out.println("Error de lectura");
        }
    }

    /**
     * Método de lectura por consola y escritura de objetos en fichero.
     *
     * Pedirá al usuario los atributos del objeto Pelicula y lo escribirá en un
     * fichero de objetos con ObjectOutputStream.
     *
     * @throws streamsandexceptions.RutaInvalida
     * @see java.io.ObjectOutputStream
     *
     * Proceso a seguir:
     * <ol>
     * <li>Pedirá la ruta del fichero de objetos a escribir.</li>
     * <li>Pedirá al usuario que introduzca por consola una película</li>
     * <li>Creará una instancia de Pelicula</li>
     * <li>Escribirá el objeto en el fichero de salida</li>
     * </ol>
     */
    public static void leerConsEscribirObj(String rutaDestino) throws FileNotFoundException {
        try (ObjectOutputStream objectSalida = new ObjectOutputStream(new FileOutputStream(rutaDestino))) {
            Pelicula p = new Pelicula(); //Creo el objeto
            p.pedirPelicula();//Te piden los datos de la pelicula
            objectSalida.writeObject(p);//Lo escribes en el fichero
        } catch (IOException ex) {
            System.err.println("Error de escritura");
        }
    }
}
