package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentClasse {

    @Autowired
    public void naoPrecisaInstanciarAClasse(){ //neste caso chama o método porque tem uma anotação do tipo @Component
        System.out.println("naoPrecisaInstanciarAClasse");
    }

    @Autowired
    public void naoPrecisaInstanciarAClasseTambem(){ // neste caso chama o método porque tem uma anotação do tipo @Component
        System.out.println("naoPrecisaInstanciarAClasseTambem");
    }

    public void precisaInstanciarAClasse(){
        System.out.println("precisaInstanciarAClasse");
    }
}
