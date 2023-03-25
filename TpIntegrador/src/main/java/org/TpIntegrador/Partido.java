package org.TpIntegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Partido {
    private Ronda ronda;
    private int golesEquipo1;
    private int golesEquipo2;
    private Equipo equipo1;
    private Equipo equipo2;


    public Partido(Ronda ronda,Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }



    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public static List<String> CapturarPartidoArchivo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la ruta del archivo con los resultados de los partidos: ");
        String rutaArchivo = scanner.nextLine();
//        String rutaArchivo = "C:\\Users\\Claudio\\Desktop\\AddMaven\\AddMaven\\src\\main\\java\\org\\Addmaven\\resultados.csv";
        List<String> lineas = Files.lines(Paths.get(rutaArchivo))
                .skip(1)  // saltar la primera línea
                .collect(Collectors.toList());
        return lineas;
    }

    public static Partido convertirLineaEnPartido(String lineas) {
        String[] datosPartido = lineas.split(";");
        Ronda ronda = new Ronda (Integer.parseInt(datosPartido[0]));
        Equipo equipo1 = new Equipo(datosPartido[1]);
        Equipo equipo2 = new Equipo(datosPartido[4]);
        int golesEquipo1 = Integer.parseInt(datosPartido[2]);
        int golesEquipo2 = Integer.parseInt(datosPartido[3]);
        return new Partido(ronda,equipo1, equipo2, golesEquipo1, golesEquipo2);
    }

    public static List<String> leerPartidos(List<String> lineas) {
        List<String> partidos = new ArrayList<>();
        for (int i = 0; i < lineas.size(); i++) {
            Partido partido = convertirLineaEnPartido(lineas.get(i));
            if (partido.golesEquipo1 > partido.golesEquipo2) {
                partidos.add(partido.getEquipo1().getNombre());
            } else if (partido.golesEquipo2 > partido.golesEquipo1) {
                partidos.add(partido.getEquipo2().getNombre());
            } else {
                partidos.add("empate");
            }
        }
        return partidos;
    }
}