package dao;

import interfaces.DaoEquipo;
import org.example.Equipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEquipoimpl extends Conexion implements DaoEquipo {
    @Override
    public void registrar(Equipo equip) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO equipos (nombre,descripcion) VALUES (?, ?)");

            st.setString(1, equip.getNombre());
            st.setString(2, equip.getDescripcion());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Equipo equip) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE equipos SET nombre = ? WHERE nombre = ?");

            st.setString(1, equip.getNombre());
            st.setString(2, equip.getDescripcion());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(Equipo equip) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM equipos WHERE nombre = ?");

            st.setString(1, equip.getNombre());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Equipo> listar() throws Exception {
        List<Equipo> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM equipos");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Equipo equipo= new Equipo();
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
}}
