package prep.a1;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAlunos {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner scr = new Scanner(System.in);

        int total = 3;

        for (int i = 1; i <= total; i++) {
            System.out.println("\nAluno " + i);

            try {
                System.out.print("Nome: ");
                String nome = scr.nextLine();

                System.out.print("Idade: ");
                int idade = scr.nextInt();
                scr.nextLine(); // limpar o enter

                System.out.print("Matrícula: ");
                String matricula = scr.nextLine();

                boolean matriculaDuplicada = false;
                for (Aluno a : alunos) {
                    if (a.getMatricula().equals(matricula)) {
                        matriculaDuplicada = true;
                        break;
                    }
                }

                if (matriculaDuplicada) {
                    System.out.println("Erro: Matrícula já cadastrada.");
                    continue;
                }

                Aluno novo = new Aluno(nome, idade, matricula);
                alunos.add(novo);
                System.out.println("Aluno cadastrado com sucesso!");

            } catch (IdadeInvalidaException | NomeInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        scr.close();

        System.out.println("\nAlunos cadastrados:");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }
}
