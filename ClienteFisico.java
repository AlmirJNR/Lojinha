package lojinha;

public class ClienteFisico extends Cliente{
    private long cpf = 0;

    //Este é um construtor padrão
    ClienteFisico(){

    }
    
    //Este é um construtor completo
    ClienteFisico(String nome, long cpf, Telefone telefone, String email, Endereco endereco){
        super(nome, telefone, email, endereco);
        this.cpf = cpf;
    }

    //<- CPF ->
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public long getCpf() {
        return cpf;
    }
}
