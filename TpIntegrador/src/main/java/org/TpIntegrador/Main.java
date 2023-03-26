package org.TpIntegrador;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Ronda.compararPartidosYPronosticos(Partido.leerPartidos((Partido.CapturarPartidoArchivo())), List.of((Pronostico.CapturarPronosticosArchivo())));
    }
}

//              C:\Users\Claudio\Desktop\Arg-Programa\TpIntegrador\src\main\java\org\TpIntegrador\resultados.csv
//              C:\Users\Claudio\Desktop\Arg-Programa\TpIntegrador\src\main\java\org\TpIntegrador\pronostico.csv
