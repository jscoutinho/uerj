package P1;

import java.util.*;

public class P1nX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa[] pessoas = null;
        ValidaCPF vCPF = new ValidaCPF();
        ValidaData vData = new ValidaData();

        if (args.length != 9) {
            System.out.println("Número de parâmetros incorreto!");
            help();
        } else {

            try {
                validaGenero(args[0]);

            } catch (RuntimeException e) {
                System.out.println(e);
                help();
            }
            String genero = args[0].toUpperCase();
            String nome = args[1];
            String sobrenome = args[2];
            String diaStr = args[3];
            String mesStr = args[4];
            String anoStr = args[5];
            try {
                if (!(vCPF.isCPF(args[6]))) {
                    throw new RuntimeException(
                            "CPF Inválido. \nFormatos aceitos: 000.000.000-00   000.000.000/00   00000000000");
                }
            } catch (RuntimeException e) {
                System.out.println(e);
                help();
            }
            String cpf = args[6];
            String peso = args[7];
            String altura = args[8];

            Pessoa p = null;
            try {
                if (genero.equalsIgnoreCase("F") || genero.equalsIgnoreCase("FEMININO")) {
                    p = new Mulher(nome, sobrenome, diaStr, mesStr, anoStr, cpf, peso, altura);
                } else if (genero.equalsIgnoreCase("M") || genero.equalsIgnoreCase("MASCULINO")) {
                    p = new Homem(nome, sobrenome, diaStr, mesStr, anoStr, cpf, peso, altura);
                }
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e);
            }

        }

        System.out.print("\nQuantos elementos deseja adicionar? ");

        int total = 0;

        while (total <= 0) {

            try {
                total = Integer.parseInt(sc.nextLine());
                if (total <= 0)
                    throw new NumberFormatException();
            } catch (RuntimeException e) {
                throw new RuntimeException("O número de pessoas deve ser inteiro positivo!");
            }

        }

        pessoas = new Pessoa[total];
        int count = 0;

        while (count < total) {
            try {
                System.out.print("\nDigite 'homem' ou 'mulher' (ENTER para sair): ");
                String genero = sc.nextLine().trim();
                if (genero.isEmpty())
                    break;

                System.out.print("Nome: ");
                String nome = sc.nextLine().trim();
                if (genero.isEmpty())
                    break;

                System.out.print("Sobrenome: ");
                String sobrenome = sc.nextLine().trim();
                if (genero.isEmpty())
                    break;

                System.out.print("Dia de nascimento: ");
                String dia = sc.nextLine();
                if (genero.isEmpty())
                    break;

                System.out.print("Mês de nascimento (número ou por extenso): ");
                String mesStr = sc.nextLine().trim();
                if (genero.isEmpty())
                    break;

                System.out.print("Ano de nascimento: ");
                String ano = sc.nextLine();
                if (genero.isEmpty())
                    break;

                System.out.print("CPF: ");
                String cpf = sc.nextLine().trim();
                if (genero.isEmpty())
                    break;

                System.out.print("Peso (kg): ");
                String peso = sc.nextLine().trim();
                if (genero.isEmpty())
                    break;

                System.out.print("Altura (m): ");
                String altura = sc.nextLine().trim();
                if (genero.isEmpty())
                    break;

                if (!vData.isDataValida(dia, mesStr, ano)) {
                    throw new IllegalArgumentException("Data inválida.");
                }

                if (!vCPF.isCPF(cpf)) {
                    throw new IllegalArgumentException("CPF inválido.");
                }

                Pessoa p = null;

                if (genero.equalsIgnoreCase("homem")) {
                    p = new Homem(nome, sobrenome, dia, mesStr, ano, cpf, peso, altura);
                } else if (genero.equalsIgnoreCase("mulher")) {
                    p = new Mulher(nome, sobrenome, dia, mesStr, ano, cpf, peso, altura);
                } else {
                    throw new IllegalArgumentException("Gênero inválido.");
                }

                pessoas[count++] = p;

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }

        System.out.println("\nLista de pessoas cadastradas:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                System.out
                        .println("============================================================\n" + pessoa.toString());
            }
        }

        sc.close();

    }

    public static void validaGenero(String genero) {
        if (genero == null) {
            throw new RuntimeException("O gênero não pode ser nulo");
        }
        if (!genero.matches("[a-zA-Z]+")) {
            throw new RuntimeException("O gênero deve conter apenas letras");
        }

        if (!(genero.equalsIgnoreCase("M") || genero.equalsIgnoreCase("MASCULINO") || genero.equalsIgnoreCase("F")
                || genero.equalsIgnoreCase("FEMININO"))) {
            throw new RuntimeException("O gênero deve seguir o padrão: m ou masculino, f ou feminino.");
        }

    }

    public static void help() {
        System.out.println("java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
    }

}