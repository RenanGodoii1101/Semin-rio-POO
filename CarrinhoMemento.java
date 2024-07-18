public class CarrinhoMemento {
    private Produto[] produtos;

    public CarrinhoMemento(Produto[] produtos) {
        this.produtos = new Produto[produtos.length];
        for (int i = 0; i < produtos.length; i++) {
            this.produtos[i] = new Produto(produtos[i].getCodigo(), produtos[i].getNome(), produtos[i].getPreco(), produtos[i].getEstoque(), produtos[i].getQnt());
        }
    }

    public Produto[] getProdutos() {
        return produtos;
    }
}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produto produtos[] = new Produto[3];
        produtos[0] = new Produto(1, "001", 11.99, 1001, 0);
        produtos[1] = new Produto(2, "002", 19.99, 1002, 0);
        produtos[2] = new Produto(3, "003", 29.99, 1003, 0);

        Originator originator = new Originator(produtos);
        Caretaker caretaker = new Caretaker();
        caretaker.saveState(produtos); // Salvar estado inicial

        int n = 0, qnt = 0, fim = 0;

        while (fim != -1) {
            n = 0;
            System.out.println("Carrinho de compras:");
            for (int i = 0; i < 3; i++) {
                if (produtos[i].getQnt() > 0) {
                    System.out.println(produtos[i].carrinhoDados());
                    n++;
                }
            }
            if (n == 0) {
                System.out.println("Sem itens.");
            }
            System.out.println("\nPara vizualizar a loja, digite 0.\nPara remover um produto do carrinho ou alterar sua quantidade, digite seu codigo\nPara desfazer a última operação, digite 9\nPara finalizar o carrinho, digite -1");
            fim = sc.nextInt();
            if (fim == 0) {
                n = 0;
                while (n != -1) {
                    System.out.println("Lista de produtos a venda: ");
                    for (int qtdAtual = 0; qtdAtual < 3; qtdAtual++) {
                        System.out.println(produtos[qtdAtual].imprimeDados());
                    }
                    System.out.println("Digite -1 para vizualizar o carrinho de compras ou, para adicionar algum produto ao carrinho de compras, digite seu numero: ");
                    n = sc.nextInt();
                    if (n > 0 && n <= 3) {
                        System.out.println("Selecione a quantidade (MAX: " + produtos[n - 1].getEstoque() + "):");
                        qnt = sc.nextInt();
                        if (qnt > 0 && qnt + produtos[n - 1].getQnt() <= produtos[n - 1].getEstoque()) {
                            caretaker.saveState(produtos); // Salvar estado antes de modificar
                            produtos[n - 1].setQnt(produtos[n - 1].comprarProduto(qnt));
                        }
                    }
                }
            }
            if (fim > 0 && fim <= 3) {
                System.out.println("Digite 0 para remover ou digite a nova quantidade (qualquer valor negativo ou acima do estoque (" + produtos[fim - 1].getEstoque() + ") vai zerar a quantidade):");
                n = sc.nextInt();
                caretaker.saveState(produtos); // Salvar estado antes de modificar
                produtos[fim - 1].setQnt(produtos[fim - 1].alterarQnt(n));
            }
            if (fim == 9) { // Desfazer a última operação
                CarrinhoMemento memento = caretaker.restoreState();
                if (memento != null) {
                    originator.restore(memento);
                    produtos = originator.getProdutos();
                    System.out.println("Última operação desfeita.");
                } else {
                    System.out.println("Não há operações para desfazer.");
                }
            }
        }

        System.out.println("\n CARRINHO FINALIZADO!\n");
        for (int i = 0; i < 3; i++) {
            if (produtos[i].getQnt() > 0) {
                System.out.println(produtos[i].carrinhoDados());
            }
        }
    }
}
