package visual;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(){
        com = new PanelComprador();
        exp = new PanelExpendedor();
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        this.add(exp, BorderLayout.CENTER);
        this.add(com, BorderLayout.EAST);
    }
}
