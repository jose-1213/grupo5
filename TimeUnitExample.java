import java.util.concurrent.TimeUnit; // Biblioteca TimeUnit

public class TimeUnitExample {
    public static void main(String[] args) {
        // Especificar un intervalo de tiempo en segundos
        long delayInSeconds = 5;

        // Usar TimeUnit para convertir segundos a milisegundos
        long delayInMillis = TimeUnit.SECONDS.toMillis(delayInSeconds);

        System.out.println("Esperando por " + delayInSeconds + " segundos...");
        
        // Pausar la ejecución usando TimeUnit
        try {
            TimeUnit.MILLISECONDS.sleep(delayInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar el tiempo en diferentes unidades
        System.out.println("Tiempo de espera en milisegundos: " + delayInMillis);
        System.out.println("Tiempo de espera en microsegundos: " + TimeUnit.SECONDS.toMicros(delayInSeconds));
        System.out.println("Tiempo de espera en nanosegundos: " + TimeUnit.SECONDS.toNanos(delayInSeconds));
        System.out.println("Tiempo de espera en minutos: " + TimeUnit.SECONDS.toMinutes(delayInSeconds));
    }
}
