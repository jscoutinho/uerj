package cursojava.javabank;

public class TesteReferencia {
    public static void main(String[] agrs){
        Conta primeiraConta = new Conta(); 
        primeiraConta.saldo = 300;

        System.out.println("O saldo da primeira conta é: "+ primeiraConta.saldo);

        Conta segundaConta = primeiraConta; 
        System.out.println("O saldo da segunda conta é: "+ segundaConta.saldo);
    }
}
