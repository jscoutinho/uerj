import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(String nome, String dia, String mes, String ano, String cpf) {
        setNome(nome);
        setDataNascimento(dia, mes, ano);
        setCpf(cpf);
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome.trim();
    }

    public void setCpf(String cpf) {
        if (!ValidaCPF.isCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = ValidaCPF.imprimeCPF(cpf);
    }

    public void setDataNascimento(String dia, String mes, String ano) {
        if (!ValidaData.isDataValida(dia, mes, ano)) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        try {
            String dataStr = String.format("%s/%s/%s", dia, mes, ano);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.dataNascimento = LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatter);
    }

    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears();
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
               "\nData de Nascimento: " + getDataNascimento() +
               "\nCPF: " + cpf +
               "\nIdade: " + getIdade() + " anos";
    }
}
