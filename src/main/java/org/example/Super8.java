package org.example;

/**
 * Super8 es una subclase de Dulce que representa el dulce super8, utiliza el metodo "sabor" para la
 * descripcion del sabor
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin ALejandro Godoy Vergara
 */
public class Super8 extends Dulce{

    /**
     * Constructor
     * @param c representa el numero de serie del dulce
     */
    public Super8(int c) {
        super(c);
    }

    /**
     * @return cadena de caracteres que describe el sabor del dulce Super8
     */
    public String sabor(){
        return "super8";
    }

    /** método que muestra un descripción de la clase
     * @return cadena de caderes que hace referencia al número de serie de Super8*/
    @Override
    public String toString() {
        return "Super8" + super.toString();
    }
}