package interfaces;

import org.example.Partido;
import org.example.Ronda;

import java.util.List;

public interface DaoRonda {
    public void registrar(Ronda rond) throws Exception;
    public void modificar(Ronda rond) throws Exception;
    public void eliminar(Ronda rond) throws Exception;
    public List<Ronda> listar() throws Exception;

}
