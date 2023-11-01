package org.example;

/**
 * CocaCola es una subclase de Bebida que representa la bebida cocacola, utiliza el metodo "sabor" para la
 * descripcion del sabor
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin ALejandro Godoy Vergara
 */
public class CocaCola extends Bebida{

    /**
     * Constructor
     * @param c representa el numero de serie de la bebida
     */
    public CocaCola(int c){
        super(c);
    }

    /**
     * @return cadena de caracteres que describe el sabor de la bebida CocaCola
     */
    public String sabor(){
        return "cocacola";
    }

    /** método que muestra un descripción de la clase
     * @return cadena de caderes que hace referencia al número de serie de CocaCola*/
    @Override
    public String toString() {
        return "CocaCola" + super.toString();
    }
}