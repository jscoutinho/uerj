

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Pessoa {
    private String nome;
    private String sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private float peso;
    private float altura;

    private static int contador = 0;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc = new GregorianCalendar(ano, mes - 1, dia);
        contador++;
    }

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        this(nome, sobreNome, dia, mes, ano);
        this.numCPF = numCPF;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(GregorianCalendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public long getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < dataNasc.get(Calendar.MONTH) ||
           (hoje.get(Calendar.MONTH) == dataNasc.get(Calendar.MONTH) &&
            hoje.get(Calendar.DAY_OF_MONTH) < dataNasc.get(Calendar.DAY_OF_MONTH))) {
            idade--;
        }
        return idade;
    }

    public String toString() {
        int dia = dataNasc.get(Calendar.DAY_OF_MONTH);
        int mes = dataNasc.get(Calendar.MONTH) + 1;
        int ano = dataNasc.get(Calendar.YEAR);

        return String.format(
                "Nome: %s %s\nData de Nascimento: %02d/%02d/%d\nCPF: %011d\nPeso: %.2f kg\nAltura: %.2f m",
                nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
    }

    public static int numPessoas(){
        return contador; 
    }
}