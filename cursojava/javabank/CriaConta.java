package cursojava.javabank;

public class CriaConta {
    public static void main(String[] agrs){
        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 200;

        System.out.println(primeiraConta.saldo);
        primeiraConta.saldo += 100;
        System.out.println(primeiraConta.saldo);

        Conta segundaConta = new Conta();
        segundaConta.saldo = 50;
        System.out.println(primeiraConta.saldo);
        System.out.println(segundaConta.saldo);
    
        System.out.println(segundaConta.agencia);
    }
}
