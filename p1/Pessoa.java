package P1;

import java.time.LocalDate;
import java.time.format.*;

public class Pessoa {
    private String nome;
    private String sobreNome;
    private LocalDate dataNasc;
    private long numCPF;
    private float peso;
    private float altura;
    public static int c = 0;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano) {
        setNome(nome);
        setSobreNome(sobreNome);
        // Isdata valida?
        setDataNasc(dia, mes, ano);
        c++;
    }

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, String CPF, float peso, float altura) {
        setNome(nome);
        setSobreNome(sobreNome);
        // Isdata valida?
        setDataNasc(dia, mes, ano);
        // validaCPF
        ValidaCPF v = new ValidaCPF();
        setNumCPF(v.toLong(CPF));
        setAltura(altura);
        setPeso(peso);
        c++;
    }

    public float getAltura() {
        return altura;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public long getNumCPF() {
        return numCPF;
    }

    public float getPeso() {
        return peso;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setDataNasc(int dia, int mes, int ano) {
        LocalDate data = LocalDate.of(ano, mes, dia);
        this.dataNasc = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = (dataNasc != null)
                ? dataNasc.format(formatter)
                : "Data não informada";

        return "Nome completo: " + nome + " " + sobreNome +
                "\nCPF: " + String.format("%011d", numCPF) +
                "\nData de nascimento: " + dataFormatada +
                "\nAltura: " + altura + " m" +
                "\nPeso: " + peso + " kg";

    }
}
