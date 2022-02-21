import classes.Chooser;

import java.util.Arrays;

public class main {

    public static void main(String[] args){
        // List<String> strings = new ArrayList<>();
        // unsafeAdd(strings, Integer.valueOf(42));
        // String s = strings.get(0);// Tem cast compilado gerado.

        Chooser<String> chooser = new Chooser<>(Arrays.asList("23", "42", "54"));
        System.out.println(chooser.choose().toString());
    }

    /*private static void unsafeAdd(List<Object> list, Object o){
        list.add(o);
    }*/
}
