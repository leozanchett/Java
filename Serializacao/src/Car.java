import java.io.Serializable;

public class Car implements Serializable {
    public String make;
    public int year;
    private static final long serialVersionUID = 1L;

    // Embora não haja necessidade de implementar nenhum método para serialização, é importante que a classe de implementação forneça um serialVersionUID:
    // Atua como um identificador para a JVM escolher a classe adequada para converter um fluxo de bytes de volta em um objeto


    public Car(String make, int year) {
        this.make = make;
        this.year = year;
    }

}
