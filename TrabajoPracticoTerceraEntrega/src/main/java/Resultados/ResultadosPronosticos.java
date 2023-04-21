package Resultados;

import dao.DaoPronostiocoimpl;
import dao.DaoRondaimpl;
import interfaces.DaoPronostico;
import interfaces.DaoRonda;
import org.example.Pronostico;
import org.example.Ronda;

import java.util.HashMap;
import java.util.Map;

import static Resultados.ResultadosPartidos.aciertos;

public class ResultadosPronosticos extends Ronda {

    public void calcularPuntuacion() throws Exception {
        DaoRonda daoronda=new DaoRondaimpl();
        int puntos =daoronda.listar();

        Map<String, Integer> puntuacionesr1 = new HashMap<>();
        Map<String, Integer> puntuacionesr2 = new HashMap<>();


        DaoPronostico daoPronostico = new DaoPronostiocoimpl();

        for (Pronostico pronostico : daoPronostico.listar()) {

            if (aciertos(pronostico.getResultado()) && pronostico.getRonda() == 1) {
                String participante = pronostico.getParctipante();
                Integer contador = puntuacionesr1.get(participante);
                if (contador == null) {
                    contador = 0;
                }

                contador=contador+puntos;
                puntuacionesr1.put(participante, contador);
            }
        }
        for (Pronostico pronostico : daoPronostico.listar()) {
            if (aciertos(pronostico.getResultado()) && pronostico.getRonda() == 2) {
                String participante = pronostico.getParctipante();
                Integer contador = puntuacionesr2.get(participante);
                if (contador == null) {
                    contador = 0;
                }

                contador=contador+puntos;
                puntuacionesr2.put(participante, contador);
            }
        }


        sumarPuntuaciones(puntuacionesr1, puntuacionesr2);
    }


    public Map<String, Integer> sumarPuntuaciones(Map<String, Integer> puntuacionesr1, Map<String, Integer> puntuacionesr2) throws Exception {
        Map<String, Integer> puntosExtras = new HashMap<>();

        mostrarPuntuaciones(puntuacionesr1, "Ronda 1");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        mostrarPuntuaciones(puntuacionesr2, "Ronda 2");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

        for (Map.Entry<String, Integer> entry : puntuacionesr1.entrySet()) {
            String nombre = entry.getKey();
            Integer resultado = entry.getValue();
            Integer puntuacion = calcularPuntuacion(resultado);
            puntosExtras.put(nombre, puntuacion);
        }

        for (Map.Entry<String, Integer> entry : puntuacionesr2.entrySet()) {
            String nombre = entry.getKey();
            Integer resultado = entry.getValue();
            Integer puntuacion = calcularPuntuacion(resultado);
            if (puntosExtras.containsKey(nombre)) {
                puntuacion += puntosExtras.get(nombre);
            }
            puntosExtras.put(nombre, puntuacion);
        }

        mostrarPuntuaciones(puntosExtras, "Total Rondas");
        puntuacionFinal(puntosExtras);
        return puntosExtras;
    }

}
