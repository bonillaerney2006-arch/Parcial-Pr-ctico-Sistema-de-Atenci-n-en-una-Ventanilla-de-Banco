import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Queue<Cliente> cola = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE COLA DEL BANCO ===");
            System.out.println("1. Agregar cliente (tomar turno)");
            System.out.println("2. Atender siguiente cliente");
            System.out.println("3. Ver próximo cliente en espera");
            System.out.println("4. Mostrar todos los clientes en cola");
            System.out.println("5. Consultar cantidad de clientes en espera");
            System.out.println("6. Vaciar la cola");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agregarCliente();
                case 2 -> atenderCliente();
                case 3 -> verProximo();
                case 4 -> mostrarTodos();
                case 5 -> System.out.println("Clientes en espera: " + cola.size());
                case 6 -> { cola.clear(); System.out.println("Cola vaciada."); }
                case 7 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    static void agregarCliente() {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese identificación: ");
        String id = sc.nextLine();

        System.out.print("Tipo de transacción (Depósito/Retiro/Consulta/Pago): ");
        String tipo = sc.nextLine();

        System.out.print("Hora de llegada (HH:MM): ");
        LocalTime hora = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));

        cola.offer(new Cliente(nombre, id, tipo, hora));
        System.out.println("Cliente agregado a la cola.");
    }

    static void atenderCliente() {
        if (cola.isEmpty()) {
            System.out.println("Error: No hay clientes en espera.");
        } else {
            System.out.println("Atendiendo a: " + cola.poll());
        }
    }

    static void verProximo() {
        if (cola.isEmpty()) {
            System.out.println("Error: No hay clientes en espera.");
        } else {
            System.out.println("Próximo: " + cola.peek());
        }
    }

    static void mostrarTodos() {
        if (cola.isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            int turno = 1;
            for (Cliente c : cola) {
                System.out.println("#" + turno++ + " " + c);
            }
        }
    }
}
