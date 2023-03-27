import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * No se usan los atributos resultado, ni partido, los mantengo declarados para posible futuro uso y/o modificación de este código.
 * */

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }
    public Equipo getEquipo() {
        return equipo;
    }

    public static String[] CapturarPronosticosArchivo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la ruta del archivo con los pronósticos de los partidos: ");
        String rutaArchivo = scanner.nextLine();

        List<String> lineas = Files.lines(Paths.get(rutaArchivo))
                .skip(1)  // saltar la primera línea (Ya que son los títulos del excel)
                .collect(Collectors.toList());
        // Guarda los datos de leerPronostico en un Array
        String[] resultados = new String[lineas.size()];

        // A cada línea del archivo la guarda en el Array
        for (int i = 0; i < lineas.size(); i++) {
            //Llamada al método leerPronostico(List <String> lineas) y guardo el valor correspondiente a la línea que se está iterando en variable de tipo String.
            // Ya que leerPronostico() espera una lista uso Arrays.asList() convierte una matriz (array) en una lista de objetos.
            String resultado = leerPronostico(Arrays.asList(lineas.get(i)));
            // La posición será el número que tenga i, asi le da el valor de resultado a esa posición.
            resultados[i] = resultado;
        }
        // Devuelve el array de tipo String "resultados", necesario para el parámetro de Ronda.compararPartidosYPronosticos();
        return resultados;
    }

    /**
     * Explicación de la función leerPronostico() declarada abajo.
     *
     * Para resolver el problema de comparar los archivos, comprobaré que nombre está más cerca de "x", ya que
     * usaré el nombre de equipo más cercano a "x", si está en el medio de las posiciones del array corresponderá a empate [0,1,2,3,4]
     *
     * Donde 0 es el nombre del primer equipo.
     * Donde 1 puede contener una "x" (favorable al equipo 1).
     * Donde 2 es "empate", ya que si hay una "x" aquí quiere decir que quien marco la "x" lo hizo al medio.
     * Donde 3 puede contener una "x" (favorable al equipo 2).
     * Donde 4 es el nombre del segundo equipo.
     *
     * El return que arroje este método será con lo que trabaje el método CapturarPronosticosArchivo() de esta clase.
     *
     * @param lineas
     * @return
     */
    public static String leerPronostico(List <String> lineas) {
        for (String linea : lineas) {
            String[] datosPartido = linea.split(";");
            if (datosPartido[1].equals("x")) {
                return datosPartido[0];
            } else if (datosPartido[2].equals("x")) {
                return "empate";
            } else {
                return datosPartido[4];
            }
        }
        return null;
    }


}