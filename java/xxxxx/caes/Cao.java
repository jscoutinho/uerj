package lp2.caes;
import lp2.excp.*;

public class Cao {
    private int idade;
    int cor;
    String padrao;


    public Cao(int idade_) throws IdadeEx{
        setIdade(idade_);
       
    }

    public void setIdade(int idade_) throws IdadeEx {
        if(idade_>0 && idade_ <= 25){
            idade = idade_;
        }
        else{
            throw new IdadeEx("Idade do cão fora do range de 1 a 25");
        }
    }

    public int getIdade(){
        return idade; 
    }

    public String toString(){
        return "Cao - idade " + idade;
    }
}