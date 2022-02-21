package classes;

import java.time.Instant;

public class Sub extends Super {
    // último espaço, definido pelo construtor
    private final Instant instant;


    public Sub() {
        this.instant = Instant.now();
    }

    // Método override invocado pelo construtor da superclasse
    @Override
    public void overrideMe(){
        System.out.println(instant);
    }
}
