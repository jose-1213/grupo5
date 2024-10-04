import java.util.concurrent.CountDownLatch; // utilizacion de la Biblioteca

public class CountDownLatchExample {

    public static void main(String[] args) {
        // Definir el número de tareas que deben completarse
        final int numberOfTasks = 5;
        
        // Crear un CountDownLatch con el número de tareas
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        // Iniciar las tareas en hilos separados
        for (int i = 1; i <= numberOfTasks; i++) {
            int taskId = i; // Variable final para uso en el hilo
            new Thread(() -> {
                try {
                    // Simular trabajo que toma tiempo
                    System.out.println("Tarea " + taskId + " en ejecución.");
                    Thread.sleep((long) (Math.random() * 1000)); // Simula tiempo variable de trabajo
                    System.out.println("Tarea " + taskId + " completada.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Manejar interrupciones adecuadamente
                } finally {
                    // Reducir el contador del latch cuando la tarea se completa
                    latch.countDown();
                }
            }).start();
        }

        try {
            // Esperar hasta que todas las tareas hayan completado
            latch.await();
            System.out.println("Todas las tareas han sido completadas. Continuando con el proceso principal...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Manejar interrupciones adecuadamente
            System.out.println("El hilo principal fue interrumpido.");
        }
    }
}
