package collections;

import java.util.*;

import static java.util.Collections.binarySearch;

public class Collections {
    public static void main(String[] args) {
        Collection collections = new ArrayList<>();
        collections.add(4);
        collections.add(8);

        boolean isEmpty = collections.isEmpty(); // false
        int collectionSize = collections.size(); // 2

        Integer[] collectionArray = (Integer[]) collections.toArray(new Integer[0]);
        //System.out.println(collectionArray[0]); // 4
        //System.out.println(collectionArray[1]); // 8

        List<Integer> intList = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        Queue<Double> doubleQueue = new LinkedList<>();
        java.util.Deque<Integer> intDeque = new ArrayDeque<>();

        intList.add(5);
        intList.add(8);
        intList.add(5);
        intList.add(1);

        System.out.println("Binary Search: "+ binarySearch(intList, 1));

        stringSet.add("Hello");
        stringSet.add("World");
        stringSet.add("World");

        doubleQueue.add(3.89);
        doubleQueue.add(889.64);

        intDeque.addFirst(7);
        intDeque.addFirst(8);
        intDeque.addLast(40);

        System.out.println(intList.getClass());
        printCollection(intList);
        System.out.println();
        System.out.println(stringSet.getClass());
        printCollection(stringSet);
        System.out.println();
        System.out.println(doubleQueue.getClass());
        printCollection(doubleQueue);
        System.out.println();
        System.out.println(intDeque.getClass());
        printCollection(intDeque);
    }
    private static <T> void printCollection(Collection<T> collection) {
//        Iterator<?> myItr = collection.iterator();
//
//        while(myItr.hasNext()){
//            System.out.println(myItr.next());
//        }
        for(T item: collection) {
            System.out.println(item);
        }
    }
}
