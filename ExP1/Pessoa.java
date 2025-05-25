package ExP1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;
    private double peso;
    private double altura;
    private String genero; 
    private Pessoa mae; 
    private Pessoa pai; 
    public static int c = 0; 

    private void contador(){
        c += 1; 
    }
    

    public Pessoa(String nome){
        this.nome = nome;
        contador(); 
    }

    public Pessoa(String nome, String sobrenome, int dia, int mes, int ano , double peso, double altura, String genero, Pessoa pai, Pessoa mae){
        setNome(nome);
        setSobrenome(sobrenome);
        setDataNasc(ano, mes, dia);
        setPeso(peso);
        setAltura(altura);
        setGenero(genero);
        setMae(mae);
        setPai(pai);
        
        contador();
    }



    public void setNome(String nome){
        this.nome = nome; 
    }

    public String getNome(){
        return this.nome; 
    }

    public void setSobrenome(String sobreNome){
        sobrenome = sobreNome; 
    }

    public String getSobrenome(){
        return this.sobrenome;
    }

    public void setDataNasc(int ano, int mes, int dia){
        dataNasc = LocalDate.of(ano, mes, dia);
    }

    public String getDataNasc(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNasc.format(formato);
    }

    public void setPeso(double peso) {
        if(peso >= 40 && peso < 200){
        this.peso = peso;
        }
        else{
            System.out.println("Peso Inválido!");
        }
    }

    public double getPeso(){
        return peso; 
    }

    public void setAltura(double altura){
        if(altura <= 1.20 && altura >= 2.40){
        this.altura = altura; 
        }
        else{
            System.out.println("Altura Inválida!");
        }
    }

    public double getAltura(){
        return altura; 
    }

    public void setGenero(String genero){
        if(genero.toUpperCase() == "M" || genero.toUpperCase() =="MASCULINO" || genero.toUpperCase() == "F" || genero == "FEMININO"){
          this.genero = genero;   
        }
        else{
            System.out.println("Gênero inválido!");
        }
    }

    public String getGenero(){
        return this.genero; 
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }
    public Pessoa getMae() {
        return mae;
    }
    public void setPai(Pessoa pai) {
        this.pai = pai;
    }
    public Pessoa getPai() {
        return pai;
    }

    private int idade(){
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNasc, hoje);
        return periodo.getYears();
    }
    
    public String toString() {
    return "Pessoa {" +
           "\n  Nome: " + nome +
           "\n  Sobrenome: " + sobrenome +
           "\n  Data de Nascimento: " + getDataNasc() +
           "\n  Idade: " + idade() + " anos" +
           "\n  Peso: " + peso + " kg" +
           "\n  Altura: " + altura + " m" +
           "\n  Gênero: " + genero +
           "\n  Pai: " + (pai != null ? pai.getNome() : "Desconhecido") +
           "\n  Mãe: " + (mae != null ? mae.getNome() : "Desconhecida") +
           "\n}";
}
}
