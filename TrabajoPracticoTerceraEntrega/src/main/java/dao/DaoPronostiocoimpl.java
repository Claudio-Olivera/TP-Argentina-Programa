package dao;

import interfaces.DaoPronostico;
import org.example.Equipo;
import org.example.Pronostico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoPronostiocoimpl extends Conexion implements DaoPronostico {
    @Override
    public void registrar(Pronostico pron) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO pronosticos (id,ronda,equipo1,equipo2,golesEquipo1,golesEquipo2 )VALUES (?,?,?,?,?,?)");

            //st.setString(1, equip.getNombre());
            //   st.setString(2, equip.getDescripcion());


            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Pronostico pron) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO pronosticos (dni,partido,equipo,resultado,persona) VALUES (?,?,?,?,?)");



            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void eliminar(Pronostico pron) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM pronosticos WHERE dni = ?");



            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }


    }

    @Override
    public List<Pronostico> listar() throws Exception {
        List<Pronostico> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM pronosticos");

            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Pronostico pronostico = new Pronostico();
pronostico.setRonda(rs.getInt("ronda"));
                pronostico.setParctipante(rs.getString("Participante"));
                pronostico.setEquipo1(rs.getString("Equipo1"));
                pronostico.setGanaEquipo1(rs.getString("Gana_equipo1"));
                pronostico.setEmpate(rs.getString("Empate"));
                pronostico.setGanaEquipo2(rs.getString("Gana_equipo1"));
                pronostico.setEquipo2(rs.getString("Equipo2"));
                pronostico.setResultado(rs.getString("resultado"));



                lista.add(pronostico);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;


}}
