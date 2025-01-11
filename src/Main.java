import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RestauranteFrame restaurante = new RestauranteFrame();
            restaurante.setVisible(true);
        });
    }
}
