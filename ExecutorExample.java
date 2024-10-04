import java.util.concurrent.ExecutorService; //Utilizacion de Bibliotecas
import java.util.concurrent.Executors; //Utilizacion de Bibliotecas

public class ExecutorExample {
    public static void main(String[] args) {
        // Crear un pool de hilos con un número fijo de hilos
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Crear y enviar varias tareas al Executor
        for (int i = 1; i <= 5; i++) {
            final int taskId = i; // Variable final para uso en la tarea
            executorService.submit(() -> {
                System.out.println("Tarea " + taskId + " en ejecución por " + Thread.currentThread().getName());
                try {
                    // Simular trabajo con un retraso
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Manejo de interrupciones
                }
                System.out.println("Tarea " + taskId + " completada por " + Thread.currentThread().getName());
            });
        }

        // Cerrar el ExecutorService
        executorService.shutdown();
    }
}
