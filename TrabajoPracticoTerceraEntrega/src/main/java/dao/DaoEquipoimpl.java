package dao;

import interfaces.DaoEquipo;
import org.example.Equipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEquipoimpl extends Conexion implements DaoEquipo {
//esta clase es una implementación de una interfaz de
// acceso a datos para manejar objetos "Equipo" y utiliza una clase
// de conexión para interactuar con una base de datos.

    @Override
    public List<Equipo> listar() throws Exception {
        List<Equipo> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM equipos");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombre(rs.getString("nombre"));

                equipo.setDescripcion(rs.getString("descripcion"));


                lista.add(equipo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
