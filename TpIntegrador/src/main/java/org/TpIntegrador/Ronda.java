package org.TpIntegrador;

import java.util.*;

public class Ronda {
    private int nro;
    private Partido[] partidos;

    public Ronda(int nro) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public int getNro() {
        return nro;
    }

    public Partido[] getPartidos() {
        return partidos;
    }


    //Aca busco crear un método que tome una lista de partidos como la de arriba y una lista de pronósticos(a ser creada)
    // y que con esos datos haga la comparación y entregue los puntos.

    /**
     * Esta es la resulucion para el punto 1 , pero ahora ya se modificaron los metodos en las clases Partido y Equipo para resolver el punto 2
     */
//    public static void compararPartidosYPronosticos(List<String> partidos, String[] pronosticos) {
//        int puntos = 0;
//        for (int i = 0; i < partidos.size(); i++) {
//            String equipoGanador = partidos.get(i);
//            String pronostico = pronosticos[i];
//            if (equipoGanador.equals(pronostico)) {
//                puntos +=1 ;
//            }
//        }
//        System.out.println("Puntos ganados: " + puntos);
//    }


//    public static void compararPartidosYPronosticos(List<String> partidos, List<String> pronosticos) {
//        Map<String, Integer> puntosPorPersona = new HashMap<>(); // Map para almacenar los puntos de cada persona
//        List<String> personasPronosticadoras = new ArrayList<>(); // Lista para almacenar todas las personas que hicieron un pronóstico
//
//        // Iterar a través de los pronósticos y agregar cada persona a la lista de personasPronosticadoras
//        for (String pronostico : pronosticos) {
//            pronostico = pronostico.substring(1, pronostico.length() - 1);
//            String[] partes = pronostico.split(", ");
//            String personaPronosticadora = partes[0];
//            personasPronosticadoras.add(personaPronosticadora);
//            puntosPorPersona.put(personaPronosticadora, 0); // Agregar la persona al map con 0 puntos
//        }
//
//        int indexPronostico = 0; // Índice del pronóstico actual
//
//        // Iterar a través de los partidos y comparar los pronósticos con los resultados reales
//        for (String persona : personasPronosticadoras) {
//            int puntos = puntosPorPersona.get(persona);
            /**
             * Hay que corregir esta logica, ya que si se trata de una persona con puntaje 0, se repite su resultado varias veces en consola. y no queremos eso.
             */
//            if (puntos > 0) {
//                // Si los puntos para esta persona ya se han impreso, saltar al siguiente persona
//                continue;
//            }
//            for (int i = 0; i < partidos.size(); i++) {
//                String equipoGanador = partidos.get(i);
//
//                // Comprobar si el índice del pronóstico actual coincide con el índice del partido actual
//                if (indexPronostico < pronosticos.size()) {
//                    String pronostico = pronosticos.get(indexPronostico);
//                    pronostico = pronostico.substring(1, pronostico.length() - 1);
//                    String[] partes = pronostico.split(", ");
//                    String personaPronosticadora = partes[0];
//                    String equipoPronosticado = partes[1];
//
//                    if (equipoGanador.equals(equipoPronosticado)) {
//                        puntos = puntosPorPersona.get(personaPronosticadora);
//                        puntosPorPersona.put(personaPronosticadora, puntos + 1); // Agregar 1 punto a la persona
//                    }
//
//
//                    indexPronostico++; // Incrementar el índice del pronóstico de la persona actual si no es la misma persona
//
//                }
//
//            }
//
//            // Imprimir los puntos de cada persona
//            puntos = puntosPorPersona.getOrDefault(persona, 0);
//            System.out.print("\nPuntos ganados por " + persona + ": " + puntos);
//                }
//            }

            public static void compararPartidosYPronosticos(List<String> partidos, List<String> pronosticos) {
                Map<String, Integer> puntosPorPersona = new HashMap<>();
                List<String> personasPronosticadoras = new ArrayList<>();

                for (String pronostico : pronosticos) {
                    pronostico = pronostico.substring(1, pronostico.length() - 1);
                    String[] partes = pronostico.split(", ");
                    String personaPronosticadora = partes[0];
                    personasPronosticadoras.add(personaPronosticadora);
                    puntosPorPersona.put(personaPronosticadora, 0);
                }

                int indexPronostico = 0;

                for (String persona : personasPronosticadoras) {
                    int puntos = puntosPorPersona.get(persona);
                    if (puntos > 0) {
                        continue;
                    }
                    for (int i = 0; i < partidos.size(); i++) {
                        String equipoGanador = partidos.get(i);

                        if (indexPronostico < pronosticos.size()) {
                            String pronostico = pronosticos.get(indexPronostico);
                            pronostico = pronostico.substring(1, pronostico.length() - 1);
                            String[] partes = pronostico.split(", ");
                            String personaPronosticadora = partes[0];
                            String equipoPronosticado = partes[1];

                            if (equipoGanador.equals(equipoPronosticado)) {
                                puntos = puntosPorPersona.get(personaPronosticadora);
                                puntosPorPersona.put(personaPronosticadora, puntos + 1);
                            }

                            indexPronostico++;
                        }
                    }
                }

                imprimirPuntosPorPersona(puntosPorPersona);
            }
    public static void imprimirPuntosPorPersona(Map<String, Integer> puntosPorPersona) {
        for (String persona : puntosPorPersona.keySet()) {
            int puntos = puntosPorPersona.get(persona);
            System.out.println("Puntos ganados por " + persona + ": " + puntos);
        }
    }



}