import classes.*;

public class main {

    public static void main(String [] args){
        Time time = new Time(10, 39);
        time.Conta();
        time.Conta();

        Time novoTime = new Time(1, 30);
        novoTime.Conta();

        Student student = new Student();

        Polymorphism myPig = new Pig();
        myPig.animalSound();

        Complex complex1 =  Complex.valueOf(2, 5);
        System.out.println(complex1.toString());

        Complex complex2 = Complex.valueOf(2, 5);
        System.out.println(complex2.toString());

        System.out.println(complex1.equals(complex2));

        complex2 = complex2.plus(complex2);
        System.out.println(complex2.toString());
        System.out.println(complex1.equals(complex2));

    }

}
