package org.example;

/**
 * Bebida es una clase abstracta que se extiende desde Producto y representa a un tipo de producto,
 * cada bebida tiene un numero de serie unico y debe implementar el metodo abstracto sabor para obtener
 * su sabor
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 * */
abstract public class Bebida extends Producto{

    /** Entero que almacena el numero de serie de la bebida*/
    private int serie;

    /** Constructor
     * @param a representa la serie de la bebida*/
    public Bebida(int a){
        this.serie = a;
    }

    /** metodo abstracto que debe ser implementado por todas las subclases de bebida
     * @return cadena de caracteres que hace referencia al sabor de la bebida*/
    public abstract String sabor();

    /** @return un entero con la serie de la bebida */
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