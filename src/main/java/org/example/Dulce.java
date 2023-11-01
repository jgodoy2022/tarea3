package org.example;

/**
 * Dulce es una clase abstracta que se extiende desde Producto y representa a un tipo de producto,
 * cada dulce tiene un numero de serie unico y debe implementar el metodo abstracto sabor para obtener
 * su sabor
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 * */
abstract public class Dulce extends Producto {

    /** Entero que almacena el numero de serie del dulce*/
    private int serie;


    /** Constructor
     * @param a representa la serie del dulce
     * */
    public Dulce(int a){
        this.serie = a;
    }

    /** metodo abstracto que debe ser implementado por todas las subclases de Dulce
     * @return cadena de caracteres que hace referencia al sabor del dulce*/
    public abstract String sabor();

    /** @return un entero con la serie del dulce */
    public int getSerie(){
        return this.serie;
    }

    /** método que muestra un descripción de la clase
     * @return cadena de caderes que hace referencia al número de serie del dulce*/
    @Override
    public String toString() {
        return "serie= " + serie;
    }
}