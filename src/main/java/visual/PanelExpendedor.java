package visual;


import org.example.Expendedor;
import org.example.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**El Jpanel PanelExpendedor representa un panel que permite al usuario visualizar los productos disponibles en el expendedor
 * y la caida de los objetos al ser comrpados ademas de las monendas ingresadas
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 */
public class PanelExpendedor extends JPanel implements ActionListener {

    /** Referencia a las imagenes de los productos*/
    private Image coca, fanta, sprite, snickers, super8;

    /** Referencia para el temporizador para la animacion del producto cayendo*/
    private Timer timer;

    /** Referencia a expendedor para la representacion de la cantidad de productos*/
    private Expendedor expendedor;

    /** Referencia a el tipo de producto que esta cayendo*/
    private TipoProducto productoCayendo = null;

    /** Referencia a la cantidad de producto cayendo*/
    private int cantidadCayendo = 0;

    /** Variable booleana que indica si un producto esta cayendo*/
    private boolean CaeProd = false;

    /** Referencia a la posicion en el eje x de la que cae el producto*/
    private int productoCayendoX;

    /** Referencia a moneda para vizualizar las monedas en el panelexpendedor*/
    private Monedas mon;

    /** Referencia para controlar la posicion de las monedas en el eje x*/
    private int x;

    /**
     * Constructor, permite al usuario visualizar los productos, configura el fondo del panel, el tamaño del expendedor, configura
     * un temporizador
     * @param expendedor Referencia al expendedor con el que se trabaja
     * @param mon Referencia al panel de monedas para la representacion grafica
     */
    public PanelExpendedor(Expendedor expendedor, Monedas mon) {
        this.x=0;
        this.expendedor = expendedor;
        this.mon = mon;
        this.setPreferredSize(new Dimension(1000, 800));
        this.setBackground(Color.BLACK);
        coca = new ImageIcon("src/main/java/visual/cocacola.png").getImage();
        fanta = new ImageIcon("src/main/java/visual/fanta.png").getImage();
        sprite = new ImageIcon("src/main/java/visual/sprite.png").getImage();
        snickers = new ImageIcon("src/main/java/visual/snickers.png").getImage();
        super8 = new ImageIcon("src/main/java/visual/super8.png").getImage();



        timer = new Timer(10, this);
        timer.start();
    }

    /**
     * Dibuja el panel del expendedor y los productos disponibles.
     * @param g Objeto Graphics para dibujar en el panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g.setColor(Color.gray);
        g.fillRect(0, 0, 850, 525);
        g.setColor(Color.black);
        g.drawLine(650,0,650,650);
        g.setColor(Color.black);
        g.drawLine(0,100,650,100);
        g.setColor(Color.black);
        g.drawLine(0,200,650,200);
        g.setColor(Color.black);
        g.drawLine(0,310,650,310);
        g.setColor(Color.black);
        g.drawLine(0,390,650,390);


        // Dibuja todos los productos disponibles en el Expendedor
        ProductosDisponibles(g2D);

        if (CaeProd) {
            ProdCayendo(g2D);
        }
    }

    /**
     * Dibuja los productos disponibles en el expendedor.
     * @param g2D Objeto Graphics2D para dibujar los productos.
     */
    private void ProductosDisponibles(Graphics2D g2D) {
        for (TipoProducto tipo : TipoProducto.values()) {
            for (int i = 0; i < expendedor.getCantidadProducto(tipo); i++) {
                PintaProducto(g2D, tipo, i * 100, PosicionX(tipo));
            }
        }
    }

    /**
     * Dibuja el producto que está cayendo en el panel si es que existe uno.
     * @param g2D Objeto Graphics2D para dibujar el producto cayendo.
     */
    private void ProdCayendo(Graphics2D g2D) {
        if (productoCayendo != null) {
            PintaProducto(g2D, productoCayendo, productoCayendoX+680, PosicionY(productoCayendo));
        }
    }

    /**
     * Devuelve la posición X en donde se debe dibujar un producto en función del tipo de producto.
     * @param tipo Tipo de producto
     * @return posicion x del producto
     */
    private int PosicionX(TipoProducto tipo) {
        switch (tipo) {
            case COCA:
                return 0;
            case FANTA:
                return 100;
            case SPRITE:
                return 200;
            case SNICKERS:
                return 320;
            case SUPER8:
                return 380;
            default:
                return 0;
        }
    }

    /**
     * Calcula la posición Y dependiendo del producto que está cayendo y la cantidad de producto que está cayendo.
     * @param tipo Tipo de producto
     * @return posicion y del producto
     */
    private int PosicionY(TipoProducto tipo) {
        // Calcula la posición Y en función del producto que cae
        switch (tipo) {
            case COCA:
                return cantidadCayendo * 3;
            case FANTA:
                return 100 + cantidadCayendo * 3;
            case SPRITE:
                return 200 + cantidadCayendo * 3;
            case SNICKERS:
                return 320 + cantidadCayendo * 3;
            case SUPER8:
                return 350 + cantidadCayendo * 3;
            default:
                return 0;
        }
    }

    /**
     * Dibuja un producto en una posición específica en el panel.
     * @param g2D Objeto Graphics2D para dibujar el producto.
     * @param tipo Tipo de producto
     * @param x posicion x en el panel
     * @param y posicion y en el panel
     */
    private void PintaProducto(Graphics2D g2D, TipoProducto tipo, int x, int y) {
        switch (tipo) {
            case COCA:
                g2D.drawImage(coca, x, y, null);
                break;
            case FANTA:
                g2D.drawImage(fanta, x, y, null);
                break;
            case SPRITE:
                g2D.drawImage(sprite, x + 16, y, null);
                break;
            case SNICKERS:
                g2D.drawImage(snickers, x, y, null);
                break;
            case SUPER8:
                g2D.drawImage(super8, x, y, null);
                break;
        }
    }

    /**
     * controla la animación de la caída del producto.
     * @param e Objeto ActionEvent que representa el evento del temporizador.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (CaeProd) {
            cantidadCayendo +=2;

            if (PosicionY(productoCayendo) >= 800) {
                expendedor.getProductoComprado();
                CaeProd = false;
                cantidadCayendo = 0;
            }

            repaint();
        }
    }

    /**
     * Inicia la animación de la caída de un producto específico.
     * @param tipoProducto tipo de producto que cae
     */
    public void iniciarCaidaProducto(TipoProducto tipoProducto) {
        if (!CaeProd) {
            productoCayendo = tipoProducto;
            CaeProd = true;
            productoCayendoX = 0;
        }
    }

    /**
     * Dibuja una moneda en el expendedor
     * @param color color de la moneda a dibujar
     */
    public void PaintMoneda(Color color){
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillArc(x,530,50,50,0,360);
        x += 60;
    }

    /**
     * Restablece la posicion horizontal del dibujo de las monedas
     */
    public void reinicioPos(){
        x = 0;
    }

}
