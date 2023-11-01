package org.example;

/**
 * La clase representa una excepción personalizada que se lanza cuando se produce un error relacionado con un
 * pago erroreo o nulo del producto a escoger.
 * @author Joaquin Alejandro Godoy Vergara
 * @author Gabriela Isidora Zambrano Novoa
 */
public class PagoIncorrectoException extends Exception {
    /** crea una nueva instancia de la excepción con un mensaje descriptivo
     * @param mensaje mensaje que describe la razón del error
     */
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}