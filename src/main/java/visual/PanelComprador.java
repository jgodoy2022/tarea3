package visual;

import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**El Jpanel PanelComprador representa un panel que permite al usuario realizar compras en el expendedor, despues de ingresar las
 * monedas el comprador puede confirmar la compra
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 * */
public class PanelComprador extends JPanel{

    /** Referencia al expendedor para el almacenamiento de productos*/
    private Expendedor expendedor;

    /** Referencia al cliente para realizar la compra*/
    private Comprador comprador;

    /** Referencia al PanelExpendedor para mostrar los cambios realizados por las compras*/
    private PanelExpendedor panelExpendedor;

    /** Referencia al saldo del usuario*/
    private int saldo = 0;


    /**Constructor
     * Display de los botones de compra, realiza las compras de los productos
     * @param expendedor referencia al expendedor con el que se trabaja
     * @param panelExpendedor referencia al panel expendedor para la representacion grafica
     */
    public PanelComprador(Expendedor expendedor,PanelExpendedor panelExpendedor) {
        this.setLayout(new GridLayout(5,2));
        this.setBackground(Color.lightGray);

        this.panelExpendedor=panelExpendedor;
        this.expendedor = expendedor;
        //Botones
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

        //ActionListeners para realizar las compras
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

    /**
     * @param m valor de las monedas a a depositar
     */
    public void depositarMoneda(int m){
        saldo += m;
    }

}
