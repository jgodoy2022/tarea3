package visual;

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


    public PanelExpendedor(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        coca = new ImageIcon("src/main/java/visual/cocacola.png").getImage();
        fanta = new ImageIcon("src/main/java/visual/fanta.png").getImage();
        sprite = new ImageIcon("src/main/java/visual/sprite.png").getImage();
        snickers = new ImageIcon("src/main/java/visual/snickers.png").getImage();
        super8 = new ImageIcon("src/main/java/visual/supero8.png").getImage();

        timer = new Timer(10, this);
        //timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        //g2D.drawImage(coca, x, y, null);
        //g2D.drawImage(fanta, x, y+100, null);
        g2D.drawImage(sprite, x, y+200, null);
        g2D.drawImage(snickers, x, y+320, null);
        g2D.drawImage(super8, x, y+400, null);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(y>=PANEL_HEIGHT){
            YVelocity = YVelocity * 0;
        }
        y += YVelocity;
        repaint();
    }
}
