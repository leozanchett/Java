package collections;

import java.util.List;
import java.util.ArrayList;
public class Deque {
    public static void main(String[] args) {
        List<Integer> myInts = new ArrayList<>();
        myInts.add(9);
        myInts.add(13);
        myInts.add(2);
        myInts.add(1);
        myInts.add(11);
        myInts.add(39);
        myInts.add(78);
        myInts.add(4);

        java.util.Deque<Integer> result = separateInts(myInts);
        for(Integer i: result) {
            System.out.println(i);
        }
    }

    // add your code here to complete separateInts()
    public static java.util.Deque<Integer> separateInts(List<Integer> integers){
        java.util.Deque<Integer> result = new java.util.ArrayDeque<>();
        for(Integer i: integers) {
            if(i % 2 == 0) {
                result.addFirst(i);
            } else {
                result.addLast(i);
            }
        }
        return result;
    }
}