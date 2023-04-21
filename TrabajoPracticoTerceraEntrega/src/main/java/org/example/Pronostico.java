package org.example;

import Menu.Colores;

public class Pronostico {
    private int ronda;

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    private String partipante;
    private String equipo1;
    private String ganaEquipo1;
    private String empate;
    private String ganaEquipo2;
    private String equipo2;
    private String resultado;

    @Override
    public String toString() {

        return Colores.blancoBrillante("Pronostico:\n" +
                "\tRonda : " + ronda + "\n" +
                "\tParticipante: " + partipante + "\n" +
                "\tEquipo 1: " + equipo1 + "\n" +
                "\tGana Equipo 1: " + ganaEquipo1 + "\n" +
                "\tEmpate: " + empate + "\n" +
                "\tGana Equipo 2: " + ganaEquipo2 + "\n" +
                "\tEquipo 2: " + equipo2);
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getPartipante() {
        return partipante;
    }

    public void setPartipante(String partipante) {
        this.partipante = partipante;
    }


    public String getParctipante() {
        return partipante;
    }

    public void setParctipante(String parctipante) {
        this.partipante = parctipante;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getGanaEquipo1() {
        return ganaEquipo1;
    }

    public void setGanaEquipo1(String ganaEquipo1) {
        this.ganaEquipo1 = ganaEquipo1;
    }

    public String getEmpate() {
        return empate;
    }

    public void setEmpate(String empate) {
        this.empate = empate;
    }

    public String getGanaEquipo2() {
        return ganaEquipo2;
    }

    public void setGanaEquipo2(String ganaEquipo2) {
        this.ganaEquipo2 = ganaEquipo2;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
}
