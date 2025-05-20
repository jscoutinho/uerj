package cursojava.javabank;

public class Conta {
    double saldo;
    int agencia = 42;
    int numero;
    String titular;

    public void deposita(double valor) {
        this.saldo = this.saldo + valor;
    }

    public boolean saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        System.out.println("Não há saldo suficiente!");
        return false;

    }

    public boolean transfere(Conta conta, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            conta.deposita(valor);
            return true;
        }

        System.out.println("Não foi possível fazer a transação");
        return false;
    }
}
