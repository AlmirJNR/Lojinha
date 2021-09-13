package lojinha;

import java.util.ArrayList;

/**
 * app
 */
public class App {

    public static void main(String[] args) {
        
        //Códigos .set comentados, servindo apenas como demonstração de como seria atribuir valores a objetos sem utilizar os construtores;

        ArrayList<Cliente> clientesRegistrados = new ArrayList<Cliente>();

        // -> Instânciando dois novos objetos da subclasse Cliente_Fisico
        ClienteFisico comprador1 = new ClienteFisico("Almir Junior", 89523756183L, new Telefone(31, 999777863L), "almirjunior@consumidor.br", new Endereco("Brasil", "Minas Gerais", "Belo Horizonte", "Céu Azul", "Bambu", 598));
        ClienteFisico comprador2 = new ClienteFisico("Vitoria Almeida", 56605654331L, new Telefone(23, 985384569L), "vitorialmeida@consumidora.br", new Endereco("Brasil", "São Paulo", "São Paulo", "Pinheiros", "Avestruz", 952, 63));
        ClienteJuridico comprador3 = new ClienteJuridico("Locacao de Veiculos e Fretamento", "LocaMaisViagens", 39218749L, new Telefone(33, 230129556L), "locamaisviagens@emopresa.br", new Endereco("Brasil", "Rio de Janeiro", "Rio de Janeiro", "Copacabana", "Girafa", 512));
        ClienteJuridico comprador4 = new ClienteJuridico("Abatedouro Vigente Monarquia", "Carninha Do Zé", 896321749L, new Telefone(39, 984321866L), "CarninhaDoZe@emopresa.br", new Endereco("Brasil", "Rio de Janeiro", "Rio de Janeiro", "São José da Lapa", "Albuquerque", 982, 52));

        clientesRegistrados.add(comprador1);
        clientesRegistrados.add(comprador2);
        clientesRegistrados.add(comprador3);
        clientesRegistrados.add(comprador4);

        System.out.println("!!== Lista de clientes registrados no banco ==!!\n");

        for (int i = 0; i < clientesRegistrados.size(); i++) {
            // -> Mostrando maneiras diferentes de se obter todos os dados de determinados clientes
            System.out.println("Seu nome é: " + clientesRegistrados.get(i).getNome());

            // -> Verificando se o cliente é Pessoa Fisica Ou Pessoa Jurídica
            if (clientesRegistrados.get(i) instanceof ClienteFisico) {
                ClienteFisico clienteFisico = (ClienteFisico)clientesRegistrados.get(i);
                System.out.println("Seu cpf é: " + clienteFisico.getCpf()); 
            }
            else if (clientesRegistrados.get(i) instanceof ClienteJuridico) {
                ClienteJuridico clienteJuridico = (ClienteJuridico)clientesRegistrados.get(i);
                System.out.println("Seu nome fantasia é: " + clienteJuridico.getNomeFantasia());
                System.out.println("Seu cnpj é: " + clienteJuridico.getCnpj());
            }

            System.out.println("Seu DDD é: " + clientesRegistrados.get(i).getTelefoneDDD());
            System.out.println("Seu número é: " + clientesRegistrados.get(i).getTelefoneNumero());
            System.out.println("Seu DDD + número é: " + clientesRegistrados.get(i).getTelefoneDDDNumero().ddd + " " + comprador1.getTelefoneDDDNumero().numero);
            
            // -> Mostrando maneiras diferentes de se obter um dado Endereço utilizando classes e métodos
            System.out.println("Seu país é: " + clientesRegistrados.get(i).getEnderecoPais());
            System.out.println("Seu estado é: " + clientesRegistrados.get(i).getEnderecoEstado());
            System.out.println("Sua cidade é: " + clientesRegistrados.get(i).getEnderecoCidade());
            System.out.println("Seu bairro é: " + clientesRegistrados.get(i).getEnderecoBairro());
            System.out.println("Sua rua é: " + clientesRegistrados.get(i).getEnderecoRua());
            System.out.println("Seu número de logradouro é: " + clientesRegistrados.get(i).getEnderecoNumeroLogradouro());

            if (clientesRegistrados.get(i).getEnderecoApartamento() != 0) {
                System.out.println("Seu número de apartamento é: " + clientesRegistrados.get(i).getEnderecoApartamento());
                System.out.println();
            }
            else {
                System.out.println();
            }

            if (i == clientesRegistrados.size() - 1) {
                System.out.println("!!== Final da lista de clientes registrados no banco ==!!");    
            }
        }

        // // -> Atribuindo valores para instâncias de objetos de uma subclasse
        // comprador1.setCpf(89523756183L);
        // comprador2.setCpf(56605654331L);

        // // -> Atribuindo valores para instâncias de objetos de uma superclasse
        // comprador1.setNome("Almir Junior");
        // comprador1.setTelefone(31999777863L);
        // comprador1.setEmail("almirjunior@consumidor.br");
        // comprador1.setEndereço("Belo Horizonte");

        // comprador2.setNome("Vitoria Almeida");
        // comprador2.setTelefone(23985384569L);
        // comprador2.setEmail("vitorialmeida@consumidora.br");
        // comprador2.setEndereço("Belo Horizonte");

        // <-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-> //
        // -> Instânciando dois novos objetos da classe Produtos
        Produtos mercadoria1 = new Produtos(574193628L, "Caneta", 2.50, 100, 5);
        Produtos mercadoria2 = new Produtos(897523186L, "Lápis", 1.50, 150, 10);

        // // -> Atribuindo valores para instâncias de objetos de uma classe
        // mercadoria1.setCodigo(574193628L);
        // mercadoria1.setNome("Caneta");
        // mercadoria1.setValor(2.50);
        // mercadoria1.setQntEstoque(100);
        // mercadoria1.setQntComprada(5);

        // mercadoria2.setCodigo(897523186L);
        // mercadoria2.setNome("Lápis");
        // mercadoria2.setValor(1.50);
        // mercadoria2.setQntEstoque(150);
        // mercadoria2.setQntComprada(10);

        // <-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-> //
        // -> Criando um arraylist de compradores
        ArrayList<ClienteFisico> compradores = new ArrayList<>();

        // -> Criando um arraylist de mercadorias
        ArrayList<Produtos> itensVendidos = new ArrayList<>();

        // -> Simualação de Compra 1
        Venda.processoVenda(comprador1, compradores, mercadoria1, itensVendidos);

        // -> Adicionando os objetos para um ArrayList ==> Observe como se aplica dentro do método
        // compradores.add(comprador1);
        // itensVendidos.add(mercadoria1);

        // -> Simualação de Compra 2
        Venda.processoVenda(comprador2, compradores, mercadoria2, itensVendidos);

        // -> Adicionando os objetos para um ArrayList ==> Observe como se aplica dentro do método
        // compradores.add(comprador2);
        // itensVendidos.add(mercadoria2);

        // -> Mostrará uma lista de vendas efetuadas no final do dia
        Venda.listaVendas(compradores, itensVendidos);
    }
}