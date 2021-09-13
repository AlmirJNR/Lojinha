package lojinha;

public class Produtos {
    private long codigo = 0;
    private String nome = "";
    private double valor = 0;
    private int qntEstoque = 0;
    private int qntComprada = 0;

    //This is a Default Constructor
    Produtos(){}
    
    //This is a Complete Constructor
    Produtos(long codigo, String nome, double valor, int qntEstoque, int quantComprada){
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.qntEstoque = qntEstoque;
        this.qntComprada = quantComprada;
    }

    //<- Codigo ->
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public long getCodigo() {
        return codigo;
    }

    //<- Nome ->
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    //<- Valor ->
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getValor() {
        return valor;
    }

    //<- Quantidade Comprada ->
    public void setQntComprada(int qntComprada) {
        this.qntComprada = qntComprada;
    }
    public int getQntComprada() {
        return qntComprada;
    }

    //<- Quantidade em Estoque ->
    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }
    public int getQntEstoque() {
        return qntEstoque;
    }

}
