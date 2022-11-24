// Por convenção, os parâmetros de tipo comuns incluem E(Elementos), K(Chave), N(Número), T(Tipo), V(Valor) e S(ou Uou V) para vários parâmetros de tipo.

public class Container <T> {
    private T data;

    public Container(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Container<String> wordContainer = new Container<>("myWord");
        Container<String> bookContainer = new Container<>("myBook");
        System.out.println(wordContainer.getData());
        System.out.println(bookContainer.getData());
    }
}
