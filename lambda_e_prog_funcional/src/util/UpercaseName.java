package util;

import classes.Produto;

import java.util.function.Function;

public class UpercaseName implements Function<Produto, String> {

    @Override
    public String apply(Produto prod) {
        return prod.getNome().toUpperCase();
    }
}
