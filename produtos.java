package lojinha;

public class produtos {
    long codigo = 0;
    String nome = "";
    double valor = 0;
    int qntComprada = 0;
    int qntEstoque = 0;

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
