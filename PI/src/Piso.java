public class Piso extends Material {

    public Piso(String nome, double preco) {
        super(nome, "m²", preco);
    }

    @Override
    public double calcularQuantidade(Obra obra) {
        return Math.ceil(obra.calcularAreaPiso() * 1.10);
    }
}