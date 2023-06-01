package generics;

import model.Cliente;
import model.ClientePremium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Mauricio", "Gomez"));

        Cliente mauricio = clientes.iterator().next();
        System.out.println("Reccorer usando iterador().next() "+mauricio);

        Cliente [] clientes1={new Cliente("Luci","Martinez"),new Cliente("Andres","Agulla")};
        Integer[] integers={1,2,3};


        List<Cliente> clienteList = fromArrayToList(clientes1);
        List<Integer> integerList =fromArrayToList(integers);

        System.out.println("clienteList");
        clienteList.forEach(System.out::println);

        System.out.println("integersList");
        integerList.forEach(System.out::println);

        List<String> nombres =fromArrayToList(new String[]{"Andres","Pepe","Luci","Bea","John"},integers);
        System.out.println("Imprime nombres list: ");
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiunList = fromArrayToList(new ClientePremium[]{new ClientePremium("Paco","Fernandez")});
        System.out.println("Imprime clientes");
        imprimirClientes(clientes);

        System.out.println("Imprime clientes list");
        imprimirClientes(clienteList);

        System.out.println("Imprime cliente premium");
        imprimirClientes(clientePremiunList);

        System.out.println("Maximo de 1,9 y 4 es : "+maximo(1,9,4));
        System.out.println("Maximo de 3.9,11.6, 7.78 es : "+maximo(3.9,11.6,7.78));
        System.out.println("Maximo de zanahoria, arandanos, manzana es: "
                +maximo("zanahoria","Arandanos","manzana"));


    }

    public static <T extends Comparable<T>> T  maximo(T a, T b, T c) {
        T max=a;
        if (b.compareTo(max)>0){
            max =b;
        }
        if (c.compareTo(max)>0){
            max =c;
        }
        return max;
    }

    public static  void imprimirClientes(List<? extends Cliente> c) {
        c.forEach(System.out::println);
    }

    public  static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }
    public  static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public  static <T,G> List<T> fromArrayToList(T[] c, G[] x){
        System.out.println("G");
        for (G elemento:x)
            System.out.println(elemento);
        return  Arrays.asList(c);
    }
}
