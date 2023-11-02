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
    int YVelocity = 1;
    int XVelocity = 1;
    int y = 0;
    int x = 0;
    private Expendedor expendedor;

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
        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.COCA); i++) {
            g2D.drawImage(coca, x+i * 100, y , null);
        }
        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.FANTA); i++) {
            g2D.drawImage(fanta, x+i*100, y + 100, null);
        }

        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.SPRITE); i++) {
            g2D.drawImage(sprite, x +i*100+ 16, y + 200, null);
        }

        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.SNICKERS); i++) {
            g2D.drawImage(snickers, x+i*100, y + 320 , null);
        }

        for (int i = 0; i < expendedor.getCantidadProducto(TipoProducto.SUPER8); i++) {
            g2D.drawImage(super8, x+i*100, y + 350, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(y>=PANEL_HEIGHT){
            YVelocity = YVelocity * -1;
        }
        y += YVelocity;
        repaint();
    }
}
