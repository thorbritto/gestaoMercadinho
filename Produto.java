public class Produto {
    private final int id;
    private String nome;
    private String setor;
    private double precoCusto;
    private double precoVenda;
    private int quantidadeVendida; // Novo campo

    public Produto(int id, String nome, String setor, double precoCusto, double precoVenda) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidadeVendida = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void incrementarVendas(int quantidade) {
        this.quantidadeVendida += quantidade;
    }

    public double calcularLucro() {
        return precoVenda - precoCusto;
    }

    public double calcularLucroTotal() {
        return calcularLucro() * quantidadeVendida;
    }

    @Override
    public String toString() {
        return "{ID: " + id + ", Nome: " + nome + " , Setor: " + setor +
               " , Preço de Custo: R$" + precoCusto + " , Preço de Venda: R$" + precoVenda +
               " , Quantidade Vendida: " + quantidadeVendida + "}";
    }
}