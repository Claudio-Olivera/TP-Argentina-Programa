package Resultados;

import dao.DaoPartidoimpl;
import interfaces.DaoPartido;
import org.example.Partido;

import java.util.ArrayList;
import java.util.List;


public class ResultadosPartidos {


    public static boolean aciertos(String pronostico) throws Exception {
        DaoPartido daoPartido = new DaoPartidoimpl();
        List<Partido> listaPartidos = daoPartido.listar();
        List<String> resultadosPartidos = new ArrayList<>();
        for (Partido partido : listaPartidos) {

            if (partido.getGolesEquipo1() > partido.getGolesEquipo2()) {
                resultadosPartidos.add("gana " + partido.getEquipo1() + partido.getRonda() + partido.getPartido());

            } else if (partido.getGolesEquipo2() > partido.getGolesEquipo1()) {
                resultadosPartidos.add("gana " + partido.getEquipo2() + partido.getRonda() + partido.getPartido());

            } else {
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
