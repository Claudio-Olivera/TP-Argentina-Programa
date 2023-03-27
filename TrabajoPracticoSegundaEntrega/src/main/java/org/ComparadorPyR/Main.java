package org.ComparadorPyR;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Ronda.compararPartidosYPronosticos(Partido.leerPartidos((Partido.CapturarPartidoArchivo())), List.of((Pronostico.CapturarPronosticosArchivo())));
    }
}

//              C:\Users\Claudio\Desktop\TrabajoPracticoIntegrador\src\main\java\org\ComparadorPyR\resultados.csv

//              C:\Users\Claudio\Desktop\TrabajoPracticoIntegrador\src\main\java\org\ComparadorPyR\pronostico.csv
