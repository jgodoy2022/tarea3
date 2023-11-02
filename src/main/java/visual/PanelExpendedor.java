package visual;

import org.example.Expendedor;
import org.example.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelExpendedor extends JPanel implements ActionListener {

    private int PANEL_WIDTH = 1000;
    private int PANEL_HEIGHT = 800;
    private Image coca, fanta, sprite, snickers, super8;
    private Timer timer;
    int YVelocity = 3;
    int XVelocity = 1;
    int y = 0;
    int x = 0;
    private Expendedor expendedor;
    private TipoProducto productoCayendo = null;
    private int cantidadCayendo = 0;
    private boolean productoCayendoFlag = false;

    public PanelExpendedor(Expendedor expendedor){
        this.expendedor=expendedor;
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        coca = new ImageIcon("src/main/java/visual/cocacola.png").getImage();
        fanta = new ImageIcon("src/main/java/visual/fanta.png").getImage();
        sprite = new ImageIcon("src/main/java/visual/sprite.png").getImage();
        snickers = new ImageIcon("src/main/java/visual/snickers.png").getImage();
        super8 = new ImageIcon("src/main/java/visual/supero8.png").getImage();

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.green);
        g.fillRect(0, 0, 600, 500);
        Graphics2D g2D = (Graphics2D) g;

        if (productoCayendoFlag) {
            drawFallingProduct(g2D);
        } else {
            // Dibuja todos los productos disponibles en el Expendedor
            drawAvailableProducts(g2D);
        }
    }
    private void drawAvailableProducts(Graphics2D g2D) {
        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.COCA); i++) {
            g2D.drawImage(coca, i * 100, 0, null);
        }
        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.FANTA); i++) {
            g2D.drawImage(fanta, i * 100, 100, null);
        }
        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.SPRITE); i++) {
            g2D.drawImage(sprite, i * 100 + 16, 200, null);
        }
        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.SNICKERS); i++) {
            g2D.drawImage(snickers, i * 100, 300, null);
        }
        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.SUPER8); i++) {
            g2D.drawImage(super8, i * 100, 400, null);
        }
    }
    private void drawFallingProduct(Graphics2D g2D) {
        if (productoCayendo != null) {
            switch (productoCayendo) {
                case COCA:
                    g2D.drawImage(coca, 0, y, null);
                    break;
                case FANTA:
                    g2D.drawImage(fanta, 0, y, null);
                    break;
                case SPRITE:
                    g2D.drawImage(sprite, 16, y, null);
                    break;
                case SNICKERS:
                    g2D.drawImage(snickers, 0, y, null);
                    break;
                case SUPER8:
                    g2D.drawImage(super8, 0, y, null);
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (productoCayendoFlag) {
            // Animación de caída del producto
            y += 3;

            // Si el producto ha llegado al suelo, se decrementa la cantidad en el Expendedor
            if (y >= PANEL_HEIGHT) {
                expendedor.getProductoComprado();
                productoCayendoFlag = false;
                y = 0;
            }

            repaint(); // Repintar el panel
        }
    }
    public void iniciarCaidaProducto(TipoProducto tipoProducto) {
        if (!productoCayendoFlag) {
            productoCayendo = tipoProducto;
            productoCayendoFlag = true;
            cantidadCayendo = 1;
        }
    }
}
