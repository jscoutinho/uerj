package lp2gXX.biblioteca;

import java.io.*;
import java.util.GregorianCalendar;

public class Emprest implements Serializable {
    private GregorianCalendar dataEmp;
    private GregorianCalendar dataDev;
    private int codLivro;

    public Emprest(GregorianCalendar dataEmp, int codLivro) {
        this.dataEmp = dataEmp;
        this.codLivro = codLivro;
    }

    public void setDataDevol(GregorianCalendar dataDev) {
        this.dataDev = dataDev;
    }

    public GregorianCalendar getDataDev() {
        return dataDev;
    }

    public GregorianCalendar getDataEmp() {
        return dataEmp;
    }

    public int getCodLivro() {
        return codLivro;
    }

    @Override
    public String toString() {
        return "Livro: " + codLivro + ", Empréstimo: " + dataEmp.getTime() + ", Devolução: " +
                (dataDev == null ? "Pendente" : dataDev.getTime());
    }
}
