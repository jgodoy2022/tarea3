package visual;

import org.example.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(Expendedor expendedor){
        exp = new PanelExpendedor(expendedor);
        com = new PanelComprador(expendedor,exp);

        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        this.add(exp, BorderLayout.CENTER);
        this.add(com, BorderLayout.EAST);
    }
}
