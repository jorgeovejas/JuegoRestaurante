import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<String> pedidos;
    private int numeroPersonas;

    public Cliente(String id, String nombre, int edad) {
        pedidos = new ArrayList<>();
    }

    public void identificacionGUI(Runnable onComplete) {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField idField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField personasField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Edad:"));
        panel.add(edadField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Número de personas:"));
        panel.add(personasField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Datos del Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                setId(Integer.parseInt(idField.getText()));
                setEdad(Integer.parseInt(edadField.getText()));
                setNombre(nombreField.getText());
                numeroPersonas = Integer.parseInt(personasField.getText());
                onComplete.run();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce datos válidos.");
            }
        }
    }

    private void setNombre(String text) {
    }

    private void setEdad(int i) {
    }
    
    private void setId(int i) {
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void agregarPedido(String plato) {
        pedidos.add(plato);
    }

    public List<String> getPedidos() {
        return pedidos;
    }

    public void preguntar() {
    }
}
