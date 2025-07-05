public class Mulher extends PessoaIMC {

    public Mulher(String nome, String dia, String mes, String ano, String cpf, float peso, float altura) {
        super(nome, dia, mes, ano, cpf, peso, altura);
    }

    @Override
    public String resultIMC() {
        float imc = calculaIMC();
        if (imc < 19f) {
            return "Abaixo do peso ideal";
        } else if (imc <= 25.8f) {
            return "Peso ideal";
        } else {
            return "Acima do peso ideal";
        }
    }

    @Override
    public String toString() {
        return "--------\n" +
               "Nome: " + getNome() + " (Mulher)\n" +
               "Data de Nascimento: " + getDataNascimento() + "\n" +
               "CPF: " + getCpf() + "\n" +
               "Peso: " + peso + "\n" +
               "Altura: " + altura + "\n" +
               "Idade: " + getIdade() + " anos\n" +
               String.format("IMC: %.1f  %s", calculaIMC(), resultIMC()) +
               "\n--------";
    }
}
