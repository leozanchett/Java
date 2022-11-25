// A Queue acessa os elementos de uma maneira (geralmente) First In First Out (FIFO), onde os elementos
// são inseridos na cauda (atrás) da coleção e removidos da cabeça (frente).

package collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
    public static void main(String[] args){
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("Mike"); // true - state of queue -> "Mike"
        stringQueue.offer("Jeff"); // true - state of queue -> "Mike", "Jeff"

        String a = stringQueue.remove(); // Returns "Mike" - state of queue -> 1
        String b = stringQueue.poll(); // Returns "Jeff" - state of queue -> empty
        String c = stringQueue.peek(); // Returns null
        //String d = stringQueue.element(); // Throws NoSuchElementException
        System.out.println(a + " " + b + " " + c);

        Queue<String> line = new LinkedList<>();
        line.add("Mike");
        line.add("Isabel");
        line.add("Jenny");

        for(String name: line) {
            System.out.println(name);
        }

        Queues.processAlphabetically(line);
    }

    public static void processAlphabetically(Queue<String> queue) {
        Queue<String> alphabeticalQueue = new PriorityQueue<>();
        for (String name: queue) {
            //alphabeticalQueue.add(name);
            alphabeticalQueue.offer(name);
        }
        while (alphabeticalQueue.peek() != null) {
            String headElement = alphabeticalQueue.remove();
            System.out.println(headElement);
        }
    }
}
