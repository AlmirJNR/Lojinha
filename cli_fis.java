package lojinha;

public class cli_fis extends cliente{
    private long cpf = 0;

    //<- CPF ->
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public long getCpf() {
        return cpf;
    }
}
