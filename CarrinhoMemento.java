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
