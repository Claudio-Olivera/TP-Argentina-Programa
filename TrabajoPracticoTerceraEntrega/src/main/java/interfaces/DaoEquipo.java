package interfaces;

import org.example.Equipo;
import org.example.Partido;
import org.example.Pronostico;

import java.util.List;

public interface DaoEquipo {
    public void registrar(Equipo equip) throws Exception;
    public void modificar(Equipo equip) throws Exception;
    public void eliminar(Equipo equip) throws Exception;
    public List<Equipo> listar() throws Exception;
}
