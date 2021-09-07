package lojinha;

public class cli_jur extends cliente{
    private long cnpj = 0;
    private String nomeFantasia = "";

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
