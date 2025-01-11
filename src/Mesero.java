import java.util.List;

public class Mesero extends Persona {
    private CocinaFrame cocinero;

    public Mesero(CocinaFrame cocinero) {
        super();
        this.cocinero = cocinero;
    }

    // Método para atender la mesa y pasar pedidos al cocinero
    public void atenderMesa(Mesa mesa) {
        Cliente cliente = mesa.getCliente();
        if (cliente != null) {
            List<String> pedidos = cliente.getPedidos();
            if (!pedidos.isEmpty()) {
                System.out.println("Mesero: Registrando pedidos para la mesa " + mesa.getNumero());
                mesa.registrarPedidos(pedidos);

                System.out.println("Mesero: Entregando pedidos al cocinero.");
                cocinero.cocinar(pedidos);

                System.out.println("Mesero: Entregando los platos a la mesa " + mesa.getNumero());
                mesa.entregarPlatos();
            } else {
                System.out.println("Mesero: El cliente de la mesa " + mesa.getNumero() + " no hizo pedidos.");
            }
        } else {
            System.out.println("Mesero: No hay cliente asignado a la mesa " + mesa.getNumero());
        }
    }
}
