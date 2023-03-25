package org.TpIntegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private String Persona;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado, String persona) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        Persona = persona;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public static String[] CapturarPronosticosArchivo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la ruta del archivo con los pronósticos de los partidos: ");
        String rutaArchivo = scanner.nextLine();
//        String rutaArchivo = "C:\\Users\\Claudio\\Desktop\\AddMaven\\AddMaven\\src\\main\\java\\org\\Addmaven\\pronostico.csv";

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

//    public static String leerPronostico(List <String> lineas) {
//        for (int i = 0; i < lineas.size(); i++) {
//            String[] datosPartido = lineas.get(i).split(";");
//            if (datosPartido[2].equals("x")) {
//                return datosPartido[0] +";"+ datosPartido[1];
//            } else if (datosPartido[3].equals("x")) {
//                return "empate";
//            } else {
//                return datosPartido[5];
//            }
//        }
//        return null;
//    }

    public static List<String> leerPronostico(List<String> lineas) {
        List<String> pronostico = new ArrayList<String>();
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

