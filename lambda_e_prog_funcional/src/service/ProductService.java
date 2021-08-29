package service;

import classes.Produto;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {
    public double filderedSum(List<Produto> lista, Predicate<Produto> criteria){
        double sum = 0.0;
        for(Produto p: lista){
            if(criteria.test(p)){
                sum += p.getPreco();
            }
        }
        return sum;
    }
}
