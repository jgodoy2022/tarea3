package visual;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Monedas extends JPanel {

    private JLabel serieLabel;
    private PanelExpendedor PanelExpendedor;
    public Monedas(PanelExpendedor PanelExpendedor){
        this.PanelExpendedor = PanelExpendedor;
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.DARK_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();

        JButton Moneda100 = new JButton("$100");
        JButton Moneda500 = new JButton("$500");
        JButton Moneda1000 = new JButton("$1000");
        JButton Moneda1500 = new JButton("$1500");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(Moneda100, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(Moneda500, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(Moneda1000, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(Moneda1500, constraints);

        Moneda100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelExpendedor.PaintMoneda100(getGraphics());
            }
        });

        Moneda500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelExpendedor.PaintMoneda500(getGraphics());
            }
        });

        Moneda1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelExpendedor.PaintMoneda1000(getGraphics());
            }
        });

        Moneda1500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelExpendedor.PaintMoneda1500(getGraphics());
            }
        });
    }

}
