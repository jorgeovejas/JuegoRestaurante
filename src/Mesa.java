import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numero;
    private int capacidad;
    private boolean ocupada;
    private Cliente cliente;
    private List<String> pedidos;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.ocupada = false;
        this.pedidos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
        this.ocupada = true;
        System.out.println("Mesa " + numero + ": Cliente asignado.");
    }

    public void tomarPedidos() {
        if (cliente == null) {
            System.out.println("Mesa " + numero + ": No hay cliente asignado.");
            return;
        }
        System.out.println("Mesa " + numero + ": Mostrando carta al cliente.");
        cliente.preguntar();
        pedidos = cliente.getPedidos();
    }

    public void entregarPlatos() {
        if (pedidos.isEmpty()) {
            System.out.println("Mesa " + numero + ": No hay platos para entregar.");
        } else {
            System.out.println("Mesa " + numero + ": Entregando platos: " + pedidos);
            pedidos.clear();
        }
    }

    public void liberarMesa() {
        this.cliente = null;
        this.pedidos.clear();
        this.ocupada = false;
        System.out.println("Mesa " + numero + ": Ha sido liberada.");
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public int getNumero() {
        return numero;
    }

    public void registrarPedidos(List<String> pedidos) {
    }

    public void setOcupada(boolean b) {
    }

    public void setCliente(Cliente cliente) {
    }
}
