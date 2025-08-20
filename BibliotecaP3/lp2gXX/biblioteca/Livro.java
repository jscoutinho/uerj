package lp2gXX.biblioteca;

import java.io.*;
import java.util.*;
import java.util.GregorianCalendar;
public class Livro implements Serializable {
    private int cod;
    private String titulo;
    private String categoria;
    private int qtd;
    private int emprestados;
    private ArrayList<EmprestPara> hist;

    public Livro(int cod, String titulo, String categoria, int qtd) {
        this.cod = cod;
        this.titulo = titulo;
        this.categoria = categoria;
        this.qtd = qtd;
        this.emprestados = 0;
        this.hist = new ArrayList<>();
    }

    public void empresta() throws CopiaNaoDisponivelEx {
        if (emprestados >= qtd) throw new CopiaNaoDisponivelEx();
        emprestados++;
    }

    public void devolve() throws NenhumaCopiaEmprestadaEx {
        if (emprestados <= 0) throw new NenhumaCopiaEmprestadaEx();
        emprestados--;
    }

    public void addUsuarioHist(GregorianCalendar dataEmp, GregorianCalendar dataDev, long cpf) {
        hist.add(new EmprestPara(dataEmp, dataDev, cpf));
    }

    public void registrarDevolucao(long cpf, GregorianCalendar dataDev) {
        for (EmprestPara ep : hist) {
            if (ep.getCpf() == cpf && ep.getDataDevol() == null) {
                ep.setDataDevol(dataDev);
                break;
            }
        }
    }

    public int getCod() { return cod; }

    @Override
    public String toString() {
        return "Código: " + cod + ", Título: " + titulo + ", Categoria: " + categoria + ", Disponíveis: " + (qtd - emprestados) + ", Hist:" + hist;
    }
}