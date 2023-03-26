package org.TpIntegrador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ronda {
    private int nro;
    private Partido[] partidos;
    public Ronda(int parseInt) {
    }

    /**
     * Esta es la resolución para el punto 1, pero ahora ya se modificaron los métodos en las clases Partido y Equipo para resolver el punto 2.
     */

    /**
     *   public static void compararPartidosYPronosticos(List<String> partidos, String[] pronosticos) {
     *         int puntos = 0;
     *         for (int i = 0; i < partidos.size(); i++) {
     *             String equipoGanador = partidos.get(i);
     *             String pronostico = pronosticos[i];
     *             if (equipoGanador.equals(pronostico)) {
     *                 puntos +=1 ;
     *             }
     *         }
     *         System.out.println("Puntos ganados: " + puntos);
     *     }
     */
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