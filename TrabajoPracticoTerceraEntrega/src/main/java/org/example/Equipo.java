package org.example;

import Menu.Colores;

public class Equipo {
    private String nombre;
    private String descripcion;

    @Override
    public String toString() {

        return Colores.azul(String.format("%-20s %s", nombre + ":", descripcion));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
