import java.io.*;

public class Serializacao {
    public static void main(String[] args) throws IOException {
        Car toyota = new Car("Toyota", 2021);
        Car honda = new Car("Honda", 2020);

        // -- SERIALIZAÇÃO --
        FileOutputStream fileOutputStream = new FileOutputStream("cars.txt"); // Inicializou um FileOutputStreamobjeto no main()qual criará e gravará um fluxo de bytes em um arquivo chamado person-file.txt
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); // Inicializou um ObjectOutputStreamobjeto no main()qual ajudará a serializar um objeto para um fluxo de saída especificado

        objectOutputStream.writeObject(toyota); // Escreveu o objeto carno arquivo cars.txt
        objectOutputStream.writeObject(honda); // Escreveu o objeto car2no arquivo cars.txt

        // -- DESERIALIZAÇÃO --
        FileInputStream fileInputStream = new FileInputStream("cars.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            Car toyotaCopy = (Car) objectInputStream.readObject(); // Lêu o objeto car1do arquivo cars.txt
            Car hondaCopy = (Car) objectInputStream.readObject(); // Lêu o objeto car2do arquivo cars.txt

            System.out.println(toyotaCopy.make + " " + toyotaCopy.year);
            System.out.println(hondaCopy);

            boolean isSameObject = toyota == toyotaCopy;
            System.out.println("Toyota (Copy) - Car make is: "+ toyotaCopy.make + ", Car year is: " + toyotaCopy.year);
            System.out.println("Toyota (Original) - Car make is: "+ toyota.make + ", Car year is: " + toyota.year);
            System.out.println("Are the objects the same? " + isSameObject);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
