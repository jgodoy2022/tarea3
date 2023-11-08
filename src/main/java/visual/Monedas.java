package visual;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * El Jpanel Monedas representa un panel que permite al usuario ingresar monedas para poder realizar compras
 * permite ingresar monedas de distintos valores y se asocia al resto de paneles para poder realiar las compras
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 */
public class Monedas extends JPanel{

    /** Referencia al PanelExpendedor para mostrar visualmente las monedas*/
    private PanelExpendedor panelExpendedor;

    /** Referencia al PanelComprador para registrar las monedas utilizadas y realizar las transacciones*/
    private PanelComprador panelComprador;

    /** Constructor de la clase
     * Dislpay de los botones de la clase
     *
     * @param PanelExpendedor panel del expendedor para poder mostrar las monedas ingresadas
     * @param PanelComprador panel del comprador para poder registrar y realizar las compras
     */
    public Monedas(PanelExpendedor PanelExpendedor, PanelComprador PanelComprador){
        this.panelExpendedor = PanelExpendedor;
        this.panelComprador = PanelComprador;
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.DARK_GRAY);

        GridBagConstraints constraints = new GridBagConstraints();
        //Botones
        JButton Moneda100 = new JButton("$100");
        JButton Moneda500 = new JButton("$500");
        JButton Moneda1000 = new JButton("$1000");
        JButton Moneda1500 = new JButton("$1500");

        //Ubicacion de los botones
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

        //ActionListener para insertar/pintar las monedas
        Moneda100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelExpendedor.PaintMoneda(Color.YELLOW);
                panelComprador.depositarMoneda(100);
            }
        });

        Moneda500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelExpendedor.PaintMoneda(Color.GREEN);
                panelComprador.depositarMoneda(500);
            }
        });

        Moneda1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelExpendedor.PaintMoneda(Color.RED);
                panelComprador.depositarMoneda(1000);
            }
        });

        Moneda1500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelExpendedor.PaintMoneda(Color.BLUE);
                panelComprador.depositarMoneda(1500);
            }
        });
    }

}
