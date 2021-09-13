package lojinha;

import java.util.ArrayList;

/**
 * app
 */
public class App {

    public static void main(String[] args) {
        //Códigos .set comentados, servindo apenas como demonstração de como seria atribuir valores a objetos sem utilizar os construtores;

        // -> Instânciando dois novos objetos da subclasse Cliente_Fisico
        ClienteFisico comprador1 = new ClienteFisico("Almir Junior", 89523756183L, 31999777863L, "almirjunior@consumidor.br", "Belo Horizonte");
        ClienteFisico comprador2 = new ClienteFisico("Vitoria Almeida", 56605654331L, 23985384569L, "vitorialmeida@consumidora.br", "Belo Horizonte");

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