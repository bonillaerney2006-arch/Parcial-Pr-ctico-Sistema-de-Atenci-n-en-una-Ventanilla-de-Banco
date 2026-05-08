import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class ColaTest {

    static int pruebas = 0;
    static int exitosas = 0;

    public static void main(String[] args) {
        Queue<Cliente> cola = new LinkedList<>();

       
        probar("Cola nueva está vacía", cola.isEmpty());
        Cliente ana = new Cliente("Ana", "12345678", "Depósito", LocalTime.of(10, 30));
        Cliente luis = new Cliente("Luis", "87654321", "Retiro", LocalTime.of(10, 45));
        cola.offer(ana);
        cola.offer(luis);
        probar("Tamaño es 2 tras encolar dos clientes", cola.size() == 2);
        Cliente atendido = cola.poll();
        probar("Sale Ana primero (FIFO)", atendido.getNombre().equals("Ana"));
        probar("Tamaño es 1 tras atender", cola.size() == 1);

        cola.peek();
        probar("peek no elimina (tamaño sigue en 1)", cola.size() == 1);

        
        cola.clear();
        probar("Cola vacía tras clear()", cola.isEmpty());

        
        System.out.println("\n── Resultado: " + exitosas + "/" + pruebas + " pruebas exitosas ──");
    }

    static void probar(String nombre, boolean condicion) {
        pruebas++;
        if (condicion) {
            exitosas++;
            System.out.println("✔  " + nombre);
        } else {
            System.out.println("✖  FALLÓ: " + nombre);
        }
    }
}
