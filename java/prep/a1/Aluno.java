package prep.a1;

public class Aluno {
    private String nome;
    private int idade;
    private String matricula;

    public Aluno(String nome_, int idade_, String matricula_) throws NomeInvalidoException, IdadeInvalidaException {
        setNome(nome_);
        setIdade(idade_);
        this.matricula = matricula_;
    }

    public void setNome(String nome_) throws NomeInvalidoException {
        if (nome_ == null ) {
            throw new NomeInvalidoException("O nome não pode ser vazio ou nulo.");
        }
        this.nome = nome_;
    }

    public void setIdade(int idade_) throws IdadeInvalidaException {
        if (idade_ < 5 || idade_ > 100) {
            throw new IdadeInvalidaException("A idade deve estar entre 5 e 100.");
        }
        this.idade = idade_;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Matrícula: " + matricula;
    }
}
