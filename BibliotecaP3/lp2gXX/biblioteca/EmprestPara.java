package lp2gXX.biblioteca;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class EmprestPara implements Serializable {
    private GregorianCalendar dataEmp;
    private GregorianCalendar dataDev;
    private long cpf;

    public EmprestPara(GregorianCalendar dataEmp, GregorianCalendar dataDev, long cpf) {
        this.dataEmp = dataEmp;
        this.dataDev = dataDev;
        this.cpf = cpf;
    }

    public void setDataDevol(GregorianCalendar dataDev) {
        this.dataDev = dataDev;
    }

    public GregorianCalendar getDataDevol() {
        return dataDev;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Usuário: " + cpf + ", Empréstimo: " + dataEmp.getTime() + ", Devolução: " +
                (dataDev == null ? "Pendente" : dataDev.getTime());
    }
}
