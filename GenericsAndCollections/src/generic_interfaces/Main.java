package generic_interfaces;

public class Main {

    public static <T> boolean isDouble(T object) {
        return object instanceof Double;
    }

    public static void main(String[] args) {
        int myNumber = 24;
        String bookName = "Hello Book!";

        Retriever<Integer> containerRetriever = new Container<>(myNumber);
        Retriever<String> bookRetriever = new Book(bookName);

        System.out.println(containerRetriever.retrieveData());
        System.out.println(bookRetriever.retrieveData());

        String test1 = "Double";
        double test2 = 5.8;
        final boolean isTest1Double = isDouble(test1);
        final boolean isTest2Double = isDouble(test2);
        System.out.println(isTest1Double);
        System.out.println(isTest2Double);
    }
}