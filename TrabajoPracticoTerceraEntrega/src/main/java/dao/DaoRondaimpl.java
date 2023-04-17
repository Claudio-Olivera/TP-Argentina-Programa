package dao;

import interfaces.DaoRonda;
import org.example.Equipo;
import org.example.Ronda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoRondaimpl extends Conexion implements DaoRonda {
    @Override
    public void registrar(Ronda rond) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO rondas (nro) VALUES (?)");


            st.setInt(1, rond.getNro());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Ronda rond) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE rondas SET nombre = ? WHERE nro = ?");

            st.setInt(1, rond.getNro());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }


    }

    @Override
    public void eliminar(Ronda rond) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM rondas WHERE nro = ?");

            st.setInt(1, rond.getNro());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<Ronda> listar() throws Exception {
        List<Ronda> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM rondas");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ronda ronda = new Ronda();
                ronda.setNro(rs.getInt("nro"));


                lista.add(ronda);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
}
