//Despues de Java 1.5
public class NanoTimeMeasurement {// Utilizacion de la biblioteca 
    public static void main(String[] args) {
        // Obtener el tiempo inicial en nanosegundos
        long startTime = System.nanoTime();

        // Código cuya ejecución vamos a medir
        long sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum += i;
        }

        // Obtener el tiempo final en nanosegundos
        long endTime = System.nanoTime();

        // Calcular la duración en nanosegundos
        long duration = endTime - startTime;

        // Convertir el tiempo de nanosegundos a milisegundos para hacerlo más legible
        double durationInMillis = duration / 1_000_000.0;

        // Mostrar los resultados
        System.out.println("Resultado de la suma: " + sum);
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
        System.out.println("Tiempo de ejecución: " + durationInMillis + " milisegundos");
    }
}
