package com.company.enums;

import com.company.interfaces.RegraDeCalculo;
import com.company.models.DezOuVintePorCento;
import com.company.models.QuinzeOuVinteCincoPorCento;

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorCento()),
    DBA(new QuinzeOuVinteCincoPorCento()),
    TESTER(new QuinzeOuVinteCincoPorCento());

    private RegraDeCalculo regra;

    Cargo(RegraDeCalculo regra) {
        this.regra = regra;
    }

    public RegraDeCalculo getRegra() {
        return regra;
    }
}
