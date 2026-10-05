public abstract class Material {

    private String nome;
    private String unidade;
    private double preco;

    public Material (String nome, String unidade, double preco){
        this.nome = nome;
        this.unidade = unidade;
        this.preco = preco;
    }

    public abstract double calcularQuantidade(Obra obra);

    public double calcularCusto(Obra obra){
        return calcularQuantidade(obra) * preco;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
