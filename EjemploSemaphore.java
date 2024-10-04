import java.util.concurrent.Semaphore;

public class EjemploSemaphore {
    public static void main(String[] args) {
        // Creación de un semáforo con 3 permisos
        Semaphore semaforo = new Semaphore(3);

        // Se crean y lanzan 10 hilos que ejecutarán la tarea
        for (int i = 0; i < 10; i++) {
            new Thread(new Tarea(semaforo)).start();
        }
    }
}

class Tarea implements Runnable {
    private Semaphore semaforo;

    // Constructor que recibe el semáforo
    public Tarea(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            // Adquirir un permiso del semáforo
            semaforo.acquire();
            System.out.println(Thread.currentThread().getName() + " está accediendo al recurso.");

            // Simulación de uso del recurso (espera de 2 segundos)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Liberar el permiso del semáforo
            System.out.println(Thread.currentThread().getName() + " ha liberado el recurso.");
            semaforo.release();
        }
    }
}