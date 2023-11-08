package visual;

import org.example.Expendedor;

import javax.swing.*;
import java.awt.*;
/**El Jpanel PanelPrincipal combina y organiza los componentes visuales de el expendedor, el comprador y las monedas
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 */
public class PanelPrincipal extends JPanel {

    /** Referencia al PanelComprador para posicion de los botones de compra*/
    private PanelComprador com;

    /** Referencia al PanelExpendedor para el diseño del expendedor y visualizacion de compra*/
    private PanelExpendedor exp;

    /** Referencua a Monedas para el ingreso de monedas*/
    private Monedas mon;

    /**
     * Constructor Contiene a los 3 paneles para orden y uso de cada uno
     * @param expendedor Objeto Expendedor que representa el expendedor de productos.
     */
    public PanelPrincipal(Expendedor expendedor){
        exp = new PanelExpendedor(expendedor, mon);
        com = new PanelComprador(expendedor,exp);
        mon = new Monedas(exp,com);


        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        this.add(exp, BorderLayout.CENTER);
        this.add(com, BorderLayout.EAST);
        this.add(mon, BorderLayout.SOUTH);
    }
}
