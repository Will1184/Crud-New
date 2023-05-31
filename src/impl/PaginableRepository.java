package impl;
import model.Cliente;
import java.util.List;

public interface PaginableRepository {
    List<Cliente> listar(int desde , int hasta);
}
