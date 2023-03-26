package org.TpIntegrador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private String Persona;

    public static String[] CapturarPronosticosArchivo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la ruta del archivo con los pronósticos de los partidos: ");
        String rutaArchivo = scanner.nextLine();
//      String rutaArchivo = "C:\\Users\\Claudio\\Desktop\\Arg-Programa\\TpIntegrador\\src\\main\\java\\org\\TpIntegrador\\pronostico.csv";

        List<String> lineas = Files.lines(Paths.get(rutaArchivo))
                .skip(1)  // saltar la primera línea
                .collect(Collectors.toList());
        // Crear un ArrayList para almacenar los resultados de leerPronostico
        String[] resultados = new String[lineas.size()];
        // Procesar cada línea del archivo y almacenar el resultado en el ArrayList
        for (int i = 0; i < lineas.size(); i++) {
            String resultado = leerPronostico (Arrays.asList(lineas.get(i))).toString();
            resultados[i] = resultado;
        }
        return resultados;
    }

    /**
     * Este código fue utilizado en la anterior resolución (punto 1)
     */

    /**
     *     public static String leerPronostico(List <String> lineas) {
     *         for (String linea : lineas) {
     *             String[] datosPartido = linea.split(";");
     *             if (datosPartido[1].equals("x")) {
     *                 return datosPartido[0];
     *             } else if (datosPartido[2].equals("x")) {
     *                 return "empate";
     *             } else {
     *                 return datosPartido[4];
     *             }
     *         }
     *         return null;
     *     }
     */

    public static List<String> leerPronostico(List<String> lineas) {
        List<String> pronostico = new ArrayList<>();
        for (int i = 0; i < lineas.size(); i++) {
            String[] datosPartido = lineas.get(i).split(";");
            if (datosPartido[2].equals("x")) {
                pronostico.add(datosPartido[0]);
                pronostico.add(datosPartido[1]);
            } else if (datosPartido[3].equals("x")) {
                pronostico.add(datosPartido[0]);
                pronostico.add("empate");
            } else {
                pronostico.add(datosPartido[0]);
                pronostico.add(datosPartido[5]);
            }
        }
        return
                pronostico;
    }
}

