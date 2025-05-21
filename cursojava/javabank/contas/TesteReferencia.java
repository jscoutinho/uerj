package cursojava.javabank.contas;

public class TesteReferencia {
    public static void main(String[] agrs){
        Conta primeiraConta = new Conta(); 
        primeiraConta.deposita(300);

        System.out.println("O saldo da primeira conta é: "+ primeiraConta.getSaldo());

        Conta segundaConta = primeiraConta; 
        System.out.println("O saldo da segunda conta é: "+ segundaConta.getSaldo());
    }
}
