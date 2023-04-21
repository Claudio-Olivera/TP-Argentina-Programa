package interfaces;

import org.example.Pronostico;
import org.example.Ronda;

import java.util.List;

public interface DaoPronostico {

     List<Pronostico>  listar() throws Exception;
}
