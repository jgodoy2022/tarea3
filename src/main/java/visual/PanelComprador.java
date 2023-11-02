package visual;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelComprador extends JPanel{
    private Expendedor expendedor;
    private Comprador comprador;
    private PanelExpendedor PanelExpendedor;
    public PanelComprador(Expendedor expendedor, PanelExpendedor Exp) {
        this.setLayout(new GridLayout(5,2));

        this.expendedor = expendedor;
        this.PanelExpendedor = Exp;

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
        this.add(sprite);
        this.add(precioSprite);
        this.add(fanta);
        this.add(precioFanta);
        this.add(snickers);
        this.add(precioSnickers);
        this.add(super8);
        this.add(precioSuper8);

        coca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Realiza la compra
                    comprador = new Comprador(new Moneda1000(), TipoProducto.COCA.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
                    coca.addActionListenerForImage(PanelExpendedor.getCoca());
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
                    comprador = new Comprador(new Moneda1000(), TipoProducto.SPRITE.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
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
                    comprador = new Comprador(new Moneda1000(), TipoProducto.FANTA.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
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
                    comprador = new Comprador(new Moneda1000(), TipoProducto.SNICKERS.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
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
                    comprador = new Comprador(new Moneda1000(), TipoProducto.SUPER8.getOpcion(), expendedor);
                    // Actualiza la interfaz o muestra el resultado
                    JOptionPane.showMessageDialog(null, "Compraste " + comprador.queCompraste() + " con un vuelto de $" + comprador.cuantoVuelto());
                } catch (NoHayProductoException | PagoInsuficienteException | PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}
