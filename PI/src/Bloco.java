public class Bloco extends Material {

    public Bloco(String nome, double preco) {
        super(nome, "unidade", preco);
    }

    @Override
    public double calcularQuantidade(Obra obra) {
        return obra.calcularAreaParedes() * 12.5 * 1.05;
    }
}