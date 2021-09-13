package lojinha;

public class ClienteFisico extends Cliente{
    private long cpf = 0;

    //<- CPF ->
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public long getCpf() {
        return cpf;
    }
}
