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

        
        ArrayList<Cliente> clientesBancoDeDados = new ArrayList<Cliente>();

        // -> Instânciando quatro novos objetos da super classe Cliente, 2 sendo da subclasse ClienteFisico e 2 da subclasse ClienteJuridico
        clientesBancoDeDados.add(new ClienteFisico("Almir Junior", 89523756183L, new Telefone(31, 999777863L), "almirjunior@consumidor.br", new Endereco("Brasil", "Minas Gerais", "Belo Horizonte", "Céu Azul", "Bambu", 598)));
        clientesBancoDeDados.add(new ClienteFisico("Vitoria Almeida", 56605654331L, new Telefone(23, 985384569L), "vitorialmeida@consumidora.br", new Endereco("Brasil", "São Paulo", "São Paulo", "Pinheiros", "Avestruz", 952, 63)));
        clientesBancoDeDados.add(new ClienteJuridico("Locacao de Veiculos e Fretamento", "LocaMaisViagens", 39218749L, new Telefone(33, 230129556L), "locamaisviagens@emopresa.br", new Endereco("Brasil", "Rio de Janeiro", "Rio de Janeiro", "Copacabana", "Girafa", 512)));
        clientesBancoDeDados.add(new ClienteJuridico("Abatedouro Vigente Monarquia", "Carninha Do Zé", 896321749L, new Telefone(39, 984321866L), "CarninhaDoZe@emopresa.br", new Endereco("Brasil", "Rio de Janeiro", "Rio de Janeiro", "São José da Lapa", "Albuquerque", 982, 52)));

        for (int i = 0; i < clientesBancoDeDados.size(); i++) {
            // -> Mostrando maneiras diferentes de se obter todos os dados de determinados clientes
            // -> Verificando se o cliente é Pessoa Fisica Ou Pessoa Jurídica -> PARTE 1
            if (clientesBancoDeDados.get(i) instanceof ClienteFisico) {
                ClienteFisico clienteFisico = (ClienteFisico)clientesBancoDeDados.get(i);
                JOptionPane.showMessageDialog(null, 
                    "Nome: " + clientesBancoDeDados.get(i).getNome() + "\n" +
                    "Cpf: " + clienteFisico.getCpf() + "\n" +
                    "DDD + Telefone: " + clientesBancoDeDados.get(i).getTelefoneDDDNumero().ddd +" "+clientesBancoDeDados.get(i).getTelefoneDDDNumero().numero + "\n" +
                    // -> Mostrando maneiras diferentes de se obter um dado Endereço
                    "País: " + clientesBancoDeDados.get(i).getEnderecoPais() + "\n" +
                    "Estado: " + clientesBancoDeDados.get(i).getEnderecoEstado() + "\n" +
                    "Cidade: " + clientesBancoDeDados.get(i).getEnderecoCidade() + "\n" +
                    "Bairro: " + clientesBancoDeDados.get(i).getEnderecoRua() + "\n" +
                    "Rua: " + clientesBancoDeDados.get(i).getEnderecoRua() + "\n" +
                    "Logradouro: " + clientesBancoDeDados.get(i).getEnderecoNumeroLogradouro() + "\n" +
                    // -> Verificando se a Pessoa Física possuí apartamento ou não
                    (clientesBancoDeDados.get(i).getEnderecoApartamento() != 0 ? "Apartamento: " + clientesBancoDeDados.get(i).getEnderecoApartamento() : ""), 
                    "Dados dos clientes", JOptionPane.INFORMATION_MESSAGE);
            }
            // -> Verificando se o cliente é Pessoa Fisica Ou Pessoa Jurídica -> PARTE 2
            else if (clientesBancoDeDados.get(i) instanceof ClienteJuridico) {
                ClienteJuridico clienteJuridico = (ClienteJuridico)clientesBancoDeDados.get(i);
                JOptionPane.showMessageDialog(null, 
                    "Nome: " + clientesBancoDeDados.get(i).getNome() + "\n" +
                    "Nome Fantasia: " + clienteJuridico.getNomeFantasia() + "\n" +
                    "CNPJ: " + clienteJuridico.getCnpj() + "\n" +
                    "DDD + Telefone: " + clientesBancoDeDados.get(i).getTelefoneDDDNumero().ddd +" "+clientesBancoDeDados.get(i).getTelefoneDDDNumero().numero + "\n" +
                    // -> Mostrando maneiras diferentes de se obter um dado Endereço
                    "País: " + clientesBancoDeDados.get(i).getEnderecoPais() + "\n" +
                    "Estado: " + clientesBancoDeDados.get(i).getEnderecoEstado() + "\n" +
                    "Cidade: " + clientesBancoDeDados.get(i).getEnderecoCidade() + "\n" +
                    "Bairro: " + clientesBancoDeDados.get(i).getEnderecoRua() + "\n" +
                    "Rua: " + clientesBancoDeDados.get(i).getEnderecoRua() + "\n" +
                    "Logradouro: " + clientesBancoDeDados.get(i).getEnderecoNumeroLogradouro() + "\n" +
                    // -> Verificando se a Pessoa Jurídica possuí apartamento ou não
                    (clientesBancoDeDados.get(i).getEnderecoApartamento() != 0 ? "Apartamento: " + clientesBancoDeDados.get(i).getEnderecoApartamento() : ""), 
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
        Venda.processoVenda(clientesBancoDeDados.get(0), compradores, mercadoria1, itensVendidos);

        // -> Simualação de Compra 2
        Venda.processoVenda(clientesBancoDeDados.get(1), compradores, mercadoria2, itensVendidos);

        // -> Simualação de Compra 3
        Venda.processoVenda(clientesBancoDeDados.get(2), compradores, mercadoria2, itensVendidos);

        // -> Simualação de Compra 4
        Venda.processoVenda(clientesBancoDeDados.get(3), compradores, mercadoria1, itensVendidos);

        // -> Mostrará uma lista de vendas efetuadas no final do dia
        Venda.listaVendas(compradores, itensVendidos);

        // -> Fechando a conexao com o banco
        dataBaseConexao.fecharConexao();
    }
}