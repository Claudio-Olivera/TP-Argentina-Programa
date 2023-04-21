package org.example;

import Menu.Colores;
import dao.DaoRondaimpl;
import interfaces.DaoRonda;


import java.util.HashMap;
import java.util.Map;


public class Ronda {
    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
//1-Se guardan los resultados de los partidos en List<String> resultadosPartidos = new ArrayList<>();
    //la funcion aciertos recibe un pronostico de un participante y verifica si esta en la lista .

    //2 -Si el partido esta en la lista guarda en un mapa el
// nombre y de asigna un punto .(para cada ronda hay un mapa).

    public void mostrarPuntuaciones(Map<String, Integer> puntuaciones, String ronda) {


        System.out.println(Colores.rojoBrillante("Resultados " + ronda));
        for (Map.Entry<String, Integer> entry : puntuaciones.entrySet()) {
            String clave = entry.getKey();
            Integer valor = entry.getValue();

            System.out.println(Colores.verdeBrillante(clave + " = " + valor));


        }
    }

    public Integer calcularPuntuacion(Integer resultado) throws Exception {
        DaoRonda daoronda=new DaoRondaimpl();
        int puntos =daoronda.listar();
        Integer puntuacion = resultado;
        if (resultado == 5*puntos) {
            puntuacion += puntos*2;
        }
        return puntuacion;
    }


    public Integer calcularfinal(Integer resultado) throws Exception {
        DaoRonda daoronda=new DaoRondaimpl();
        int puntos =daoronda.listar();
        Integer puntuacion = resultado;
        if (resultado >= 10*puntos) {
            puntuacion += puntos*2;
        }
        return puntuacion;
    }


    public void puntuacionFinal(Map<String, Integer> puntuacionesr1) throws Exception {
        Map<String, Integer> puntosExtras = new HashMap<>();


        System.out.println(Colores.blancoBrillante("+++++++++++++++++++++++++++++++++++++++++++++++"));


        for (Map.Entry<String, Integer> entry : puntuacionesr1.entrySet()) {
            String nombre = entry.getKey();
            Integer resultado = entry.getValue();
            Integer puntuacion = calcularfinal(resultado);
            puntosExtras.put(nombre, puntuacion);
        }
        mostrarPuntuaciones(puntosExtras, "Total Final de la Fase");
    }
}












