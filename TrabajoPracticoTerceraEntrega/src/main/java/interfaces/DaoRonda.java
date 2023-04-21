package interfaces;

import org.example.Partido;
import org.example.Ronda;

import java.util.List;

public interface DaoRonda {

    public void modificar(Ronda rond) throws Exception;

    public int listar() throws Exception;

}
