package com.company;

import com.company.enums.Cargo;
import com.company.models.Funcionario;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(Cargo.DESENVOLVEDOR);
        funcionario.setSalarioBase(3000);
        System.out.println(funcionario.getCargo().getRegra());
        System.out.println(funcionario.getCargo().getRegra().calcula(funcionario));

    }
}
