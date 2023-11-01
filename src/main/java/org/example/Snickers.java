package org.example;

/**
 * Snickers es una subclase de Dulce que representa el dulce snicker, utiliza el metodo "sabor" para la
 * descripcion del sabor
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin ALejandro Godoy Vergara
 */
public class Snickers extends Dulce {

    /**
     * Constructor
     * @param c representa el numero de serie del dulce
     */
    public Snickers(int c){
        super(c);
    }

    /**
     * @return cadena de caracteres que describe el sabor del dulce Snickers
     */
    public String sabor(){
        return "snickers";
    }

    /** método que muestra un descripción de la clase
     * @return cadena de caderes que hace referencia al número de serie de Snickers*/
    @Override
    public String toString() {
        return "Snickers" + super.toString();
    }
}