package lojinha;

public class Cliente {
    private String nome;
    private Telefone telefone;
    private String email;
    private Endereco endereco;

    //Este é um construtor padrão
    Cliente() {}
    
    //Este é um construtor completo
    Cliente(String nome, Telefone telefone, String email, Endereco endereco) {
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

    //<- Telefone Classe ->
    public void setTelefone(int telefoneDDD, long telefoneNumero) {
        this.telefone.ddd = telefoneDDD;
        this.telefone.numero = telefoneNumero;
    }
    public long getTelefoneDDD() {
        return telefone.getDDD();
    }
    public long getTelefoneNumero() {
        return telefone.getNumero();
    }
    public Telefone getTelefoneDDDNumero() {
        return telefone;
    }

    //<- Email ->
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    // <- Endereço Classe ->
    public void setEnderecoCasa(String enderecoPais, String enderecoEstado, String enderecoCidade, String enderecoBairro, String enderecoRua, int enderecoNumeroLogradouro) {
        this.endereco.pais = enderecoPais;
        this.endereco.estado = enderecoEstado;
        this.endereco.cidade = enderecoCidade;
        this.endereco.bairro = enderecoBairro;
        this.endereco.rua = enderecoRua;
        this.endereco.numeroLogradouro = enderecoNumeroLogradouro;
    }
    public void setEnderecoApartamento(String enderecoPais, String enderecoEstado, String enderecoCidade, String enderecoBairro, String enderecoRua, int enderecoNumeroLogradouro, int enderecoNumeroApartamento) {
        this.endereco.pais = enderecoPais;
        this.endereco.estado = enderecoEstado;
        this.endereco.cidade = enderecoCidade;
        this.endereco.bairro = enderecoBairro;
        this.endereco.rua = enderecoRua;
        this.endereco.numeroLogradouro = enderecoNumeroLogradouro;
        this.endereco.numeroApartamento = enderecoNumeroApartamento;
    }
    public String getEnderecoPais() {
        return endereco.pais;
    }
    public String getEnderecoEstado() {
        return endereco.estado;
    }
    public String getEnderecoCidade() {
        return endereco.cidade;
    }
    public String getEnderecoBairro() {
        return endereco.bairro;
    }
    public String getEnderecoRua() {
        return endereco.rua;
    }
    public int getEnderecoNumeroLogradouro() {
        return endereco.numeroLogradouro;
    }
    public int getEnderecoApartamento() {
        return endereco.numeroApartamento;
    }
    public Endereco getEnderecoCompleto() {
        return endereco;
    }
}
