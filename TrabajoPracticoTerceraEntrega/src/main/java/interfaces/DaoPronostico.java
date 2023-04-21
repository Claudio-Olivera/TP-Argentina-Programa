package interfaces;

import org.example.Pronostico;


import java.util.List;

public interface DaoPronostico {

    List<Pronostico> listar() throws Exception;
}
