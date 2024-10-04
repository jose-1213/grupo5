import java.util.concurrent.ArrayBlockingQueue;// utilizacion de la Biblioteca
import java.util.concurrent.BlockingQueue;// utilizacion de la Biblioteca

public class BlockingQueueExample {

    // Definimos el tamaño de la cola
    private static final int QUEUE_CAPACITY = 5; // Capacidad máxima de la cola
    
    public static void main(String[] args) {
        // Crear una BlockingQueue con capacidad fija
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        // Crear y empezar el productor
        Thread producer = new Thread(new Producer(queue));
        producer.start();

        // Crear y empezar el consumidor
        Thread consumer = new Thread(new Consumer(queue));
        consumer.start();
    }
}

// Clase del Productor
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    // Constructor que recibe la cola
    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // El productor generará 10 elementos
            for (int i = 1; i <= 10; i++) {
                System.out.println("Productor: produciendo " + i);
                queue.put(i); // Añadir a la cola, bloquea si la cola está llena
                System.out.println("Productor: " + i + " añadido a la cola.");
                Thread.sleep(500); // Simular tiempo de producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Manejo de interrupciones
            System.out.println("Productor interrumpido.");
        }
    }
}

// Clase del Consumidor
class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    // Constructor que recibe la cola
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // El consumidor consumirá 10 elementos
            for (int i = 1; i <= 10; i++) {
                Integer value = queue.take(); // Retirar de la cola, bloquea si está vacía
                System.out.println("Consumidor: consumiendo " + value);
                Thread.sleep(1000); // Simular tiempo de consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Manejo de interrupciones
            System.out.println("Consumidor interrumpido.");
        }
    }
}
