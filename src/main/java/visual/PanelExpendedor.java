package visual;

import org.example.Expendedor;
import org.example.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelExpendedor extends JPanel implements ActionListener {

    private Image coca, fanta, sprite, snickers, super8;
    private Timer timer;
    private Expendedor expendedor;
    private TipoProducto productoCayendo = null;
    private int cantidadCayendo = 0;
    private boolean CaeProd = false;
    private int productoCayendoX; // Posición X inicial del producto que cae
    private Monedas mon;
    private int x;

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

    private void ProductosDisponibles(Graphics2D g2D) {
        for (TipoProducto tipo : TipoProducto.values()) {
            for (int i = 0; i < expendedor.getCantidadProducto(tipo); i++) {
                PintaProducto(g2D, tipo, i * 100, PosicionX(tipo));
            }
        }
    }

    private void ProdCayendo(Graphics2D g2D) {
        if (productoCayendo != null) {
            PintaProducto(g2D, productoCayendo, productoCayendoX+680, PosicionY(productoCayendo));
        }
    }

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

    public void iniciarCaidaProducto(TipoProducto tipoProducto) {
        if (!CaeProd) {
            productoCayendo = tipoProducto;
            CaeProd = true;
            productoCayendoX = 0;
        }
    }

    public void PaintMoneda(Color color){
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillArc(x,530,50,50,0,360);
        x += 60;
    }

    public void reinicioPos(){
        x = 0;
    }

}
