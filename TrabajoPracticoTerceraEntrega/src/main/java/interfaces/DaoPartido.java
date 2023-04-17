package interfaces;

import org.example.Partido;

import java.util.List;

public interface DaoPartido {
    public void registrar(Partido part) throws Exception;
    public void modificar(Partido part) throws Exception;
    public void eliminar(Partido part) throws Exception;
    public List<Partido> listar() throws Exception;
   
}
