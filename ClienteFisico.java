package lojinha;

public class ClienteFisico extends Cliente{
    private long cpf = 0;

    //This is a Default Constructor
    ClienteFisico(){

    }
    
    //This is a Complete Constructor
    ClienteFisico(String nome, long cpf, long telefone, String email, String endereço){
        super(nome, telefone, email, endereço);
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
