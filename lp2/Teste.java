package lp2;

public class Teste {
    public static void main(String[] args){
        String a = "abimon../-";
        String abi = a.replaceAll("\\./-", "");
        System.out.println(abi);
    }
}
