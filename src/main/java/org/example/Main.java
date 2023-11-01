package org.example;

import visual.Ventana;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        Ventana ventana = new Ventana();
=======
        //expendedor con solo 3 productos para hacer 4 compras y la ultima sea invalida por falta de producto
        Expendedor exp = new Expendedor(3);
        Moneda m = null;
        Comprador c=null;

        //compra de producto inexistente
        try{
            m = new Moneda500();
            c = new Comprador(m,656,exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda500();
            c = new Comprador(m,656,exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda500();
            c = new Comprador(m,656,exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
        } catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }

        //compra con moneda nula
        try {
            m = null;
            c = new Comprador(m, TipoProducto.SPRITE.getOpcion(), exp);
            System.out.println(c.queCompraste() + ", " + c.cuantoVuelto());
            m = null;
            c = new Comprador(m, TipoProducto.SPRITE.getOpcion(), exp);
            System.out.println(c.queCompraste() + ", " + c.cuantoVuelto());
            m = null;
            c = new Comprador(m, TipoProducto.SPRITE.getOpcion(), exp);
            System.out.println(c.queCompraste() + ", " + c.cuantoVuelto());
        } catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }

        //compra de 4 cocacolas de precio 1000 sin vuelto
        try{
            m = new Moneda1000();
            c = new Comprador(m,TipoProducto.COCA.getOpcion(), exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1000();
            c = new Comprador(m,TipoProducto.COCA.getOpcion(), exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1000();
            c = new Comprador(m,TipoProducto.COCA.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1000();
            c = new Comprador(m,TipoProducto.COCA.getOpcion(), exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
        }catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }

        //compra de 4 sprites de precio 1000 con vuelto
        try{
            m = new Moneda1500();
            c = new Comprador(m,TipoProducto.SPRITE.getOpcion(), exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1500();
            c = new Comprador(m,TipoProducto.SPRITE.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1500();
            c = new Comprador(m,TipoProducto.SPRITE.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1500();
            c = new Comprador(m,TipoProducto.SPRITE.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
        } catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }

        //compra de 4 snickers y saldo insuficiente
        try{
            m = new Moneda100();
            c = new Comprador(m,TipoProducto.SNICKERS.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda100();
            c = new Comprador(m,TipoProducto.SNICKERS.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda100();
            c = new Comprador(m,TipoProducto.SNICKERS.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda100();
            c = new Comprador(m,TipoProducto.SNICKERS.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
        } catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }

        //compra de 2 productos diferentes
        try{
            m = new Moneda1500();
            c = new Comprador(m,TipoProducto.SNICKERS.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1500();
            c = new Comprador(m,TipoProducto.SNICKERS.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
            m = new Moneda1500();
            c = new Comprador(m,TipoProducto.SUPER8.getOpcion(),exp);
            System.out.println(c.queCompraste()+", "+c.cuantoVuelto());
        } catch (PagoIncorrectoException e){
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException e){
            System.out.println(e.getMessage());
        } catch (NoHayProductoException e){
            System.out.println(e.getMessage());
        }

>>>>>>> d56194c8131893c60166f32309028c4fd678a93c
    }
}