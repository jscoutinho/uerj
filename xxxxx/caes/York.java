package lp2.caes;


public class York extends Cao implements Pelagem{
    public York(int idade_, String padrao_, int cor_){
        super(idade_);
        setCor(cor_);
        setPadrao(padrao_);
    }

    @Override
    public void setCor(int cor_) {
        super.cor = cor_;
        
    }

    @Override
    public void setPadrao(String padrao_){
        super.padrao = padrao_;
    }

    @Override
    public String getPadrao(){
        return super.padrao;
    }

    @Override 
    public int getCor(){
        return super.cor;
    } 

    @Override
    public String toString(){
        return super.toString() + "Cor: " + getCor() + "Padrão: " + getPadrao();
    }
}
