import java.util.Scanner;

public class Persona {
    private int id;
    private int edad;
    private String nombre;

    public void identificacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu ID: ");
        this.id = scanner.nextInt();

        System.out.print("Introduce tu edad: ");
        this.edad = scanner.nextInt();

        System.out.print("Introduce tu nombre: ");
        scanner.nextLine(); // Consumir el salto de línea
        this.nombre = scanner.nextLine();
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}
