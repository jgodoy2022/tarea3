package visual;

import org.example.Expendedor;

import javax.swing.*;
import java.awt.*;

/**
 * El Jframe ventana representa la ventana de la interfaz grafica, se utiliza para poder mostrar la interfaz grafica del codigo
 * @author Gabriela Isidora Zambrano Novoa
 * @author Joaquin Alejandro Godoy Vergara
 */
public class Ventana extends JFrame {
    /** Referencia de al panel principal el cual contiene a el resto de paneles*/
    private PanelPrincipal mypanel;

    /** Referencia al expendedor utilizado en la venta*/
    private Expendedor expendedor;

    /**
     * Constructor inicializa la ventana y configura sus propiedades
     */
    public Ventana(){
        expendedor=new Expendedor(6);
        mypanel = new PanelPrincipal(expendedor);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.add(mypanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
