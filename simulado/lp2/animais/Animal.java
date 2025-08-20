package lp2.animais;
import lp2.excp.PesoEx;


public class Animal {
    double peso;

    public Animal(double peso_) throws PesoEx{
        setPeso(peso_);
    }

    public void setPeso( double peso_) throws PesoEx{
        if(peso_ <= 0 || peso_ >100){
            throw new PesoEx("Peso inexistente!")
        }
        else{
            peso = peso_;
        }
    }

    public double getPeso(){
        return peso;
    }

    public String toString(){
        return "Animal com peso: " + peso;
    }
}
