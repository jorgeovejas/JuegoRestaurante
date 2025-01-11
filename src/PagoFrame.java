import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PagoFrame extends JFrame {
    private Cliente cliente;
    private Mesa mesa;

    public PagoFrame(Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
        this.mesa = mesa;

        setTitle("Pago");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel totalLabel = new JLabel("Calculando el total...");
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(totalLabel, BorderLayout.CENTER);

        // Calcular el total
        double total = calcularTotal(cliente.getPedidos());
        totalLabel.setText("El total de la mesa " + mesa.getNumero() + " es: $" + total);

        JButton finalizarButton = new JButton("Finalizar");
        finalizarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pago realizado con éxito.");
            System.exit(0);
        });

        add(finalizarButton, BorderLayout.SOUTH);
    }
//Calcular el pago total de la mesa
    private double calcularTotal(List<String> pedidos) {
        double total = 0.0;
        for (String plato : pedidos) {
            switch (plato) {
                case "1. Sopa de marisco (6$)":
                    total += 6.0;
                    break;
                case "2. Cocido (5$)":
                    total += 5.0;
                    break;
                case "3. Gambas al ajillo (6$)":
                    total += 6.0;
                    break;
                case "4. Tortilla de patata (12$)":
                    total += 12.0;
                    break;
                case "5. Cachopo (20$)":
                    total += 20.0;
                    break;
                case "6. Tarta de queso (3.5$)":
                    total += 3.5;
                    break;
                case "7. Coulant de chocolate (3$)":
                    total += 3.0;
                    break;
            }
        }
        return total;
    }
}
