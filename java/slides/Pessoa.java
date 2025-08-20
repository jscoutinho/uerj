
public class Pessoa {
    private int idade;
    private String nome;

    public Pessoa(String nome, int idade) {
        setIdade(idade);
        setNome(nome);
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nIdade: " + getIdade();
    }

    public static void main(String[] args) {
        Pessoa amor = new Pessoa("Abi", 24);

        System.out.println(amor.toString());
    }
}
