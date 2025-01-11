import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartaFrame extends JFrame {
    private Cliente cliente;
    private Mesa mesa;

    public CartaFrame(Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
        this.mesa = mesa;

        setTitle("Carta");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1, 10, 10));

        JLabel label = new JLabel("Seleccione un plato de la carta:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

        String[] platos = {
                "1. Sopa de marisco (6$)",
                "2. Cocido (5$)",
                "3. Gambas al ajillo (6$)",
                "4. Tortilla de patata (12$)",
                "5. Cachopo (20$)",
                "6. Tarta de queso (3.5$)",
                "7. Coulant de chocolate (3$)"
        };

        for (String plato : platos) {
            JButton botonPlato = new JButton(plato);
            botonPlato.addActionListener(e -> {
                cliente.agregarPedido(plato);
                int continuar = JOptionPane.showConfirmDialog(this, "¿Desea seguir pidiendo?");
                if (continuar != JOptionPane.YES_OPTION) {
                    abrirCocina();
                }
            });
            add(botonPlato);
        }
    }

    private void abrirCocina() {
        CocinaFrame cocinaFrame = new CocinaFrame(cliente, mesa);
        cocinaFrame.setVisible(true);
        this.dispose();
    }
}
