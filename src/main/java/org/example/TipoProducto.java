package org.example;

/** La clase enum TipoProducto representa el listado de productos, su posición dentro de la máquina expendedora y
 * sus respectivos precios
 * @author Joaquin Alejandro Godoy Vergara
 * @author Gabriela Isidora Zambrano Novoa
 */
public enum TipoProducto {
    /** elementos de la enumeración, que tienen la opción y su respectivo precio*/
    COCA(1,1000),
    SPRITE(2,1000) ,
    FANTA(3,1000),
    SNICKERS(4,600),
    SUPER8(5,300);

    /**entero para almacenar la opción a escoger por el cliente*/
    private final int opcion;

    /**entero para almacenar el valor de la opción a escoger por el cliente*/
    private final int valor;

    /** constructor por defecto, que recibe dos parametros para actualizar la referencia a la opción y valor de la
     * lista de la enumeración
     * @param opcion es la opción de la enumeración
     * @param valor indica el valor de la opción elegida
     */
    TipoProducto(int opcion, int valor) {
        this.opcion = opcion;
        this.valor = valor;
    }

    /** @return opcion actualizada en constructor*/
    public int getOpcion(){
        return opcion;
    }

    /** @return valor de la opcion actualizada en constructor*/
    public int getValor(){
        return valor;
    }
}