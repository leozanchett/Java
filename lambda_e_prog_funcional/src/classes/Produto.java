package classes;

public class Produto {
    String nome;
    Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public static boolean staticProdutoPredicate(Produto p){
        return p.getPreco() >= 100;
    }

    public static void staticProdutoConsumer(Produto p){
         p.setPreco(p.getPreco() * 1.1);
    }

    public void noNstaticProdutoConsumer(){
        setPreco(preco * 1.1);
    }

    public boolean noNstaticProdutoPredicate(){
        return preco >= 100;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
