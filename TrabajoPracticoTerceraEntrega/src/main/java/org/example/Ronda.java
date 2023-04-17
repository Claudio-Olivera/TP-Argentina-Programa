package org.example;

import dao.DaoPartidoimpl;
import dao.DaoPronostiocoimpl;
import interfaces.DaoPartido;
import interfaces.DaoPronostico;

import java.util.*;

public class Ronda {
    private int nro;


    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    //1-Se guardan los resultados de los paridos en List<String> resultadosPartidos = new ArrayList<>();
    //la funcion aciertos recibe un pronostico de un participante y verifica si esta en la lista .
    public boolean aciertos(String pronostico) throws Exception {
        DaoPartido daoPartido = new DaoPartidoimpl();
        List<Partido> listaPartidos = daoPartido.listar();
        List<String> resultadosPartidos = new ArrayList<>();
        for (Partido partido : listaPartidos) {
            resultadosPartidos.add(partido.getResultado());
        }

        if (resultadosPartidos.contains(pronostico)) {
            return true;
        } else {
            return false;
        }
    }

    //2 -Si el partido esta en la lista guarda en un mapa el
// nombre y de asigna un punto .(para cada ronda hay un mapa).
    public void calcularPuntuacion() throws Exception {
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

                contador++;
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

                contador++;
                puntuacionesr2.put(participante, contador);
            }
        }


        sumarPuntuaciones(puntuacionesr1, puntuacionesr2);
    }

    //3 -Los 2 mapas son enviados a la  funcion sumarPuntuaciones donde se hacen los calculos finales
    //si aciertan todos los partidos de una ronda se les sumara un punto ,si se
    // aciertan todos los partidos se le sumara 5 puntos
    public Map<String, Integer> sumarPuntuaciones(Map<String, Integer> puntuacionesr1, Map<String, Integer> puntuacionesr2) {
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

    public void mostrarPuntuaciones(Map<String, Integer> puntuaciones, String ronda) {
        System.out.println("Resultados " + ronda);
        for (Map.Entry<String, Integer> entry : puntuaciones.entrySet()) {
            String clave = entry.getKey();
            Integer valor = entry.getValue();
            System.out.println(clave + " = " + valor);


        }
    }

    public Integer calcularPuntuacion(Integer resultado) {
        Integer puntuacion = resultado;
        if (resultado == 4) {
            puntuacion += 1;
        }
        return puntuacion;
    }


    public Integer calcularfinal(Integer resultado) {
        Integer puntuacion = resultado;
        if (resultado >= 8) {
            puntuacion += 5;
        }
        return puntuacion;
    }


    public void puntuacionFinal(Map<String, Integer> puntuacionesr1) {
        Map<String, Integer> puntosExtras= new HashMap<>();


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");


        for (Map.Entry<String, Integer> entry : puntuacionesr1.entrySet()) {
            String nombre = entry.getKey();
            Integer resultado = entry.getValue();
            Integer puntuacion = calcularfinal(resultado);
            puntosExtras.put(nombre, puntuacion);
        }
        mostrarPuntuaciones(puntosExtras, "Total Final");
    }}












