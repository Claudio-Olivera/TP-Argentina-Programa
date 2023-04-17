package dao;

import interfaces.DaoPartido;
import org.example.Equipo;
import org.example.Partido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoPartidoimpl extends Conexion implements DaoPartido {
    @Override
    public void registrar(Partido part) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO departamento (id,equipo1,equipo2,golesEquipo1,golesEquipo2,ganador,perdedor,empate)VALUES (?,?,?,?,?,?,?,?)");



            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Partido part) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE departamento SET presupuesto = ? WHERE nombre_depto = ?");


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(Partido part) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM partidos WHERE id = ?");




            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }


    }

    @Override
    public List<Partido> listar() throws Exception {
        List<Partido> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM partido");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Partido partido = new Partido();
                partido.setRonda(rs.getInt("Ronda"));
                partido.setEquipo1(rs.getString("Equipo1"));
                partido.setGolesEquipo1(rs.getInt("Goles_Equipo1"));
                partido.setGolesEquipo2(rs.getInt("Goles_Equipo2"));
                partido.setEquipo2(rs.getString("Equipo1"));
                partido.setResultado(rs.getString("resultado"));

                lista.add(partido);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
