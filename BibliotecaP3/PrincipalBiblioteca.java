
import lp2gXX.biblioteca.*;

import java.util.*;

public class PrincipalBiblioteca {
    private static Scanner in = new Scanner(System.in);
    private static Biblioteca bib;

    public static void main(String[] args) {
        System.out.println("Deseja iniciar com biblioteca vazia ou carregar de arquivos? (v/car): ");
        String op = "";
while (!op.equalsIgnoreCase("v") && !op.equalsIgnoreCase("car")) {
    System.out.print("Deseja iniciar com biblioteca vazia ou carregar de arquivos? (v/car): ");
    op = in.nextLine().trim();
}

try {
    if (op.equalsIgnoreCase("car")) {
        System.out.print("Nome do arquivo de usuários: ");
        String arqU = in.nextLine().trim();
        System.out.print("Nome do arquivo de livros: ");
        String arqL = in.nextLine().trim();
        bib = new Biblioteca(arqU, arqL);
    } else {
        bib = new Biblioteca();
    }

            System.out.print("Quantos dias são permitidos para empréstimo sem multa? (padrão 7): ");
            int dias = Integer.parseInt(in.nextLine());
            System.out.print("Qual o valor da multa por dia de atraso? (padrão 2.0): ");
            double multa = Double.parseDouble(in.nextLine());
            bib.setPolitica(dias, multa);

            menu();
        } catch (Exception e) {
            System.err.println("Erro ao iniciar: " + e.getMessage());
        }
    }

    public static void menu() {
        int escolha = -1;
        while (escolha != 0) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1 - Manutenção");
            System.out.println("2 - Cadastro");
            System.out.println("3 - Empréstimo");
            System.out.println("4 - Relatório");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            escolha = Integer.parseInt(in.nextLine());

            switch (escolha) {
                case 1:
                    manutencao();
                    break;
                case 2:
                    cadastro();
                    break;
                case 3:
                    emprestimo();
                    break;
                case 4:
                    relatorio();
                    break;
            }

        }
    }

    public static void manutencao() {
        System.out.println("1 - Salvar usuários");
        System.out.println("2 - Salvar livros");
        int op = Integer.parseInt(in.nextLine());
        try {
            System.out.print("Nome do arquivo: ");
            String nome = in.nextLine();
            if (op == 1)
                bib.salvaArquivo(bib.getUsuarios(), nome);
            else
                bib.salvaArquivo(bib.getLivros(), nome);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static void cadastro() {
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Cadastrar livro");
        int op = Integer.parseInt(in.nextLine());
        try {
            if (op == 1) {
                System.out.print("Nome: ");
                String nome = in.nextLine();
                System.out.print("Sobrenome: ");
                String sobrenome = in.nextLine();
                System.out.print("CPF: ");
                long cpf = Long.parseLong(in.nextLine());
                System.out.print("Ano nascimento: ");
                int a = Integer.parseInt(in.nextLine());
                System.out.print("Mês: ");
                int m = Integer.parseInt(in.nextLine());
                System.out.print("Dia: ");
                int d = Integer.parseInt(in.nextLine());
                System.out.print("Endereço: ");
                String end = in.nextLine();
                Usuario u = new Usuario(nome, sobrenome, cpf, new GregorianCalendar(a, m - 1, d), end);
                bib.cadastraUsuario(u);
            } else {
                System.out.print("Código: ");
                int cod = Integer.parseInt(in.nextLine());
                System.out.print("Título: ");
                String titulo = in.nextLine();
                System.out.print("Categoria: ");
                String cat = in.nextLine();
                System.out.print("Quantidade: ");
                int qtd = Integer.parseInt(in.nextLine());
                Livro l = new Livro(cod, titulo, cat, qtd);
                bib.cadastraLivro(l);
            }
        } catch (Exception e) {
            System.err.println("Erro no cadastro: " + e.getMessage());
        }
    }

    public static void emprestimo() {
        System.out.println("1 - Fazer empréstimo");
        System.out.println("2 - Fazer devolução");
        int op = Integer.parseInt(in.nextLine());
        try {
            System.out.print("CPF do usuário: ");
            long cpf = Long.parseLong(in.nextLine());
            Usuario u = bib.getUsuario(cpf);
            System.out.print("Código do livro: ");
            int cod = Integer.parseInt(in.nextLine());
            Livro l = bib.getLivro(cod);

            if (op == 1) {
                bib.emprestaLivro(u, l);
                System.out.println("✅ Empréstimo realizado:");
            } else {
                bib.devolveLivro(u, l);
                System.out.println("✅ Devolução registrada:");
            }
            System.out.println(u);
            System.out.println(l);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static void relatorio() {
        System.out.println("1 - Lista de livros");
        System.out.println("2 - Lista de usuários");
        int op = Integer.parseInt(in.nextLine());
        if (op == 1)
            System.out.println(bib.imprimeLivros());
        else
            System.out.println(bib.imprimeUsuarios());
    }
}
