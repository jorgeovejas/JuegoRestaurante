import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orden {
    private Map<Integer, String> historialPedidos;

    public Orden() {
        this.historialPedidos = new HashMap<>();
    }

    // Registrar los pedidos de una mesa
    public void registrarPedido(int numeroMesa, List<String> pedidos, List<Integer> numerosDePlatos) {
        StringBuilder historial = new StringBuilder();

        // Construir el historial con nombres y números
        historial.append("Platos: ").append(pedidos);
        historial.append(" (").append(numerosDePlatos.toString().replaceAll("[\\[\\]]", "")).append(")");

        historialPedidos.put(numeroMesa, historial.toString());
        System.out.println("Orden: Pedido registrado para la mesa " + numeroMesa);
    }

    // Mostrar el historial completo
    public void mostrarHistorial() {
        System.out.println("Historial de pedidos:");
        for (Map.Entry<Integer, String> entry : historialPedidos.entrySet()) {
            System.out.println("Mesa " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
