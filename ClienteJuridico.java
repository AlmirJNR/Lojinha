package lojinha;

public class ClienteJuridico extends Cliente{
    private long cnpj;
    private String nomeFantasia;

    //Este é um construtor padrão
    ClienteJuridico() {}
    
    //Este é um construtor completo
    ClienteJuridico(String nome, String nomeFantasia, long cnpj, Telefone telefone, String email, Endereco endereco) {
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
