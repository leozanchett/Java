package collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(); // Empty `List`
        intList.add(4); // 4
        intList.add(6); // 4, 6
        intList.add(3); // 4, 6, 3
        intList.set(1, 3); // 4, 3, 3

        int a = intList.get(2); // a = 3
        int b = intList.indexOf(3); // b = 1

        List<Integer> subIntList = intList.subList(1, 3); // subIntList -> 3,
        System.out.println(subIntList); // 3, 3
        System.out.println(intList); // 4, 3, 3

        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("!");

        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
