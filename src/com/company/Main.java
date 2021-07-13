package com.company;

import models.ImportedProduct;
import models.Product;
import models.UsedProduct;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner s = new Scanner(System.in);
        System.out.print("Informe a quantidade de produtos: ");
        List<Product> listaProduto = new ArrayList<>();
        int qtdeProdutos = s.nextByte();

        for(int i =0; i<qtdeProdutos; i++){
            double price = 0.0;
            System.out.println(msgDefault(i));
            System.out.print("Common, used or imported (c/u/i) ? ");
            char tipoProduto = s.next().charAt(0);
            System.out.print("Name: ");
            s.nextLine();
            String name = s.nextLine();
            System.out.print("Price: ");
            price = s.nextDouble();
            switch (tipoProduto){
                case 'i': {
                    System.out.print("Customs fee: ");
                    double customFee = s.nextDouble();
                    listaProduto.add(new ImportedProduct(name,price, customFee));
                    break;
                }
                case 'u': {
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    DateFormat format = new SimpleDateFormat("D/MM/Y");
                    Date manufactureDate = format.parse(s.next());
                    listaProduto.add(new UsedProduct(name, price, manufactureDate));
                    break;
                }
                default: {
                    listaProduto.add(new Product(name, price));
                }
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS");
        for(Product produto : listaProduto){
            System.out.println(produto.getName()+ " R$ "+produto.getPrice() +" "+produto.priceTag());
            System.out.println("--------------------------");
        }

        s.close();
    }


    public static String msgDefault(int posicao){
        return "Produto #"+(posicao+1)+ " data: ";
    }
}
