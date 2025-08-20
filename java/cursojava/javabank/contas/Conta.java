package cursojava.javabank.contas;

import cursojava.javabank.cliente.Cliente;

public class Conta {
    private double saldo;
    private int agencia = 42;
    private int numero;
    private Cliente titular;

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

    public double getSaldo(){
        return saldo; 
    }

    public int getNumero(){
        return numero; 
    }

    public void setNumero(int novoNumero){
        numero = novoNumero;
    }

    public int getAgencia(){
        return agencia; 
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }
}
