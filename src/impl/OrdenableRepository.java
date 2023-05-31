package impl;

import model.Cliente;

import java.util.List;

public interface OrdenableRepository {
    List<Cliente> listar(String campo,Direccion direccion);
}
