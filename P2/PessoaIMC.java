public abstract class PessoaIMC extends Pessoa {
    protected float peso;
    protected float altura;

    public PessoaIMC(String nome, String dia, String mes, String ano, String cpf, float peso, float altura) {
        super(nome, dia, mes, ano, cpf); 
        this.peso = peso;
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public float calculaIMC() {
        if (altura <= 0) return 0;
        return peso / (altura * altura);
    }

    public abstract String resultIMC();

    @Override
    public String toString() {
        return super.toString() +
               "\nPeso: " + peso +
               "\nAltura: " + altura;
    }
}
