import java.util.List;

/**
 * Modificaciones en clase Ronda, no hace uso de sus atributos, podrían utilizarse a futuro o bien cambiar los métodos.
 * */

public class Ronda {
    private int nro;
    private Partido[] partidos;
    public Ronda(int nro, Partido[] partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }
    public int getNro() {
        return nro;
    }
    public Partido[] getPartidos() {
        return partidos;
    }


    public static void mostrarEquipoGanador(List<String> partidos) {
        for (String equipoGanador : partidos) {
            if (equipoGanador != "empate") {
                System.out.println("Ganador del partido: " + equipoGanador);
            }else{
                System.out.println( "El partido termino en empate" );
            }
        }
    }

    public static void mostrarPronosticos(String[] pronosticos) {
        for (String pronostico : pronosticos){
            System.out.println(pronostico);
        }
    }

    //Aca busco crear un método que tome una lista de partidos como la de arriba y una lista de pronósticos(a ser creada)
    // y que con esos datos haga la comparación y entregue los puntos.
    public static void compararPartidosYPronosticos(List<String> partidos, String[] pronosticos) {
        int puntos = 0;
        for (int i = 0; i < partidos.size(); i++) {
            String equipoGanador = partidos.get(i);
            String pronostico = pronosticos[i];
            if (equipoGanador.equals(pronostico)) {
                puntos +=1 ;
            }
        }
        System.out.println("Puntos ganados: " + puntos);
    }

}

