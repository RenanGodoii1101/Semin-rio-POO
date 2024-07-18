public class Originator {
    private Produto[] produtos;

    public Originator(Produto[] produtos) {
        this.produtos = produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public CarrinhoMemento save() {
        return new CarrinhoMemento(produtos);
    }

    public void restore(CarrinhoMemento memento) {
        produtos = memento.getProdutos();
    }
}
