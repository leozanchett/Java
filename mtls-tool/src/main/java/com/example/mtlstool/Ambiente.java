package com.example.mtlstool;

public enum Ambiente {
    TEST("TEST"),
    HOMOL("HOMOL"),
    PROD("PROD");

    private String valor;

    Ambiente(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static Ambiente fromString(String valor) {
        for (Ambiente ambiente : Ambiente.values()) {
            if (ambiente.getValor().equals(valor)) {
                return ambiente;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + valor);
    }
}
