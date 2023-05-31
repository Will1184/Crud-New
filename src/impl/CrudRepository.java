package impl;

import model.Cliente;

import java.util.List;

public interface CrudRepository {
    List<Cliente> lista();
    Cliente listId(Integer id);
    void crear(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar (Integer id);
}
