package lojinha;

public class ClienteJuridico extends Cliente{
    private long cnpj = 0;
    private String nomeFantasia = "";

    //This is a Default Constructor
    ClienteJuridico() {}
    
    //This is a Complete Constructor
    ClienteJuridico(String nome, String nomeFantasia, long cnpj, long telefone, String email, String endereco) {
        super(nome, telefone, email, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    //<- CNPJ ->
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
    public long getCnpj() {
        return cnpj;
    }

    //<- NomeFantasia ->
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
