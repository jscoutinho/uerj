package cursojava.javabank.contas;
import cursojava.javabank.cliente.Cliente;

public class TesteGettersESetters {
    public static void main(String[] args){
        Conta conta = new Conta(); 
        conta.setNumero(13);   
        System.out.println(conta.getNumero());

        Cliente cliente = new Cliente(); 

        conta.setTitular(cliente);
        cliente.setCPF("111.111.111-11");

        System.out.println(conta.getTitular().getCPF());
    }
}
