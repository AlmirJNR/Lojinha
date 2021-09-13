package lojinha;

public class Endereco {
    String pais;
    String estado;
    String cidade;
    String bairro;
    String rua;
    int numeroLogradouro;
    int numeroApartamento;

    //Este é um construtor padrão
    Endereco() {}

    //Este é um construtor completo para caso endereço seja logradouro do tipo casa;
    Endereco(String pais, String estado, String cidade, String bairro, String rua, int numeroLogradouro) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroLogradouro = numeroLogradouro;
    }

    //Este é um construtor completo para caso endereço seja apartamento;
    Endereco(String pais, String estado, String cidade, String bairro, String rua, int numeroLogradouro, int numeroApartamento) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroLogradouro = numeroLogradouro;
        this.numeroApartamento = numeroApartamento;
    }

    //<- País ->
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getPais() {
        return pais;
    }

    //<- Estado ->
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }

    //<- Cidade ->
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getCidade() {
        return cidade;
    }

    //<- Bairro ->
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getBairro() {
        return bairro;
    }

    //<- Rua ->
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getRua() {
        return rua;
    }

    //<- Numero Logradouro ->
    public void setNumeroLogradouro(int numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }
    public int getNumeroLogradouro() {
        return numeroLogradouro;
    }

    //<- Numero Apartamento ->
    public void setNumeroApartamento(int numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }
    public int getNumeroApartamento() {
        return numeroApartamento;
    }
}
