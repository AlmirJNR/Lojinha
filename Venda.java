package lojinha;

import java.io.PrintStream;
import java.util.ArrayList;

public class Venda {
    // -> Irá retornar os produtos comprados e o valor total da compra para o cliente
    protected static PrintStream processoVenda(Cliente clienteX, ArrayList<Cliente> listaClientes, Produtos mercadoriaX, ArrayList<Produtos> listaMercadorias){
        
        if (mercadoriaX.getQntEstoque() - mercadoriaX.getQntComprada() > 0) {
            System.out.printf("%ncomprando...%n%n");
        }
        else {
            return System.out.printf("indisponível no estoque");
        }

        // -> Informação visual para o cliente fisico
        if (clienteX instanceof ClienteFisico) {
            ClienteFisico clienteFisico = (ClienteFisico)clienteX;
            System.out.printf("Você, %s, comprou %s, por um total de: R$%.2f%nSeu CPF: %d, será registrado na nota fiscal e será enviado para o email: %s%n"
            , clienteX.getNome(), mercadoriaX.getNome(), mercadoriaX.getValor(), clienteFisico.getCpf(), clienteX.getEmail());
        }
        // -> Informação visual para o cliente juridico
        else if (clienteX instanceof ClienteJuridico) {
            ClienteJuridico clienteJuridico = (ClienteJuridico)clienteX;
            System.out.printf("Você, %s, comprou %s, por um total de: R$%.2f%nSeu CNPJ: %d, será registrado na nota fiscal e será enviado para o email: %s%n"
            , clienteX.getNome(), mercadoriaX.getNome(), mercadoriaX.getValor(), clienteJuridico.getCnpj(), clienteX.getEmail());
        }

        // -> Retirando do estoque a unidade comprada
        mercadoriaX.setQntEstoque(mercadoriaX.getQntEstoque() - mercadoriaX.getQntComprada());

        // -> Adicionando comprador a lista de compradores do dia
        listaClientes.add(clienteX);

        // -> Adicionando itens vendidos a lista de vendas do dia
        listaMercadorias.add(mercadoriaX);

        return System.out.printf("Obrigado e volte sempre%n");
    }

    // -> Irá retornar uma lista de vendas do dia
    protected static void listaVendas(ArrayList<Cliente> listaClientes, ArrayList<Produtos> listaMercadorias){
        // -> variável local para calculo de lucro do dia
        double lucroTotal = 0;

        for (int i = 0; i < listaMercadorias.size(); i++) {
            // -> Melhor formatação para a apresetação final dos dados
            if (i < listaMercadorias.size()) {
                System.out.println("");
            }

            System.out.printf("<-- Compra %d do dia -->%n", i+1);

            // -> Mostrando qual cliente comprou qual produto e a quantidade de lucro fornecida
            System.out.printf("O cliente " + listaClientes.get(i).getNome() + 
            ", comprou %d unidades de: " + listaMercadorias.get(i).getNome() + "%nCom lucro de: %.2f", 
            listaMercadorias.get(i).getQntComprada(), 
            (listaMercadorias.get(i).getValor() * listaMercadorias.get(i).getQntComprada()));

            // -> Melhor formatação para a apresetação final dos dados
            if (i < listaMercadorias.size()) {
                System.out.println("");
            }

            // -> Realizando o lucro total para demonstar no final da lista
            lucroTotal += listaMercadorias.get(i).getValor() * listaMercadorias.get(i).getQntComprada();
        }

        System.out.printf("%n%nO lucro do dia foi: %.2f", lucroTotal);
    }
}
