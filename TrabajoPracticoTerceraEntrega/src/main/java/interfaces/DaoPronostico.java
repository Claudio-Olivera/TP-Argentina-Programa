package interfaces;

import org.example.Pronostico;
import org.example.Ronda;

import java.util.List;

public interface DaoPronostico {
    public void registrar(Pronostico pron) throws Exception;
    public void modificar(Pronostico  pron) throws Exception;
    public void eliminar(Pronostico  pron) throws Exception;
    public List<Pronostico>  listar() throws Exception;
}
