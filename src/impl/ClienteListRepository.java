package impl;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepository implements OrdenablePaginableCrudRepository{

    private List<Cliente> dataSource;

    public ClienteListRepository(){
        this.dataSource= new ArrayList<>();
    }
    @Override
    public int total() {
        return this.dataSource.size();
    }

    @Override
    public List<Cliente> lista() {
        return dataSource;
    }

    @Override
    public Cliente listId(Integer id) {
        Cliente resultado=null;
        for (Cliente cli: dataSource) {
            if (cli.getId() != null && cli.getId().equals(id)) {
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente cliente1=this.listId(cliente.getId());
        cliente1.setNombre(cliente.getNombre());
        cliente1.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.listId(id));
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listOrdenada =new ArrayList<>(this.dataSource);
        listOrdenada.sort((a,b) ->{
            int resultado =0 ;
            if (dir == Direccion.ASC){
                resultado = ordenar(campo,a,b);
            }else if (dir == Direccion.DESC){
                resultado=ordenar(campo,b,a);
            }
            return resultado;
        });
        return listOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    public static int ordenar(String campo,Cliente a,Cliente b){
        int resultado =0;
        switch (campo){
            case "id" ->
                    resultado=a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado=a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado=a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

}
