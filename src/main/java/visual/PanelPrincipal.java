package visual;

import org.example.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(Expendedor expendedor){
<<<<<<< HEAD
        com = new PanelComprador(expendedor, exp);
=======
>>>>>>> fb6a800b8b76d891069e1b3a93f3a32a2a6a4864
        exp = new PanelExpendedor(expendedor);
        com = new PanelComprador(expendedor,exp);

        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        this.add(exp, BorderLayout.CENTER);
        this.add(com, BorderLayout.EAST);
    }
}
