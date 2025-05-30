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
    private static int c = 0;

    public Pessoa(String nome, String sobreNome, String dia, String mes, String ano) {
        setNome(nome);
        setSobreNome(sobreNome);
        setDataNasc(dia, mes, ano);
        c++;
    }

    public Pessoa(String nome, String sobreNome, String dia, String mes, String ano, String CPF, String peso,
            String altura) {
        setNome(nome);
        setSobreNome(sobreNome);
        setDataNasc(dia, mes, ano);
        setNumCPF(CPF);
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

    public static int getC() {
        return c;
    }

    public void setAltura(String altura) {

        if (altura == null) {
            throw new RuntimeException("Campo altura vazio");
        }

        try {
            Float.parseFloat(altura.replace(",", "."));
        } catch (RuntimeException e) {
            throw new RuntimeException("Altura deve ser um número real");
        }

        float _altura = Float.parseFloat(altura.replace(",", "."));

        if(_altura < 2.50 && _altura > 0.50){
        this.altura = _altura;
        }
        else{
            throw new RuntimeException("Altura deve estar entre 50cm e 2,50m!");
        }
    }

    public void setDataNasc(String dia, String mes, String ano) {

        if (dia == null) {
            throw new RuntimeException("Campo dia vazio!");
        }

        if (mes == null) {
            throw new RuntimeException("Campo mês vazio!");
        }

        if (ano == null) {
            throw new RuntimeException("Campo ano vazio!");
        }

        ValidaData v = new ValidaData();

        try {
            Integer.parseInt(ano);
        } catch (RuntimeException e) {
            throw new RuntimeException("Ano deve ser apenas números!");
        }

        int _ano = Integer.parseInt(ano);

        if (!(v.isAno(_ano))) {
            throw new RuntimeException("Ano Inválido!");
        }

        if (!(v.isMes(mes))) {
            throw new RuntimeException("Mês Inválido!");
        }

        try {
            v.mesParaNumero(mes);
        } catch (RuntimeException e) {
            throw new RuntimeException("Não foi possível Converter o mês em uma data!");
        }

        int _mes = v.mesParaNumero(mes);

        try {
            Integer.parseInt(dia);
        } catch (RuntimeException e) {
            throw new RuntimeException("Dia deve ser apenas números!");
        }

        int _dia = Integer.parseInt(dia);

        if (!(v.isDia(_dia))) {
            throw new RuntimeException("Dia Inválido!");
        }

        if (!(v.isDataValida(_dia, _mes, _ano))) {
            throw new RuntimeException("Data Inválida!");
        }

        LocalDate data = LocalDate.of(_ano, _mes, _dia);
        this.dataNasc = data;
    }

    public void setNome(String nome) {

        if (nome == null) {
            throw new RuntimeException("Campo nome vazio!");
        }

        if (!nome.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ ]+")) {
            throw new RuntimeException("O nome deve conter apenas letras e espaços!");
        }
        this.nome = nome;
    }

    public void setNumCPF(String numCPF) {

        if (numCPF == null) {
            throw new RuntimeException("Campo CPF vazio!");
        }

        ValidaCPF c = new ValidaCPF();

        if (!(c.isCPF(numCPF))) {
            throw new RuntimeException(
                    "CPF Inválido. \nFormatos aceitos: 000.000.000-00   000.000.000/00   00000000000");
        }

        this.numCPF = c.toLong(numCPF);
    }

    public void setPeso(String peso) {

        if (peso == null) {
            throw new RuntimeException("Campo peso vazio!");
        }

        try {
            Float.parseFloat(peso.replace(",", "."));
        } catch (RuntimeException e) {
            throw new RuntimeException("Peso deve ser um número real!");
        }

        float _peso = Float.parseFloat(peso.replace(",", "."));

        if (_peso < 300 && _peso > 5) {
            this.peso = _peso;
        } else {
            throw new RuntimeException("Peso deve estar entre 5kg e 300kg.");
        }
    }

    public void setSobreNome(String sobreNome) {

        if (sobreNome == null) {
            throw new RuntimeException("Campo sobrenome vazio!");
        }

        if (!sobreNome.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ ]+")) {
            throw new RuntimeException("O sobrenome deve conter apenas letras e espaços");
        }

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
