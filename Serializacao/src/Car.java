import java.io.*;


public class Car implements Serializable {
    public String make;
    public int year;
    public static final long serialVersionUID = 1L;
    // Embora não haja necessidade de implementar nenhum método para serialização, é importante que a classe de implementação forneça um serialVersionUID:
    // Atua como um identificador para a JVM escolher a classe adequada para converter um fluxo de bytes de volta em um objeto

    private transient String model;
    // transient informa à JVM que o valor dos campos não deve ser serializado

    private Engine engine;

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", year=" + year +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }


    public Car(String make, int year) {
        this.make = make;
        this.year = year;
        this.engine = new Engine(2.0, 4);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        // -- SERIALIZAÇÃO --
        stream.writeObject(this.make);
        stream.writeInt(this.year);
        stream.writeInt(this.engine.getCylinders());
        stream.writeDouble(this.engine.getLiters());

    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        // -- DESERIALIZAÇÃO --
        this.make = (String) stream.readObject();
        this.year = stream.readInt();
        int cylinders = stream.readInt();
        double liters = stream.readDouble();
        this.engine = new Engine(liters, cylinders);
    }

    public static void main(String[] args) throws IOException {
        Car toyota = new Car("Toyota", 2021);
        Car honda = new Car("Honda", 2020);


        FileOutputStream fileOutputStream = new FileOutputStream("cars.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        toyota.writeObject(objectOutputStream);
        honda.writeObject(objectOutputStream);

        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("cars.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            Car toyotaCopy = new Car("", 0);
            toyotaCopy.readObject(objectInputStream);
            System.out.println(toyotaCopy);

            Car hondaCopy = new Car("", 0);
            hondaCopy.readObject(objectInputStream);
            System.out.println(hondaCopy);
        } catch (EOFException | ClassNotFoundException e) {
            System.out.println("End of file");
        }

    }
}
