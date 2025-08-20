package lp2gXX.biblioteca;

import java.io.*;
import java.util.*;
import java.util.GregorianCalendar;

public class Pessoa implements Serializable {
    private String nome;
    private String sobrenome;
    private long cpf;
    private GregorianCalendar dataNasc;

    public Pessoa(String nome, String sobrenome, long cpf, GregorianCalendar dataNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public long getCpf() { return cpf; }
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public GregorianCalendar getDataNasc() { return dataNasc; }

    @Override
    public String toString() {
        return nome + " " + sobrenome + ", CPF: " + cpf + ", Nascimento: " + dataNasc.getTime();
    }
}
