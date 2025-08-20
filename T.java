import lp2.caes.*;
import lp2.excp.IdadeEx;

public class T {
    public static void main(String[] args) {
        try {
            York lilipup = new York(3, "Amarelado", 3);
            lilipup.setCor(2);
            lilipup.setIdade(5);

            System.out.println(lilipup);

        } catch (IdadeEx e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
