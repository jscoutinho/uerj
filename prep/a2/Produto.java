package prep.a2;

public class Produto {
    private String nome;
    private String codigo;
    private float preco;

    public Produto(String nome_, String codigo_, float preco_) throws NomeVazioException, PrecoInvalidoException{
        setNome(nome_);
        setCodigo(codigo_);
        setPreco(preco_);
    }

    
    public void setNome(String nome_) throws NomeVazioException{
        if(nome_ == null || nome_.trim().isEmpty()){
            throw new NomeVazioException("Nome não pode ser vazio");
        }
        else{
            nome = nome_;
        }
    }

    public void setPreco(float preco_) throws PrecoInvalidoException{
        if(preco_ <= 0 ){
            throw new PrecoInvalidoException("O preço deve ser maior que 00.00");
        }
        else{
            preco = preco_;
        }
    }

    public void setCodigo(String codigo_){
        codigo = codigo_;
    }


    public String getNome(){
        return nome;
    }

    public String getCodigo(){
        return codigo;
    }

    public float getPreco(){
        return preco;
    }

    public String toString(){
        return "Nome: " + getNome() + "Código: " + getCodigo() + "Preço: " + getPreco();
    }
}
