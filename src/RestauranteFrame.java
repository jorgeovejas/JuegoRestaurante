import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RestauranteFrame extends JFrame {
    private List<Mesa> mesas = new ArrayList<>();
    private Cliente cliente;

    public RestauranteFrame() {
        setTitle("Restaurante - Distribución de Mesas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 5, 10, 10));

        // Creamos las mesas aqui
        for (int i = 1; i <= 10; i++) {
            int capacidad = (i <= 2) ? 2 : (i <= 6) ? 4 : 6;
            mesas.add(new Mesa(i, capacidad));
        }

        // Dibujamos las mesas aqui
        for (Mesa mesa : mesas) {
            JButton botonMesa = new JButton("Mesa " + mesa.getNumero() + " (" + mesa.getCapacidad() + ")");
            botonMesa.setBackground(Color.GREEN);

            botonMesa.addActionListener(e -> asignarMesa(mesa, botonMesa));
            add(botonMesa);
        }
    }

    private void asignarMesa(Mesa mesa, JButton botonMesa) {
        String id = JOptionPane.showInputDialog(this, "Ingrese su ID:");
        String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese su edad:"));
        int numPersonas = Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuántas personas son?"));

        cliente = new Cliente(id, nombre, edad);

        // Verificar si la mesa seleccionada tiene capacidad suficiente
        if (mesa.getCapacidad() >= numPersonas && !mesa.isOcupada()) {
            mesa.setOcupada(true);
            mesa.setCliente(cliente);
            botonMesa.setBackground(Color.RED);

            JOptionPane.showMessageDialog(this, "Mesa " + mesa.getNumero() + " asignada.");
            abrirCarta(mesa);
        } else {
            // En caso contrario se buscan mas mesas para que combinadas quepa el grupo
            int totalCapacidad = 0;
            List<Mesa> mesasCombinadas = new ArrayList<>();

            for (Mesa m : mesas) {
                if (!m.isOcupada()) {
                    totalCapacidad += m.getCapacidad();
                    mesasCombinadas.add(m);

                    if (totalCapacidad >= numPersonas) {
                        break;
                    }
                }
            }

            if (totalCapacidad >= numPersonas) {
                for (Mesa m : mesasCombinadas) {
                    m.setOcupada(true);
                    m.setCliente(cliente);

                    JButton boton = (JButton) getContentPane().getComponent(m.getNumero() - 1);
                    boton.setBackground(Color.RED);
                }

                JOptionPane.showMessageDialog(this, "Mesas combinadas asignadas.");
                abrirCarta(mesa);
            } else {
                JOptionPane.showMessageDialog(this, "No hay mesas suficientes para el grupo.");
            }
        }
    }

    private void abrirCarta(Mesa mesa) {
        CartaFrame cartaFrame = new CartaFrame(cliente, mesa);
        cartaFrame.setVisible(true);
        this.dispose();
    }
}
