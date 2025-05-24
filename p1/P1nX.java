
import java.io.*;

public class P1nX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tentativas = 0;
        Pessoa pessoaInicial = null;

        while (tentativas < 3) {
            try {
                if (args.length != 9) throw new IllegalArgumentException("Número incorreto de argumentos.");

                String genero = args[0];
                String nome = args[1];
                String sobreNome = args[2];
                String dia = args[3];
                String mes = args[4];
                String ano = args[5];
                String cpfStr = args[6];
                String pesoStr = args[7];
                String alturaStr = args[8];

                if (!nome.matches("[A-Za-zÀ-ÿ]+")) throw new IllegalArgumentException("Nome inválido. O nome não deve conter números.");
                if (!ValidaData.isDia(dia)) throw new IllegalArgumentException("Dia inválido. Insira um dia existente.");
                if (!ValidaData.isMes(mes)) throw new IllegalArgumentException("Mês inválido. Insira um mês válido.");
                if (!ValidaData.isAno(ano)) throw new IllegalArgumentException("Ano inválido. Insira um ano possível.");
                if (!ValidaData.isDataValida(dia, mes, ano)) throw new IllegalArgumentException("Data inválida. Insira uma data existente.");

                if (!ValidaCPF.isCPF(cpfStr)) {
                    System.out.println("Aviso: CPF inválido de acordo com os dígitos verificadores.");
                }

                int diaInt = Integer.parseInt(dia);
                int mesInt = ValidaData.converteMes(mes);
                int anoInt = Integer.parseInt(ano);
                long cpf = ValidaCPF.toLong(cpfStr);
                float peso = Float.parseFloat(pesoStr);
                float altura = Float.parseFloat(alturaStr);

                if (genero.equalsIgnoreCase("homem") || genero.equalsIgnoreCase("m")) {
                    pessoaInicial = new Homem(nome, sobreNome, diaInt, mesInt, anoInt, cpf, peso, altura);
                } else if (genero.equalsIgnoreCase("mulher") || genero.equalsIgnoreCase("f")) {
                    pessoaInicial = new Mulher(nome, sobreNome, diaInt, mesInt, anoInt, cpf, peso, altura);
                } else {
                    throw new IllegalArgumentException("Gênero inválido. Use 'f' ou 'm'.");
                }

                System.out.println("\nPessoa criada com sucesso:");
                System.out.println(pessoaInicial);
                break;
            } catch (Exception e) {
                tentativas++;
                System.out.println("Erro na entrada dos parâmetros: " + e.getMessage());
                System.out.println("Tentativa " + tentativas + " de 3");
                System.out.println("Uso correto:");
                System.out.println("java P1nX <genero> <nome> <sobrenome> <dia> <mes> <ano> <CPF> <peso> <altura>");
                System.out.println("Gênero: f (feminino) ou m (masculino)\n");
                if (tentativas >= 3) {
                    System.out.println("Número máximo de tentativas atingido. Encerrando programa.");
                    return;
                } else {
                    System.out.println("Digite os parâmetros novamente, separados por espaço:");
                    String linha = reader.readLine();
                    args = linha.trim().split("\\s+");
                }
            }
        }

        System.out.print("Quantas pessoas a mais deseja inserir? ");
        int quantidade = 0;
        while (true) {
            try {
                String linha = reader.readLine();
                if (linha == null || linha.isEmpty()) {
                    quantidade = 0;
                    break;
                }
                quantidade = Integer.parseInt(linha);
                if (quantidade < 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Digite um número não negativo: ");
            }
        }

        Pessoa[] pessoas = new Pessoa[quantidade];
        int contador = 0;
        while (contador < quantidade) {
            System.out.print("Digite os dados (genero nome sobrenome dia mes ano CPF peso altura), ou pressione ENTER para parar: ");
            String linha = reader.readLine();
            if (linha == null || linha.trim().isEmpty()) break;

            String[] dados = linha.trim().split("\\s+");
            if (dados.length != 9) {
                System.out.println("Erro: número incorreto de dados. Tente novamente.");
                continue;
            }

            try {
                String genero = dados[0];
                String nome = dados[1];
                String sobreNome = dados[2];
                String dia = dados[3];
                String mes = dados[4];
                String ano = dados[5];
                String cpfStr = dados[6];
                String pesoStr = dados[7];
                String alturaStr = dados[8];

                if (!nome.matches("[A-Za-zÀ-ÿ]+")) throw new IllegalArgumentException("Nome inválido. O nome não deve conter números.");
                if (!ValidaData.isDia(dia)) throw new IllegalArgumentException("Dia inválido. Insira um dia existente.");
                if (!ValidaData.isMes(mes)) throw new IllegalArgumentException("Mês inválido. Insira um mês válido.");
                if (!ValidaData.isAno(ano)) throw new IllegalArgumentException("Ano inválido. Insira um ano possível.");
                if (!ValidaData.isDataValida(dia, mes, ano)) throw new IllegalArgumentException("Data inválida. Insira uma data existente.");

                if (!ValidaCPF.isCPF(cpfStr)) {
                    System.out.println("Aviso: CPF inválido de acordo com os dígitos verificadores.");
                }

                int diaInt = Integer.parseInt(dia);
                int mesInt = ValidaData.converteMes(mes);
                int anoInt = Integer.parseInt(ano);
                long cpf = ValidaCPF.toLong(cpfStr);
                float peso = Float.parseFloat(pesoStr);
                float altura = Float.parseFloat(alturaStr);

                if (genero.equalsIgnoreCase("homem") || genero.equalsIgnoreCase("m")) {
                    pessoas[contador] = new Homem(nome, sobreNome, diaInt, mesInt, anoInt, cpf, peso, altura);
                } else if (genero.equalsIgnoreCase("mulher") || genero.equalsIgnoreCase("f")) {
                    pessoas[contador] = new Mulher(nome, sobreNome, diaInt, mesInt, anoInt, cpf, peso, altura);
                } else {
                    throw new IllegalArgumentException("Gênero inválido. Use 'f' ou 'm'.");
                }
                contador++;
            } catch (Exception e) {
                System.out.println("Erro ao processar entrada: " + e.getMessage());
            }
        }

        System.out.println("\nPessoas cadastradas:");
        if (pessoaInicial != null) System.out.println(pessoaInicial);
        for (Pessoa p : pessoas) {
            if (p != null) System.out.println(p);
        }

        int homens = 0, mulheres = 0;
        if (pessoaInicial instanceof Homem) homens++;
        else if (pessoaInicial instanceof Mulher) mulheres++;

        for (Pessoa p : pessoas) {
            if (p instanceof Homem) homens++;
            else if (p instanceof Mulher) mulheres++;
        }

        System.out.println("\nTotal de homens: " + homens);
        System.out.println("Total de mulheres: " + mulheres);
    }
}
