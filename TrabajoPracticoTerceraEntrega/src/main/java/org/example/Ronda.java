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


    public void mostrarPuntuaciones(Map<String, Integer> puntuaciones, String ronda) {


        System.out.println(Colores.rojoBrillante("Resultados " + ronda));
        for (Map.Entry<String, Integer> entry : puntuaciones.entrySet()) {
            String clave = entry.getKey();
            Integer valor = entry.getValue();

            System.out.println(Colores.verdeBrillante(clave + " = " + valor));


        }
    }
   // "Si se aciertan todos los partidos de una ronda (una ronda tiene 6 partidos),
    // se multiplicarán por los puntos fijados y se añadirá un bonus del doble de los puntos fijados."

    public Integer puntuacionRondaCompleta(Integer resultado) throws Exception {
        DaoRonda daoronda = new DaoRondaimpl();
        int puntos = daoronda.listar();


        Integer puntuacion = resultado;
        if (resultado == 6 * puntos) {
            puntuacion += puntos * 2;
        }
        return puntuacion;
    }
// "Si se aciertan todos los partidos de una Fase (una fase tiene 12 partidos)
// se multiplicarán por los puntos fijados y se añadirá un bonus del doble de los puntos fijados.
    public Integer puntuacionFaseCompleta(Integer resultado) throws Exception {
        DaoRonda daoronda = new DaoRondaimpl();
        int puntos = daoronda.listar();
        Integer puntuacion = resultado;
        if (resultado > 13 * puntos) {
            puntuacion += puntos * 2;
        }
        return puntuacion;
    }


    public void puntuacionFinal(Map<String, Integer> puntuacionesr1) throws Exception {
        Map<String, Integer> puntosExtras = new HashMap<>();


        System.out.println(Colores.blancoBrillante("+++++++++++++++++++++++++++++++++++++++++++++++"));


        for (Map.Entry<String, Integer> entry : puntuacionesr1.entrySet()) {
            String nombre = entry.getKey();
            Integer resultado = entry.getValue();
            Integer puntuacion = puntuacionFaseCompleta(resultado);
            puntosExtras.put(nombre, puntuacion);
        }
        mostrarPuntuaciones(puntosExtras, "Total Final de la Fase");
    }
}












