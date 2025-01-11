import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CocinaFrame extends JFrame {
    private Cliente cliente;
    private Mesa mesa;
    private List<String> pedidos;
    private int index = 0;

    public CocinaFrame(Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.pedidos = cliente.getPedidos();

        setTitle("Cocina");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel estadoLabel = new JLabel("Preparando los platos...");
        estadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(estadoLabel, BorderLayout.CENTER);

        Timer timer = new Timer(3000, e -> {
            if (index < pedidos.size()) {
                estadoLabel.setText("Plato entregado: " + pedidos.get(index));
                index++;
            } else {
                ((Timer) e.getSource()).stop();
                abrirPago();
            }
        });

        timer.start();
    }

    private void abrirPago() {
        PagoFrame pagoFrame = new PagoFrame(cliente, mesa);
        pagoFrame.setVisible(true);
        this.dispose();
    }

    public void cocinar(List<String> pedidos) {
    }
}
