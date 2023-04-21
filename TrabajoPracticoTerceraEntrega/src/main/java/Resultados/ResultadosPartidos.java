package Resultados;

import dao.DaoPartidoimpl;
import interfaces.DaoPartido;
import org.example.Partido;

import java.util.ArrayList;
import java.util.List;


public class ResultadosPartidos  {
//1-Se guardan los resultados de los partidos en List<String> resultadosPartidos = new ArrayList<>();
// la funcion aciertos recibe un pronostico de un participante y verifica si esta en la lista .

    public static boolean aciertos(String pronostico) throws Exception {
        DaoPartido daoPartido = new DaoPartidoimpl();
        List<Partido> listaPartidos = daoPartido.listar();
        List<String> resultadosPartidos = new ArrayList<>();
        for (Partido partido : listaPartidos) {

            if (partido.getGolesEquipo1() > partido.getGolesEquipo2()) {
                resultadosPartidos.add("gana " + partido.getEquipo1() + partido.getRonda() + partido.getPartido());

            }

            else if (partido.getGolesEquipo2() > partido.getGolesEquipo1()) {
                resultadosPartidos.add("gana " + partido.getEquipo2() + partido.getRonda() + partido.getPartido());

            }


            else {
                resultadosPartidos.add("empate " + partido.getRonda() + partido.getPartido());
            }
        }



        if (resultadosPartidos.contains(pronostico)) {
            return true;
        } else {
            return false;
        }
    }

}
