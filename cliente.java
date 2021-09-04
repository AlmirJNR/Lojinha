package lojinha;

public class cliente {
    String nome = "";
    long telefone = 0;
    String email = "";
    String endereço = "";

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
        this.endereço = endereço;
    }
    public String getEndereço() {
        return endereço;
    }
}
