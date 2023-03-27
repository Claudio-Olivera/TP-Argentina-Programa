import java.io.IOException;

/**
 *Entrega 1
 * A partir del esquema original propuesto, desarrollar un programa que lea un archivo de
 * partidos y otro de resultados, el primero correspondiente a una ronda y el otro que contenga
 * los pronósticos de una persona.
 * El programa debe:
 * ● Se considera una única ronda y un único participante en esta entrega
 * ● Estar subido en un repositorio de GIT
 * ● Tomar como argumento 2 rutas a cada archivo que se necesita
 * ● Al leer las líneas de los archivos debe instanciar objetos de las clases propuestas
 * ● Debe imprimir por pantalla el puntaje de la persona
 * Importante
 * Se debe considerar la forma de identificar los partidos de forma unívoca para su correcto
 * procesamiento. Está permitido modificar la estructura del archivo si así lo considera.
 *
 * Leyendo los 2 (dos) archivos, y suponiendo que cada resultado acertado suma 1 (un) punto, la
 * salida del programa debe ser: Puntaje = 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
    Ronda.compararPartidosYPronosticos(Partido.leerPartidos((Partido.CapturarPartidoArchivo())),Pronostico.CapturarPronosticosArchivo());
    }
}

// C:\Users\Claudio\Desktop\TrabajoPracticoPrimeraEntrega\TrabajoPracticoPrimeraEntrega\src\resultados.csv
// C:\Users\Claudio\Desktop\TrabajoPracticoPrimeraEntrega\TrabajoPracticoPrimeraEntrega\src\pronostico.csv