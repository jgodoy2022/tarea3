package org.example;
import java.util.ArrayList;

/**
 * Deposito es una clase generia que representa un deposito de objetos de tipo especificado
 * @author Joaquin Alejandro Godoy Vergara
 * @author Gabriela Isidora Zambrano Novoa
 * @param <T> tipo de objeto que se almacenara
 */
public class Deposito<T> {


    /** Almacena objetos de tipo T en el deposito*/
    private ArrayList<T> Cosas;


    /**
     * Constructor de la clase
     * Inicializa una arraylist para almacenar objetos en esta
     */
    public Deposito() {
        Cosas = new ArrayList();
    }

    /**
     * Metodo que añade cosas/objetos al arraylist
     * @param b hace referencia al objeto que se va a agregar
     */
    public void addCosas(T b) {
        Cosas.add(b);
    }

    /**
     * obtiene un objeto del arraylist
     * @return primer objeto almacenado
     */
    public T getCosas() {
        if (Cosas.size() != 0) {
            return Cosas.remove(0);
        }
        return null;
    }

    /**
     * obtiene la cantidad de objetos en el deposito+-
     * @return numero de objetos almacenados
     */
    public int sizeCosas(){
        return Cosas.size();
    }

}