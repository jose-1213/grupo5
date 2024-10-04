import java.util.concurrent.BrokenBarrierException; //Utilizacion de las Bibliotecas
import java.util.concurrent.CyclicBarrier;//Utilizacion de las Bibliotecas

public class CyclicBarrierExample {

    public static void main(String[] args) {
        // Definir el número de hilos que participarán
        final int numberOfThreads = 3;

        // Crear un CyclicBarrier que requiere que todos los hilos lleguen
        // y define una acción que se ejecutará cuando todos lleguen
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("=== Todos los hilos han llegado a la barrera. ===");
            System.out.println("Continuando con la siguiente fase...");
        });

        // Iniciar hilos
        for (int i = 1; i <= numberOfThreads; i++) {
            final int threadId = i; // Variable final para uso en el hilo
            new Thread(() -> {
                try {
                    // Simular trabajo
                    System.out.println("Hilo " + threadId + " en ejecución.");
                    // Simular un trabajo de tiempo variable
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println("Hilo " + threadId + " ha llegado a la barrera.");

                    // Esperar en la barrera
                    barrier.await(); // Cada hilo espera en la barrera

                    // Continuar después de que todos han llegado
                    System.out.println("Hilo " + threadId + " ha pasado la barrera y continúa su trabajo.");
                } catch (InterruptedException e) {
                    // Manejar interrupciones adecuadamente
                    Thread.currentThread().interrupt();
                    System.out.println("Hilo " + threadId + " fue interrumpido.");
                } catch (BrokenBarrierException e) {
                    System.out.println("La barrera fue rota. Hilo " + threadId + " no puede continuar.");
                }
            }).start();
        }
    }
}
