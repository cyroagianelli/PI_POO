public class Cimento  extends Material{

    public Cimento (String nome, double preco){
        super(nome, "saco", preco);
    }

    @Override
    public double calcularQuantidade(Obra obra) {
        return Math.ceil(obra.calcularAreaPiso() * 0.5);
    }
}
