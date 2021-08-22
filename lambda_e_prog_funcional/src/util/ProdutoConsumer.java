package util;

import classes.Produto;

import java.util.function.Consumer;

public class ProdutoConsumer implements Consumer<Produto> {

    @Override
    public void accept(Produto p) {
        p.setPreco(p.getPreco() * 1.1);
    }
}
