import impl.ClienteListRepository;
import impl.Direccion;
import impl.OrdenablePaginableCrudRepository;
import model.Cliente;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepository repo = new ClienteListRepository();
        //Crear Datos en la tabla
        repo.crear(new Cliente(1,"Juan","Gomez"));
        repo.crear(new Cliente(2,"Brandon","Guzman"));
        repo.crear(new Cliente(3,"William","Garcia"));
        repo.crear(new Cliente(4,"William","Garcia"));

        //Listar
        System.out.println("Lista");
        List<Cliente>clientes=repo.lista();
        clientes.forEach(System.out::println);

        //Listar por id
        System.out.println("Listar Por id \n"+repo.listId(1));

        //Listar desde index 1 hasta index 2
        System.out.println("Listar desde index 1 hasta index 2");
        clientes=repo.listar(1,3);
        clientes.forEach(System.out::println);

        //Editar un dato
        repo.editar(new Cliente(1,"Pedro","Gomez"));
        //Eliminar un dato
        repo.eliminar(2);

        //Listar de forma ascedente los datos por la columna
        System.out.println("Lista Ascendente");
        clientes=repo.listar("id",Direccion.ASC);
        clientes.forEach(System.out::println);
        //Listar de forma ascedente los datos por la columna
        System.out.println("Lista Descendente");
        clientes=repo.listar("id",Direccion.DESC);
        clientes.forEach(System.out::println);
        //Total de datos
        System.out.println("Total de datos En la lista \n"+repo.total());


    }
}