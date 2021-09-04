package lojinha;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * app
 */
public class app {

    public static void main(String[] args) {
        // -> Instânciando dois novos objetos da subclasse cli_fis
        cli_fis comprador1 = new cli_fis();
        cli_fis comprador2 = new cli_fis();

        // -> Atribuindo valores para instâncias de objetos de uma subclasse
        comprador1.setCpf(89523756183L);
        comprador2.setCpf(56605654331L);

        // -> Atribuindo valores para instâncias de objetos de uma superclasse
        comprador1.setNome("Almir Junior");
        comprador1.setTelefone(31999777863L);
        comprador1.setEmail("almirjunior@consumidor.br");
        comprador1.setEndereço("Belo Horizonte");

        comprador2.setNome("Vitoria Almeida");
        comprador2.setTelefone(23985384569L);
        comprador2.setEmail("vitorialmeida.5894@consumidora.br");
        comprador2.setEndereço("Belo Horizonte");

        // <-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-> //
        // -> Instânciando dois novos objetos da classe produtos
        produtos mercadoria1 = new produtos();
        produtos mercadoria2 = new produtos();

        // -> Atribuindo valores para instâncias de objetos de uma classe
        mercadoria1.setCodigo(574193628L);
        mercadoria1.setNome("Caneta");
        mercadoria1.setValor(2.50);
        mercadoria1.setQntEstoque(100);
        mercadoria1.setQntComprada(5);

        mercadoria2.setCodigo(897523186L);
        mercadoria2.setNome("Lápis");
        mercadoria2.setValor(1.50);
        mercadoria2.setQntEstoque(150);
        mercadoria2.setQntComprada(10);

        // <-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-><-> //
        // -> Criando um arraylist de compradores
        ArrayList<cli_fis> compradores = new ArrayList<>();

        // -> Criando um arraylist de mercadorias
        ArrayList<produtos> itensVendidos = new ArrayList<>();

        // -> Simualação de Compra 1
        Venda(comprador1, compradores, mercadoria1, itensVendidos);

        // -> Adicionando os objetos para um ArrayList ==> Observe como se aplica dentro do método
        // compradores.add(comprador1);
        // itensVendidos.add(mercadoria1);

        // -> Simualação de Compra 2
        Venda(comprador2, compradores, mercadoria2, itensVendidos);

        // -> Adicionando os objetos para um ArrayList ==> Observe como se aplica dentro do método
        // compradores.add(comprador2);
        // itensVendidos.add(mercadoria2);

        // -> Mostrará uma lista de vendas efetuadas no final do dia
        ListaVendas(compradores, itensVendidos);
    }

    // -> Irá retornar os produtos comprados e o valor total da compra para o cliente
    private static PrintStream Venda(cli_fis clienteX, ArrayList<cli_fis> listaClientes, produtos mercadoriaX, ArrayList<produtos> listaMercadorias){
        long cpfCliente = clienteX.getCpf();
        String nomeCliente = clienteX.getNome();
        String emailCliente = clienteX.getEmail();
        
        String nomeMercadoria = mercadoriaX.getNome();
        double valorMercadoria = mercadoriaX.getValor();
        int quantComprada = mercadoriaX.getQntComprada();
        int quantEstoqMercadoria = mercadoriaX.getQntEstoque();

        if (mercadoriaX.getQntEstoque() - quantComprada > 0) {
            System.out.printf("%n%ncomprando...%n%n");
        }
        else{
            return System.out.printf("indisponível no estoque") ;
        }

        // -> Informação visual para o cliente
        System.out.printf("Você, %s, comprou %s, por um total de: R$%.2f%nSeu CPF: %d, será registrado na nota fiscal e será enviado para o email: %s%n"
        , nomeCliente, nomeMercadoria, valorMercadoria, cpfCliente, emailCliente);

        // -> Retirando do estoque a unidade comprada
        mercadoriaX.setQntEstoque(quantEstoqMercadoria - quantComprada);

        // -> Adicionando comprador a lista de compradores do dia
        listaClientes.add(clienteX);

        // -> Adicionando itens vendidos a lista de vendas do dia
        listaMercadorias.add(mercadoriaX);

        return System.out.printf("Obrigado e volte sempre");
    }

    // -> Irá retornar uma lista de vendas do dia
    private static void ListaVendas(ArrayList<cli_fis> listaClientes, ArrayList<produtos> listaMercadorias){
        // -> variável local para calculo de lucro do dia
        double lucroTotal = 0;

        for (int i = 0; i < listaMercadorias.size(); i++) {
            // -> Melhor formatação para a apresetação final dos dados
            if (i < listaMercadorias.size() - 1) {
                System.out.printf("%n%n");
            }

            System.out.printf("<-- Compra %d do dia -->%n", i+1);

            // -> Mostrando qual cliente comprou qual produto e a quantidade de lucro fornecida
            System.out.printf("O cliente " + listaClientes.get(i).getNome() + 
            ", comprou %d unidades de: " + listaMercadorias.get(i).getNome() + "%nCom lucro de: %.2f", 
            listaMercadorias.get(i).getQntComprada(), 
            (listaMercadorias.get(i).getValor() * listaMercadorias.get(i).getQntComprada()));

            // -> Melhor formatação para a apresetação final dos dados
            if (i < listaMercadorias.size() - 1) {
                System.out.println("");
            }

            // -> Realizando o lucro total para demonstar no final da lista
            lucroTotal += listaMercadorias.get(i).getValor() * listaMercadorias.get(i).getQntComprada();
        }

        System.out.printf("%n%nO lucro do dia foi: %.2f", lucroTotal);
    }
}