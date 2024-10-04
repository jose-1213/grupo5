//antes de java 1.5
public class TimeMeasurement {// Utilizacion de la Biblioteca
    public static void main(String[] args) {
        // Obtener el tiempo inicial en milisegundos
        long startTime = System.currentTimeMillis();

        // Código cuya ejecución vamos a medir
        long sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum += i;
        }

        // Obtener el tiempo final en milisegundos
        long endTime = System.currentTimeMillis();

        // Calcular la duración
        long duration = endTime - startTime;

        // Mostrar los resultados
        System.out.println("Resultado de la suma: " + sum);
        System.out.println("Tiempo de ejecución: " + duration + " milisegundos");
    }
}
