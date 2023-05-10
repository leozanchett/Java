// O HashMap define nenhuma ordem específica para as chaves e é a implementação mais otimizada para recuperar valores.

// O LinkedHashMap mantém as chaves na ordem de inserção e é um pouco menos ideal que o HashMap.

// O TreeMap mantém as chaves em sua ordem natural (ou alguma ordem personalizada definida usando um Comparator).
// Essa implementação tem uma redução significativa de desempenho em comparação com HashMape, LinkedHashMapmas é ótima quando é necessário manter as chaves classificadas.

package collections;

import java.util.*;

public class Mapss {
    public static void main(String[] args){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("Hello", "World"); // { "Hello" -> "World" }
        myMap.put("Name", "John"); //   { "Hello" -> "World" }, { "Name" -> "John" }

        String result = myMap.get("Hello"); // returns "World"
        String noResult = myMap.get("Jack"); // return `null`
        System.out.println(result);
        System.out.println(noResult);
        System.out.println(myMap);

        for(Map.Entry<String, String> entry : myMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        List<Integer> myInts = new ArrayList<>();
        Random random = new Random();

        for(int i =0; i < 20; i++) {
            myInts.add(random.nextInt(5));
        }

        Map<Integer, Integer> intCount = countNumbers(myInts);
        for(Map.Entry<Integer, Integer> entry: intCount.entrySet()) {
            System.out.println("Integer: "+ entry.getKey()+" appears: "+ entry.getValue());
        }
    }

    public static Map<Integer, Integer> countNumbers(List<Integer> list) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(Integer i : list) {
//            if(map.containsKey(i)) {
//                map.put(i, map.get(i) + 1);
//            } else {
//                map.put(i, 1);
//            }
//        }
//        return map;
        Map<Integer, Integer> map = new TreeMap<>();
        for(Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }
}
