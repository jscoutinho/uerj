package cursojava.javabank.contas;

public class CriaConta {
    public static void main(String[] agrs){
        Conta primeiraConta = new Conta();
        primeiraConta.deposita(200);

        System.out.println(primeiraConta.getSaldo());
        primeiraConta.deposita(100);
        System.out.println(primeiraConta.getSaldo());

        Conta segundaConta = new Conta();
        segundaConta.deposita(50);
        System.out.println(primeiraConta.getSaldo());
        System.out.println(segundaConta.getSaldo());
    
        System.out.println(segundaConta.getAgencia());
    }
}
