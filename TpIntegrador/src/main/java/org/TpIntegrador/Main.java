package org.TpIntegrador;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Ronda.compararPartidosYPronosticos(Partido.leerPartidos((Partido.CapturarPartidoArchivo())), List.of(Pronostico.CapturarPronosticosArchivo()));
    }
}

//              C:\Users\Claudio\Desktop\AddMaven\AddMaven\src\main\java\org\Addmaven\resultados.csv
//              C:\Users\Claudio\Desktop\AddMaven\AddMaven\src\main\java\org\Addmaven\pronostico.csv
