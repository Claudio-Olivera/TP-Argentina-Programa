package dao;

import interfaces.DaoRonda;

import org.example.Ronda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoRondaimpl extends Conexion implements DaoRonda {


    @Override
    public void modificar(Ronda rond) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE rondas SET punto = ? ");

            st.setInt(1, rond.getPuntos());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }


    }



    @Override
    public int listar() throws Exception {
        int puntos = 0;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM rondas");


            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Ronda ronda = new Ronda();
                ronda.setPuntos(rs.getInt("punto"));


                puntos= ronda.getPuntos();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return puntos;
    }


}
