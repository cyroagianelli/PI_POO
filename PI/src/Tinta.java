public class Tinta extends Material{

    public Tinta(String nome, double preco){
        super(nome, "lata", preco);
    }

    @Override
    public double calcularQuantidade(Obra obra) {
        return Math.ceil(obra.calcularAreaParedes() * 1.1 /200);
    }
}
