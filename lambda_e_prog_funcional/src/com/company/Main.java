package com.company;

import classes.Produto;
import util.ProdutoConsumer;
import util.ProdutoPredicate;
import util.UpercaseName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static int globalValue = 1;

    public static void main(String[] args) {
        int[] vector = new int[]{3, 4, 5};
        changeOddValues(vector);
        System.out.println(Arrays.toString(vector));
        Locale.setDefault(Locale.US);
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Mouse", 35.00));
        lista.add(new Produto("Tablet", 350.00));
        lista.add(new Produto("HD Case", 80.90));

        //FunctionsLAMBDA(lista);
        //Predicattesss(lista);
        //Consummerr(lista);
    }

    private static void FunctionsLAMBDA(List<Produto> lista) {
        Function<Produto, String> aFunctionLAMBDA = produto -> produto.getNome().toUpperCase();
        //List<String> listaProdEmUpperCase = lista.stream().map(new UpercaseName()).collect(Collectors.toList());
        //List<String> listaProdEmUpperCase = lista.stream().map(Produto::staticUpperCaseName).collect(Collectors.toList());
        //List<String> listaProdEmUpperCase = lista.stream().map(Produto::nonStaticUpperCaseName).collect(Collectors.toList());
        //List<String> listaProdEmUpperCase = lista.stream().map(aFunctionLAMBDA).collect(Collectors.toList());
        List<String> listaProdEmUpperCase = lista.stream().map(produto -> produto.getNome().toUpperCase()).collect(Collectors.toList());

        listaProdEmUpperCase.forEach(System.out::println);
    }

    private static void Consummerr(List<Produto> lista) {
        Consumer<Produto> prod = p -> p.setPreco(p.getPreco() * 1.1);
        //lista.forEach(new  ProdutoConsumer());
        //lista.forEach(Produto::noNstaticProdutoConsumer);
        //lista.forEach(Produto::staticProdutoConsumer);
        //lista.forEach(prod);
        lista.forEach(produto -> produto.setPreco(produto.getPreco() * 1.1));
        lista.forEach(System.out::println);
    }

    private static void Predicattesss(List<Produto> lista) {
        Predicate<Produto> pred = p -> p.getPreco() >= 100.00;
        //lista.removeIf(pred);
        //lista.removeIf(Produto::noNstaticProdutoPredicate);
        //lista.removeIf(Produto::staticProdutoPredicate);
        //lista.removeIf(new ProdutoPredicate());
        //lista.removeIf(p -> p.getPreco() >= 100);
        for(Produto p : lista){
            System.out.println(p.toString());
        }
    }

    public static void changeOddValues(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                numbers[i] += globalValue;
            }
        }
    }


}
