package lojinha;

public class cli_jur extends cliente{
    long cnpj = 0;
    String nomeFantasia = "";

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
