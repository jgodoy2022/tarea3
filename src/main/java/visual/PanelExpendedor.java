package visual;

import org.example.Expendedor;
import org.example.TipoProducto;
import org.example.Comprador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelExpendedor extends JPanel implements ActionListener {

    private int PANEL_WIDTH = 1000;
    private int PANEL_HEIGHT = 800;
    private Image coca, fanta, sprite, snickers, super8;
    private Timer timer;
    private Expendedor expendedor;
    private TipoProducto productoCayendo = null;
    private int cantidadCayendo = 0;
    private boolean productoCayendoFlag = false;
    private int productoCayendoX; // Posición X inicial del producto que cae
    private Monedas mon;
    private int x;

    public PanelExpendedor(Expendedor expendedor, Monedas mon) {
        this.x=0;
        this.expendedor = expendedor;
        this.mon = mon;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        coca = new ImageIcon("src/main/java/visual/cocacola.png").getImage();
        fanta = new ImageIcon("src/main/java/visual/fanta.png").getImage();
        sprite = new ImageIcon("src/main/java/visual/sprite.png").getImage();
        snickers = new ImageIcon("src/main/java/visual/snickers.png").getImage();
        super8 = new ImageIcon("src/main/java/visual/super8.png").getImage();



        timer = new Timer(10, this);
        timer.start();
    }

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
        drawAvailableProducts(g2D);

        if (productoCayendoFlag) {
            drawFallingProduct(g2D);
        }
    }

    private void drawAvailableProducts(Graphics2D g2D) {
        for (TipoProducto tipo : TipoProducto.values()) {
            for (int i = 0; i < expendedor.getCantidadProducto(tipo); i++) {
                drawProduct(g2D, tipo, i * 100, getVerticalPosition(tipo));
            }
        }
    }

    private void drawFallingProduct(Graphics2D g2D) {
        if (productoCayendo != null) {
            drawProduct(g2D, productoCayendo, productoCayendoX+680, getYPosition(productoCayendo));
        }
    }

    private int getVerticalPosition(TipoProducto tipo) {
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

    private int getYPosition(TipoProducto tipo) {
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

    private void drawProduct(Graphics2D g2D, TipoProducto tipo, int x, int y) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (productoCayendoFlag) {
            cantidadCayendo++;

            if (getYPosition(productoCayendo) >= PANEL_HEIGHT) {
                expendedor.getProductoComprado();
                productoCayendoFlag = false;
                cantidadCayendo = 0;
            }

            repaint();
        }
    }

    public void iniciarCaidaProducto(TipoProducto tipoProducto) {
        if (!productoCayendoFlag) {
            productoCayendo = tipoProducto;
            productoCayendoFlag = true;
            productoCayendoX = 0;
        }
    }

    public void PaintMoneda(Color color){
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillArc(x,530,50,50,0,360);
        x += 60;
    }

    public void PaintVuelto(Color color){
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillArc(x,580,50,50,0,360);
        x += 60;
    }

    public void reinicioPos(){
        x = 0;
    }

}
