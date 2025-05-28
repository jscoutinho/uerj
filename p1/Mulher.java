package P1;

import java.time.LocalDate;
import java.time.Period;

public class Mulher extends Pessoa {
    public Mulher(String nome, String sobreNome, int dia, int mes, int ano, String CPF, float peso, float altura) {
        super(nome, sobreNome, dia, mes, ano, CPF, peso, altura);
    }

    public Mulher(String nome, String sobreNome, int dia, int mes, int ano) {
        super(nome, sobreNome, dia, mes, ano);
    }

    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        LocalDate nasc = getDataNasc();

        if (nasc != null) {
            return Period.between(nasc, hoje).getYears();
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s, gênero: Mulher, idade: %d anos",
                super.toString(),
                getIdade());
    }
}
