package org.example;

/**
 * Fanta es una subclase de Bebida que representa la bebida fanta, utiliza el metodo "sabor" para la
 * descripcion del sabor
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin ALejandro Godoy Vergara
 */
public class Fanta extends Bebida{

    /**
     * Constructor
     * @param c representa el numero de serie de la bebida
     */
    public Fanta(int c){
        super(c);
    }

    /**
     * @return cadena de caracteres que describe el sabor de la bebida Fanta
     */
    public String sabor(){
        return "fanta";
    }

    /** método que muestra un descripción de la clase
     * @return cadena de caderes que hace referencia al número de serie de Fanta*/
    @Override
    public String toString() {
        return "Fanta" + super.toString();
    }
}