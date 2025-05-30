package P1;

import java.time.LocalDate;
import java.time.Period;

public class Homem extends Pessoa {

    public Homem(String nome, String sobreNome, String dia, String mes, String ano, String CPF, String peso, String altura) {
        super(nome, sobreNome, dia, mes, ano, CPF, peso, altura);
    }

    public Homem(String nome, String sobreNome, String dia, String mes, String ano) {
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
        return String.format("%s, gênero: Homem, idade: %d anos",
                super.toString(),
                getIdade());
    }
}
