package lp2gXX.biblioteca;

import java.util.*;

public class Usuario extends Pessoa {
    private String endereco;
    private ArrayList<Emprest> hist;
    private int emprestimosAtivos = 0;

    public Usuario(String nome, String sobrenome, long cpf, GregorianCalendar dataNasc, String endereco) {
        super(nome, sobrenome, cpf, dataNasc);
        this.endereco = endereco;
        this.hist = new ArrayList<>();
    }

    public void addLivroHist(GregorianCalendar dataEmp, int codLivro) {
        hist.add(new Emprest(dataEmp, codLivro));
        emprestimosAtivos++;
    }

    public void devolverLivro(int codLivro, GregorianCalendar dataDev) {
        for (Emprest e : hist) {
            if (e.getCodLivro() == codLivro && e.getDataDev() == null) {
                e.setDataDevol(dataDev);
                emprestimosAtivos--;
                break;
            }
        }
    }

    public int getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    public ArrayList<Emprest> getHist() {
        return hist;
    }

    @Override
    public String toString() {
        return super.toString() + ", Endereço: " + endereco + ", Hist:" + hist;
    }
}