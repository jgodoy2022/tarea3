package visual;

import org.example.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    private Monedas mon;

    public PanelPrincipal(Expendedor expendedor){
        exp = new PanelExpendedor(expendedor, mon);
        com = new PanelComprador(expendedor,exp);
        mon = new Monedas(exp);


        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        this.add(exp, BorderLayout.CENTER);
        this.add(com, BorderLayout.EAST);
        this.add(mon, BorderLayout.SOUTH);
    }
}
