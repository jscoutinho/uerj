package prep.a2;

import java.util.Scanner;
import java.util.ArrayList;

public class CadastroProdutos {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        ArrayList<Produto> Produtos = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            try {
                System.out.println("Insira o Produto " + i);
                System.out.println("\nNome: ");
                String nomeA = scr.nextLine();
                System.out.println("\n Código: ");
                String codigoA = scr.nextLine();
                System.out.println("\n Preço: ");
                float precoA = scr.nextFloat();
                scr.nextLine();

                boolean flagRep = false;

                for (Produto a : Produtos) {
                    if (a.getCodigo().equals(codigoA)) {
                        flagRep = true;
                        break;
                    }
                }

                if(flagRep == true){
                    System.out.println("Código Repetido!");
                    continue;
                }

                Produto p = new Produto(nomeA, codigoA, precoA);
                Produtos.add(p);
                System.out.println("Produto Adicionado!");

            } catch (NomeVazioException  | PrecoInvalidoException e) {
                System.out.println(e.getMessage());
            }
            catch(Exception e){
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        scr.close();

        for(Produto p : Produtos){
            System.out.println(p);
        }

    }
}
