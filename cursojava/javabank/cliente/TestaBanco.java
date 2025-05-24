package cursojava.javabank.cliente;

import cursojava.javabank.contas.Conta;

public class TestaBanco {
    public static void main(String[] agrs){
        Cliente joao = new Cliente();
        joao.setNome("João");
        joao.setCPF("111.111.111-11");
        joao.setProfissao("Caminhoneiro");

        Conta contaDoJoao = new Conta(); 
        contaDoJoao.deposita(100);
        contaDoJoao.setTitular(joao);

        System.out.println(contaDoJoao.getTitular().getNome());

    }
}
