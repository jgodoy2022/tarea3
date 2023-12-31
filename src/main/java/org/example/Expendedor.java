package org.example;

/**
 * El Jpanel Monedas representa un panel que permite al usuario ingresar monedas para poder realizar compras
 * permite ingresar monedas de distintos valores y se asocia al resto de paneles para poder realiar las compras
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 * */
public class Expendedor {
    /** Deposito que almacena Bebidas coca*/
    private Deposito<Bebida> coca;

    /** Deposito que almacena Bebidas sprite*/
    private Deposito<Bebida> sprite;

    /** Deposito que almacena Bebidas fanta*/
    private Deposito<Bebida> fanta;

    /** Deposito que almacena Mondedas para el vuelto*/
    private Deposito<Moneda> monVu;

    /** Deposito que almacena Dulces snickers*/
    private Deposito<Dulce> snickers;

    /** Deposito que almacena Dulces super8*/
    private Deposito<Dulce> super8;

    /** Deposito unico del producto comprado*/
    private Producto productoComprado;

    /**
     * Agrega monedas al deposito de Monedas para el vuelto de la compra
     * @param valorMoneda valor de la moneda con la que se paga
     *  @param precioProducto precio del producto a comprar
     */
    public void AgregaMoneda(int valorMoneda, int precioProducto) {
        for (int i = 0; i < Math.abs(valorMoneda - precioProducto); i += 100) {
            Moneda a = new Moneda100();
            monVu.addCosas(a);
        }
    }

    /**
     * Da la cantidad de productos disponibles del expendedor dependiendo del tipo de producto
     * @param tipoProducto el producto del cual se desea conocer la cantidad restante
     * @return devuelve la cantidad de productos disponibles del producto deseado
     */
    public int getCantidadProducto(TipoProducto tipoProducto) {
        switch (tipoProducto) {
            case COCA:
                return coca.sizeCosas();
            case SPRITE:
                return sprite.sizeCosas();
            case FANTA:
                return fanta.sizeCosas();
            case SNICKERS:
                return snickers.sizeCosas();
            case SUPER8:
                return super8.sizeCosas();
            default:
                return 0;
        }
    }
/** Constructor recibe un unico parametro para llenar con esa cantidad los depositos de productos
 * @param numProductos numero de productos disponibles en el expendedor
 */
    public Expendedor(int numProductos) {
        productoComprado=null;
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        monVu = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        for(int i=0; i<numProductos; i++){
            Bebida a =new Fanta(i);
            fanta.addCosas(a);
            Bebida b = new CocaCola(i);
            coca.addCosas(b);
            Bebida c = new Sprite(i);
            sprite.addCosas(c);
            Dulce d = new Snickers(i);
            snickers.addCosas(d);
            Dulce e = new Super8(i);
            super8.addCosas(e);

        }
    }

    /**
     * Permite al cliente comprar un producto ingresando una moneda y la opcion del producto deseado
     * @param m moneda utilizada en la compra
     * @param queProducto representa el la opcion del producto deseado
     * @return producto comprado por el cliente
     * @throws NoHayProductoException si el producto no esta disponible o no existe
     * @throws PagoInsuficienteException si el pago es insuficiente y no da para comprar el producto
     * @throws PagoIncorrectoException si el pago es invalido
     */
    public void comprarProducto(int m,int queProducto) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        if(m <= 0){
            throw new PagoIncorrectoException("Error. Pago inválido");
        } else if (queProducto!=TipoProducto.COCA.getOpcion() && queProducto!=TipoProducto.SNICKERS.getOpcion() && queProducto!=TipoProducto.SUPER8.getOpcion() && queProducto!=TipoProducto.FANTA.getOpcion() && queProducto!=TipoProducto.SPRITE.getOpcion()){
            throw new NoHayProductoException("Error. Producto no disponible");
        } else if(m < TipoProducto.values()[queProducto - 1].getValor()){
            throw new PagoInsuficienteException("Error. Pago insuficiente");
        }
        else if(queProducto == TipoProducto.COCA.getOpcion() && (coca.sizeCosas() > 0)){
            AgregaMoneda(m, TipoProducto.values()[queProducto - 1].getValor());
            productoComprado= coca.getCosas();
        }
        else if (queProducto == TipoProducto.SPRITE.getOpcion() && (sprite.sizeCosas() > 0)) {
            AgregaMoneda(m, TipoProducto.values()[queProducto - 1].getValor());
            productoComprado= sprite.getCosas();
        }
        else if (queProducto == TipoProducto.FANTA.getOpcion() && (fanta.sizeCosas() > 0)) {
            AgregaMoneda(m, TipoProducto.values()[queProducto - 1].getValor());
            productoComprado= fanta.getCosas();
        }
        else if (queProducto == TipoProducto.SNICKERS.getOpcion() && (snickers.sizeCosas() > 0)) {
            AgregaMoneda(m, TipoProducto.values()[queProducto - 1].getValor());
            productoComprado= snickers.getCosas();
        }
        else if (queProducto == TipoProducto.SUPER8.getOpcion() && (super8.sizeCosas() > 0)) {
            AgregaMoneda(m, TipoProducto.values()[queProducto - 1].getValor());
            productoComprado= super8.getCosas();
        }
        else {
            throw new NoHayProductoException("Error. Producto no disponible");
        }
    }

    /**
     * Permite obtener el vuelto una a una
     * @return vuelto en forma de monedas
     */
    public Moneda getVuelto() {
        return monVu.getCosas();
    }

    /**
     * Permite obtener el producto comprado
     * @return  el producto comprado desde un deposito unico
     */
    public Producto getProductoComprado() {
        return productoComprado;
    }

    /** método que muestra un descripción de la clase
     * @return cadena de caderes que hace referencia a la cantidad de productos dentro del expendedor*/
    @Override
    public String toString() {
        return "Expendedor: " + "coca=" + coca + ", sprite=" + sprite + ", fanta=" + fanta +
                ", snickers=" + snickers + ", super8=" + super8;
    }
}