package trabalhos.P2;
import java.util.Scanner;

public class P2nX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinhaListaOrdenavel lista = new MinhaListaOrdenavel();

        lista.add(new Homem("Carlos", "12", "05", "1980", "19010220729", 85.0f, 1.80f));
        lista.add(new Homem("Bruno", "01", "01", "1990", "19010220729", 72.5f, 1.75f));
        lista.add(new Homem("Eduardo", "22", "09", "1975", "19010220729", 90.0f, 1.78f));
        lista.add(new Homem("Fernando", "15", "03", "2000", "19010220729", 68.3f, 1.72f));
        lista.add(new Homem("André", "30", "07", "1995", "19010220729", 77.0f, 1.74f));

        lista.add(new Mulher("Ana", "10", "10", "1985", "19010220729", 60.0f, 1.65f));
        lista.add(new Mulher("Beatriz", "05", "06", "1992", "19010220729", 65.0f, 1.70f));
        lista.add(new Mulher("Carla", "18", "12", "1988", "19010220729", 70.0f, 1.68f));
        lista.add(new Mulher("Daniela", "25", "04", "1978", "19010220729", 58.5f, 1.60f));
        lista.add(new Mulher("Elaine", "08", "08", "2001", "19010220729", 55.0f, 1.66f));

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Imprimir Lista");
            System.out.println("2. Sair");
            System.out.print("Digite sua opção: ");
            String opcao = sc.nextLine();

            if (opcao.equals("2")) {
                System.out.println("Encerrando...");
                break;
            } else if (opcao.equals("1")) {
                System.out.println("\nEscolha seu modo de ordenação:");
                System.out.println("1. Nome (A-Z)");
                System.out.println("2. Nome (Z-A)");
                System.out.println("3. Peso (Crescente)");
                System.out.println("4. Peso (Decrescente)");
                System.out.println("5. IMC (Crescente)");
                System.out.println("6. IMC (Decrescente)");
                System.out.println("7. Altura (Crescente)");
                System.out.println("8. Altura (Decrescente)");
                System.out.println("9. Idade (Crescente)");
                System.out.println("10. Idade (Decrescente)");
                System.out.println("11. CPF (A-Z)");
                System.out.println("12. CPF (Z-A)");
                System.out.println("13. Gênero (Mulher-Homem)");
                System.out.print("Digite sua opção: ");

                try {
                    int criterio = Integer.parseInt(sc.nextLine());
                    if (criterio < 1 || criterio > 13) {
                        System.out.println("Critério inválido.");
                        continue;
                    }

                    System.out.println("\n--- LISTA ORDENADA ---");
                    for (PessoaIMC p : lista.ordena(criterio)) {
                        System.out.println(p);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite apenas números.");
                }
            } else {
                System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
