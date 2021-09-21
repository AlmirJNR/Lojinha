package lojinha;

import java.io.IOException;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import lojinha.bancoDeDados.Conexao;

/**
 * app
 */
public class App {

    public static void main(String[] args) throws SQLException, IOException {
        // -> Verificando a conexão com o banco de dados
        Conexao dataBaseConexao = new Conexao();
        dataBaseConexao.getConexao();
        
        ArrayList<Cliente> clientesRegistrados = new ArrayList<Cliente>();

        // -> Instânciando dois novos objetos da subclasse Cliente_Fisico
        Cliente comprador1 = new ClienteFisico("Almir Junior", 89523756183L, new Telefone(31, 999777863L), "almirjunior@consumidor.br", new Endereco("Brasil", "Minas Gerais", "Belo Horizonte", "Céu Azul", "Bambu", 598));
        Cliente comprador2 = new ClienteFisico("Vitoria Almeida", 56605654331L, new Telefone(23, 985384569L), "vitorialmeida@consumidora.br", new Endereco("Brasil", "São Paulo", "São Paulo", "Pinheiros", "Avestruz", 952, 63));
        Cliente comprador3 = new ClienteJuridico("Locacao de Veiculos e Fretamento", "LocaMaisViagens", 39218749L, new Telefone(33, 230129556L), "locamaisviagens@emopresa.br", new Endereco("Brasil", "Rio de Janeiro", "Rio de Janeiro", "Copacabana", "Girafa", 512));
        Cliente comprador4 = new ClienteJuridico("Abatedouro Vigente Monarquia", "Carninha Do Zé", 896321749L, new Telefone(39, 984321866L), "CarninhaDoZe@emopresa.br", new Endereco("Brasil", "Rio de Janeiro", "Rio de Janeiro", "São José da Lapa", "Albuquerque", 982, 52));

        // -> Adicionando compradores no ArrayList de clientesRegistrados
        clientesRegistrados.add(comprador1);
        clientesRegistrados.add(comprador2);
        clientesRegistrados.add(comprador3);
        clientesRegistrados.add(comprador4);

        for (int i = 0; i < clientesRegistrados.size(); i++) {
            // -> Mostrando maneiras diferentes de se obter todos os dados de determinados clientes
            // -> Verificando se o cliente é Pessoa Fisica Ou Pessoa Jurídica -> PARTE 1
            if (clientesRegistrados.get(i) instanceof ClienteFisico) {
                ClienteFisico clienteFisico = (ClienteFisico)clientesRegistrados.get(i);
                JOptionPane.showMessageDialog(null, 
                    "Nome: " + clientesRegistrados.get(i).getNome() + "\n" +
                    "Cpf: " + clienteFisico.getCpf() + "\n" +
                    "DDD + Telefone: " + clientesRegistrados.get(i).getTelefoneDDDNumero().ddd +" "+clientesRegistrados.get(i).getTelefoneDDDNumero().numero + "\n" +
                    // -> Mostrando maneiras diferentes de se obter um dado Endereço
                    "País: " + clientesRegistrados.get(i).getEnderecoPais() + "\n" +
                    "Estado: " + clientesRegistrados.get(i).getEnderecoEstado() + "\n" +
                    "Cidade: " + clientesRegistrados.get(i).getEnderecoCidade() + "\n" +
                    "Bairro: " + clientesRegistrados.get(i).getEnderecoRua() + "\n" +
                    "Rua: " + clientesRegistrados.get(i).getEnderecoRua() + "\n" +
                    "Logradouro: " + clientesRegistrados.get(i).getEnderecoNumeroLogradouro() + "\n" +
                    // -> Verificando se a Pessoa Física possuí apartamento ou não
                    (clientesRegistrados.get(i).getEnderecoApartamento() != 0 ? "Apartamento: " + clientesRegistrados.get(i).getEnderecoApartamento() : ""), 
                    "Dados dos clientes", JOptionPane.INFORMATION_MESSAGE);
            }
            // -> Verificando se o cliente é Pessoa Fisica Ou Pessoa Jurídica -> PARTE 2
            else if (clientesRegistrados.get(i) instanceof ClienteJuridico) {
                ClienteJuridico clienteJuridico = (ClienteJuridico)clientesRegistrados.get(i);
                JOptionPane.showMessageDialog(null, 
                    "Nome: " + clientesRegistrados.get(i).getNome() + "\n" +
                    "Nome Fantasia: " + clienteJuridico.getNomeFantasia() + "\n" +
                    "CNPJ: " + clienteJuridico.getCnpj() + "\n" +
                    "DDD + Telefone: " + clientesRegistrados.get(i).getTelefoneDDDNumero().ddd +" "+clientesRegistrados.get(i).getTelefoneDDDNumero().numero + "\n" +
                    // -> Mostrando maneiras diferentes de se obter um dado Endereço
                    "País: " + clientesRegistrados.get(i).getEnderecoPais() + "\n" +
                    "Estado: " + clientesRegistrados.get(i).getEnderecoEstado() + "\n" +
                    "Cidade: " + clientesRegistrados.get(i).getEnderecoCidade() + "\n" +
                    "Bairro: " + clientesRegistrados.get(i).getEnderecoRua() + "\n" +
                    "Rua: " + clientesRegistrados.get(i).getEnderecoRua() + "\n" +
                    "Logradouro: " + clientesRegistrados.get(i).getEnderecoNumeroLogradouro() + "\n" +
                    // -> Verificando se a Pessoa Jurídica possuí apartamento ou não
                    (clientesRegistrados.get(i).getEnderecoApartamento() != 0 ? "Apartamento: " + clientesRegistrados.get(i).getEnderecoApartamento() : ""), 
                    "Dados dos clientes", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // <-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-> //

        // -> Instânciando dois novos objetos da classe Produtos
        Produtos mercadoria1 = new Produtos(574193628L, "Caneta", 2.50, 100, 5);
        Produtos mercadoria2 = new Produtos(897523186L, "Lápis", 1.50, 150, 10);
        // <-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-> //

        // -> Criando um arraylist de compradores
        ArrayList<Cliente> compradores = new ArrayList<>();

        // -> Criando um arraylist de mercadorias
        ArrayList<Produtos> itensVendidos = new ArrayList<>();

        // -> Simualação de Compra 1
        Venda.processoVenda(comprador1, compradores, mercadoria1, itensVendidos);

        // -> Simualação de Compra 2
        Venda.processoVenda(comprador2, compradores, mercadoria2, itensVendidos);

        // -> Simualação de Compra 3
        Venda.processoVenda(comprador3, compradores, mercadoria2, itensVendidos);

        // -> Simualação de Compra 4
        Venda.processoVenda(comprador4, compradores, mercadoria1, itensVendidos);

        // -> Mostrará uma lista de vendas efetuadas no final do dia
        Venda.listaVendas(compradores, itensVendidos);

        dataBaseConexao.fecharConexao();
    }
}