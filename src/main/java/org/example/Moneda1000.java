package org.example;

/**
 * La clase Moneda1000 es una subclase de Moneda y representa un tipo de moneda para pagar algún producto en Expendedor
 * @author Joaquin Alejandro Godoy Vergara
 * @author Gabriela Isidora Zambrano Novoa
 */
public class Moneda1000 extends Moneda{

    /** Constructor por defecto*/
    public Moneda1000(){
        super();
    }

    /** método adquirido por la Superclase
     * @return el valor de la moneda, en este caso, 1000.
     */
    public int getValor(){
        return 1000;
    }

    /**método que muestra un descripción de la clase
     * @return cadena de caderes que hace referencia al valor de la moneda.
     */
    @Override
    public String toString() {
        return super.toString()+getValor()+" pesos";
    }
}