package com.company;

import classes.Produto;
import util.ProdutoPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class Predicattess {
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

        Predicate<Produto> pred = p -> p.getPreco() >= 100.00;

        lista.removeIf(pred);
        for(Produto p : lista){
            System.out.println(p.toString());
        }

        lista.removeIf(Produto::noNstaticProdutoPredicate);
        for(Produto p : lista){
            System.out.println(p.toString());
        }

        lista.removeIf(Produto::staticProdutoPredicate);
        for(Produto p : lista){
            System.out.println(p.toString());
        }

        lista.removeIf(new ProdutoPredicate());
        for(Produto p : lista){
            System.out.println(p.toString());
        }

        lista.removeIf(p -> p.getPreco() >= 100);
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
