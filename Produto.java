public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private int qnt;
    private int codigo;

    public Produto(int codigo, String nome, double preco, int estoque, int qnt) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.qnt = qnt;
        this.codigo = codigo;
    }

    public int comprarProduto(int x) {
        x = x + qnt;
        return x;
    }

    public int alterarQnt(int n) {
        if (n > 0 && n <= estoque) {
            return n;
        } else {
            return 0;
        }
    }

    public String imprimeDados() {
        return codigo + ". " + "    Nome: " + nome + "    Preco: " + preco + " reais    Estoque: " + estoque + "\n";
    }

    public String carrinhoDados() {
        return "Codigo do Produto: " + codigo + "    Nome: " + nome + "    Preco: " + preco * qnt + " reais    Quantidade: " + qnt + "\n";
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
