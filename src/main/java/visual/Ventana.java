package visual;

import org.example.Expendedor;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private PanelPrincipal mypanel;
    private Expendedor expendedor;

    public Ventana(){
        expendedor=new Expendedor(6);
        mypanel = new PanelPrincipal(expendedor);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.add(mypanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
