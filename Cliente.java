package lojinha;

public class Cliente {
    private String nome = "";
    private long telefone = 0;
    private String email = "";
    private String endereco = "";

    //This is a Default Constructor
    Cliente() {}
    
    //This is a Complete Constructor
    Cliente(String nome, long telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //<- Nome ->
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    //<- Telefone ->
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    public long getTelefone() {
        return telefone;
    }

    //<- Email ->
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    //<- Endereço ->
    public void setEndereço(String endereço) {
        this.endereco = endereço;
    }
    public String getEndereço() {
        return endereco;
    }
}
