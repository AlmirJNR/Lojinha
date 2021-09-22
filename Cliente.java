package lojinha;

import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import lojinha.bancoDeDados.Conexao;

public class Cliente {
    private String nome;
    private Telefone telefone;
    private String email;
    private Endereco endereco;

    // Este é um construtor padrão
    Cliente() {
    }

    // Este é um construtor completo
    Cliente(String nome, Telefone telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // <- Nome ->
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // <- Telefone Classe ->
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

    // <- Email ->
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // <- Endereço Classe ->
    public void setEnderecoCasa(String enderecoPais, String enderecoEstado, String enderecoCidade,
            String enderecoBairro, String enderecoRua, int enderecoNumeroLogradouro) {
        this.endereco.pais = enderecoPais;
        this.endereco.estado = enderecoEstado;
        this.endereco.cidade = enderecoCidade;
        this.endereco.bairro = enderecoBairro;
        this.endereco.rua = enderecoRua;
        this.endereco.numeroLogradouro = enderecoNumeroLogradouro;
    }

    public void setEnderecoApartamento(String enderecoPais, String enderecoEstado, String enderecoCidade,
            String enderecoBairro, String enderecoRua, int enderecoNumeroLogradouro, int enderecoNumeroApartamento) {
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

    //Construtor do Cliente para o banco de dados
    public Cliente(Cliente cliente) throws SQLException {

        String adicionandoAoBanco = "INSERT INTO clientes(nome, nome_fantasia, cpf, cnpj, telefone, email, endereco) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = Conexao.conexao.prepareStatement(adicionandoAoBanco);

            if (cliente instanceof ClienteFisico) {
                ClienteFisico clienteFisico = (ClienteFisico) cliente;
                pstmt.setString(1, clienteFisico.getNome());
                pstmt.setString(2, "null");
                pstmt.setLong(3, clienteFisico.getCpf());
                pstmt.setLong(4, 0);
                pstmt.setString(5, clienteFisico.getTelefoneDDD() + "" + clienteFisico.getTelefoneNumero());
                pstmt.setString(6, clienteFisico.getEmail());
                pstmt.setString(7, clienteFisico.getEnderecoPais() + "," + clienteFisico.getEnderecoEstado() + ","
                        + clienteFisico.getEnderecoCidade() + "," + clienteFisico.getEnderecoBairro() + ","
                        + clienteFisico.getEnderecoRua() + "," + clienteFisico.getEnderecoNumeroLogradouro() + ","
                        + (clienteFisico.getEnderecoApartamento() != 0 ? clienteFisico.getEnderecoApartamento()
                                : "Casa"));
            }

            else if (cliente instanceof ClienteJuridico) {
                ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
                pstmt.setString(1, clienteJuridico.getNome());
                pstmt.setString(2, clienteJuridico.getNomeFantasia());
                pstmt.setLong(3, 0);
                pstmt.setLong(4, clienteJuridico.getCnpj());
                pstmt.setString(5, clienteJuridico.getTelefoneDDD() + "" + clienteJuridico.getTelefoneNumero());
                pstmt.setString(6, clienteJuridico.getEmail());
                pstmt.setString(7, clienteJuridico.getEnderecoPais() + "," + clienteJuridico.getEnderecoEstado() + ","
                        + clienteJuridico.getEnderecoCidade() + "," + clienteJuridico.getEnderecoBairro() + ","
                        + clienteJuridico.getEnderecoRua() + "," + clienteJuridico.getEnderecoNumeroLogradouro() + ","
                        + (clienteJuridico.getEnderecoApartamento() != 0 ? clienteJuridico.getEnderecoApartamento() : "Casa"));
            }

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

        // Caso deseje debugar algo no codigo do banco, descomente as linhas abaixo
        // ResultSet resultSet = Conexao.statement
        //         .executeQuery("SELECT id, nome, nome_fantasia, cpf, cnpj, telefone, email, endereco FROM clientes");
    
        // while (resultSet.next()) {
        //     int id = resultSet.getInt("id");
        //     String nome = resultSet.getString("nome");

        //     System.out.println("ID: " + id);
        //     System.out.println("ID: " + nome);
        // }
    }
}
