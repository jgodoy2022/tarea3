package visual;

import org.example.Expendedor;
import org.example.TipoProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PanelExpendedor extends JPanel{

    private int PANEL_WIDTH = 1000;
    private int PANEL_HEIGHT = 800;
    private Image coca, fanta, sprite, snickers, super8;
    private List<ActionListener> imageListeners = new ArrayList<>();
    private Timer timer;
    int YVelocity = 1;
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

        imageListeners = new ArrayList<>();
        addActionListenerForImage(coca);
        addActionListenerForImage(fanta);
        addActionListenerForImage(sprite);
        addActionListenerForImage(snickers);
        addActionListenerForImage(super8);

        //timer = new Timer(10, (ActionListener) this);
        //timer.start();
    }

    public void addActionListenerForImage(final Image image) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mueve la imagen hacia abajo cuando se activa el ActionListener
                moveImage(image);
            }
        };
        imageListeners.add(listener);
    }

    public Image getCoca() {
        return coca;
    }
    public Image getFanta(){
        return fanta;
    }
    public Image getSprite(){
        return sprite;
    }
    public Image getSnickers(){
        return snickers;
    }
    public Image getSuper8(){
        return super8;
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

    public void moveImage(Image image){
        if(y>=PANEL_HEIGHT){
            YVelocity = YVelocity * 0;
        }
        y += YVelocity;
        repaint();
    }
}
