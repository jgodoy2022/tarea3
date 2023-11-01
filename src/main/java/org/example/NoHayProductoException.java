package org.example;

/**
 * La clase representa una excepción personalizada que se lanza cuando se produce un error relacionado con la
 * falta de una producto en el deposito o la inexistencia del mismo.
 * @author Joaquin Alejandro Godoy Vergarax
 * @author Gabriela Isidora Zambrano Novoa
 */
public class NoHayProductoException extends Exception{
    /** crea una nueva instancia de la excepción con un mensaje descriptivo
     * @param mensaje mensaje que describe la razón del error
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}