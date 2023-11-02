package visual;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Monedas extends JPanel {
    public Monedas(){
        this.setLayout(new GridLayout(1,4));
        this.setBackground(Color.DARK_GRAY);

        JButton Moneda100 = new JButton("$100");
        JButton Moneda500 = new JButton("$500");
        JButton Moneda1000 = new JButton("$1000");
        JButton Moneda1500 = new JButton("$1500");

        this.add(Moneda100);
        this.add(Moneda500);
        this.add(Moneda1000);
        this.add(Moneda1500);
        
    }
}
