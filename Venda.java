package lojinha;

import java.io.PrintStream;
import java.util.ArrayList;

public class Venda {
    // -> Irá retornar os produtos comprados e o valor total da compra para o cliente
    protected static PrintStream processoVenda(ClienteFisico clienteX, ArrayList<ClienteFisico> listaClientes, Produtos mercadoriaX, ArrayList<Produtos> listaMercadorias){
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
    protected static void listaVendas(ArrayList<ClienteFisico> listaClientes, ArrayList<Produtos> listaMercadorias){
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
