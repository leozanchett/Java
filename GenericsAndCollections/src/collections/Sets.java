package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        Set<Integer> intSet = new HashSet<>();  // Empty set

        // A HashSet implementação tem o melhor desempenho ao recuperar ou inserir elementos, mas não pode garantir nenhuma ordem entre eles.
        // A TreeSet implementação mantém os elementos em ordem crescente, mas é mais lenta ao recuperar ou inserir elementos.
        // A LinkedHashSet implementação mantém os elementos na ordem em que foram inseridos, mas é mais lenta ao recuperar ou inserir elementos.

        intSet.add(6);  // true - 6
        intSet.add(0);  //  true - 0, 6 (no guaranteed ordering)
        intSet.add(6);  //  false - 0, 6 (no change, no guaranteed ordering)

        boolean isNineInSet = intSet.contains(9);  // false
        boolean isZeroInSet = intSet.contains(0);  // true
        System.out.println(intSet);

        Set<String> stringSet = new TreeSet<>();
        stringSet.add("Hello");  // true - Hello
        stringSet.add("World");  // true - Hello, World
        stringSet.add("Hello");  // false - Hello, World (no change)

        for(String element : stringSet) {
            System.out.println(element);
        }
    }
}
