# Exercício

Criar um programa para simular uma lojinha, com as seguintes classes: 
- Cliente:
    - Atributos:
        - nome;
        - telefone;
        - email;
        - endereco;
    - Subclasses de Cliente:
        - Físico:
            - Atributos:
                - cpf;
        - Jurídico:
            - Atributos:
                - cnpj;
                - nome fantasia;

- Produtos:
    - Atributos:
        - codigo;
        - nome;
        - valor;
        - quantidadeEstoque;

- Venda:
    - Utilizar das Classes:
        - Cliente
        - Produtos
    - Métodos:
        - Calcular o valor total da compra para o cliente;
        - Calcular o valor total do faturamento da loja;
        - Mostrar os produtos comprados pelo cliente;
        - Crie uma lista de vendas do dia;

## Principal
Obs:
- Use atributos **private** sempre que possível e métodos **get** e **set**.