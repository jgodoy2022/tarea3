package visual;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelComprador extends JPanel{
    private Expendedor expendedor;
    private Comprador comprador;
    private PanelExpendedor panelExpendedor;
    private int saldo = 0;
    public PanelComprador(Expendedor expendedor,PanelExpendedor panelExpendedor) {
        this.setLayout(new GridLayout(5,2));
        this.setBackground(Color.lightGray);

        this.panelExpendedor=panelExpendedor;
        this.expendedor = expendedor;

        JButton coca = new JButton("CocaCola");
        JLabel precioCoca = new JLabel("        $1000");
        JButton sprite = new JButton("Sprite");
        JLabel precioSprite = new JLabel("       $1000");
        JButton fanta = new JButton("Fanta");
        JLabel precioFanta = new JLabel("       $1000");
        JButton snickers = new JButton("Snickers");
        JLabel precioSnickers = new JLabel("        $700");
        JButton super8 = new JButton("Super8");
        JLabel precioSuper8 = new JLabel("        $500");
        this.add(coca);
        this.add(precioCoca);
        this.add(fanta);
        this.add(precioFanta);
        this.add(sprite);
        this.add(precioSprite);
        this.add(snickers);
        this.add(precioSnickers);
        this.add(super8);
        this.add(precioSuper8);

        coca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Realiza la compra
                    comprador = new Comprador(saldo, TipoProducto.COCA.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
                    panelExpendedor.iniciarCaidaProducto(TipoProducto.COCA);
                    saldo = 0;
                    panelExpendedor.reinicioPos();
                } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        sprite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Realiza la compra
                    comprador = new Comprador(saldo, TipoProducto.SPRITE.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
                    panelExpendedor.iniciarCaidaProducto(TipoProducto.SPRITE);
                    saldo = 0;
                    panelExpendedor.reinicioPos();
                } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        fanta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Realiza la compra
                    comprador = new Comprador(saldo, TipoProducto.FANTA.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
                    panelExpendedor.iniciarCaidaProducto(TipoProducto.FANTA);
                    saldo = 0;
                    panelExpendedor.reinicioPos();
                } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        snickers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Realiza la compra
                    comprador = new Comprador(saldo, TipoProducto.SNICKERS.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
                    panelExpendedor.iniciarCaidaProducto(TipoProducto.SNICKERS);
                    saldo = 0;
                    panelExpendedor.reinicioPos();
                } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        super8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Realiza la compra
                    comprador = new Comprador(saldo, TipoProducto.SUPER8.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
                    panelExpendedor.iniciarCaidaProducto(TipoProducto.SUPER8);
                    saldo = 0;
                    panelExpendedor.reinicioPos();
                } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void depositarMoneda(int m){
        saldo += m;
    }

}
