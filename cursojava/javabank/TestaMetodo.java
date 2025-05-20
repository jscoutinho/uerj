package cursojava.javabank;

public class TestaMetodo {
    public static void main(String[] args){
        Conta minhaConta = new Conta(); 

        minhaConta.saldo = 100; 
        minhaConta.deposita(70);
        System.out.println(minhaConta.saldo);

        minhaConta.saca(100);

        Conta contaDaMaria = new Conta(); 
        contaDaMaria.deposita(1000);

        minhaConta.transfere(contaDaMaria,100);
        System.out.println(minhaConta.saldo);
        System.out.println(contaDaMaria.saldo);
    }
}
