package lojinha;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Venda {
    // -> Irá retornar os produtos comprados e o valor total da compra para o cliente
    protected static boolean processoVenda(Cliente clienteX, ArrayList<Cliente> listaClientes, Produtos mercadoriaX, ArrayList<Produtos> listaMercadorias){
        
        if (mercadoriaX.getQntEstoque() - mercadoriaX.getQntComprada() <= 0) {
            System.err.println("Erro: produto com quantidade final de estoque inferior ou igual a zero");
            return false;
        }

        // // -> Informação visual para o cliente fisico
        // if (clienteX instanceof ClienteFisico) {
        //     ClienteFisico clienteFisico = (ClienteFisico)clienteX;
        //     System.out.printf("Você, %s, comprou %s, por um total de: R$%.2f%nSeu CPF: %d, será registrado na nota fiscal e será enviado para o email: %s%n"
        //     , clienteX.getNome(), mercadoriaX.getNome(), mercadoriaX.getValor(), clienteFisico.getCpf(), clienteX.getEmail());
        // }
        // // -> Informação visual para o cliente juridico
        // else if (clienteX instanceof ClienteJuridico) {
        //     ClienteJuridico clienteJuridico = (ClienteJuridico)clienteX;
        //     System.out.printf("Você, %s, comprou %s, por um total de: R$%.2f%nSeu CNPJ: %d, será registrado na nota fiscal e será enviado para o email: %s%n"
        //     , clienteX.getNome(), mercadoriaX.getNome(), mercadoriaX.getValor(), clienteJuridico.getCnpj(), clienteX.getEmail());
        // }

        // -> Retirando do estoque a unidade comprada
        mercadoriaX.setQntEstoque(mercadoriaX.getQntEstoque() - mercadoriaX.getQntComprada());

        // -> Adicionando comprador a lista de compradores do dia
        listaClientes.add(clienteX);

        // -> Adicionando itens vendidos a lista de vendas do dia
        listaMercadorias.add(mercadoriaX);

        System.out.println("Compra efetuada com sucesso");
        return true;
    }

    // -> Irá retornar uma lista de vendas do dia
    protected static void listaVendas(ArrayList<Cliente> listaClientes, ArrayList<Produtos> listaMercadorias){
        // -> Variável local para calculo de lucro do dia
        double lucroTotal = 0;
        // -> Preparando o frame para relatório final
        JFrame frame;
        // -> Preparando a tabela para relatório final
        JTable table;

        // -> Inicialização do Frame
        frame = new JFrame();
        
        // -> Nome das colunas
        String[] nomeDasColunas = { "Cliente", "Produto", "Unidades Compradas", "Quantidade em Estoque", "Preco Unitario", "Lucro Total" };

        // -> Criando a tabela
        String[][] dadosDaTabela = new String[listaClientes.size()][nomeDasColunas.length];

        for (int i = 0; i < listaMercadorias.size(); i++) {
            // -> Data para ser disponibilizado na tabela
            dadosDaTabela[i] = new String[] {listaClientes.get(i).getNome(), listaMercadorias.get(i).getNome(), listaMercadorias.get(i).getQntComprada()+"", listaMercadorias.get(i).getQntEstoque()+"",String.format("R$%.2f", listaMercadorias.get(i).getValor()), (String.format("R$%.2f",listaMercadorias.get(i).getQntComprada() * listaMercadorias.get(i).getValor()))};

            // -> Realizando o lucro total para demonstar no final da lista
            lucroTotal += listaMercadorias.get(i).getValor() * listaMercadorias.get(i).getQntComprada();
        }

        // -> Titulo do Frame
        frame.setTitle(String.format("Relatorio de Vendas - Lucro Total R$%.2f", lucroTotal));

        // -> Inicializando a tabela
        table = new JTable(dadosDaTabela, nomeDasColunas) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            };
        };
        
        // -> Alinhando os dados da tabela
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        // -> Produto
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        // -> Unidades Compradas
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        // -> Quantiade em Estoque
        table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        // -> Preço Unitario
        table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        // -> Lucro Total
        table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );

        // -> Definindo o tamanho da tabela (x, y, largura, altura)
        table.setBounds(30, 40, 200, 300);
        
        // -> Inicializando o JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        // -> Adicionando ao JScrollPane
        frame.add(scrollPane);

        // -> Definindo o tamanho do frame (x, y, largura, altura)
        frame.setSize(750, 200);

        // -> Mostrando o frame
        frame.setVisible(true);

        // -> Fechando o frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
