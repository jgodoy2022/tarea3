package org.example;


/**
 * La clase Producto es una clase abstracta la cual funciona como base para los productos, posee un metodo
 * abstracto que todas las clases que hereden producto deben usar
 * @author Joaquin Alejandro Godoy Vergara
 * @author Gabriela Isidora Zambrano Novoa
 */
abstract public class Producto {


    /**
     * Constructor por defecto
     */
    public Producto() {
    }

    /**
     * @return una cadena de caracteres que representa el sabor del producto
     */
    public abstract String sabor();

}