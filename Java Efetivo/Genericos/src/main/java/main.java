import classes.Chooser;

import java.util.*;

public class main {

    public static void main(String[] args){
        // List<String> strings = new ArrayList<>();
        // unsafeAdd(strings, Integer.valueOf(42));
        // String s = strings.get(0);// Tem cast compilado gerado.

        Chooser<String> chooser = new Chooser<>(Arrays.asList("23", "42", "54"));
        System.out.println(chooser.choose().toString());
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.add(2);
        stack1.add(3);
        stack2.add(5);
        stack2.add(3);
        max(stack1);
    }

    /*private static void unsafeAdd(List<Object> list, Object o){
        list.add(o);
    }*/

    // Usa tipos brutos - inaceitável
    /* public static Set union(Set s1, Set s2){
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    } */

    // Método genérico
    public static <E> Set<E> union(Set<E> s1, Set<E> s2){
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Retorna o valor max em uma coleção - usa o tipo limitado recursivo
    public static <E extends Comparable<E>> E max(Collection<E> c){
        if (c.isEmpty()){
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for(E e: c){
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }
        return result;
    }

}
