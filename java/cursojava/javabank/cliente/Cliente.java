package cursojava.javabank.cliente;

public class Cliente {
    private String CPF;
    private String nome;
    private String profissao;

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }
}
