import java.util.ArrayList;

public class Orcamento {

    private Obra obra;
    private ArrayList<Material> materiais;

    public Orcamento(Obra obra) {
        this.obra = obra;
        this.materiais = new ArrayList<>();
    }

    public void adicionarMaterial(Material material) {
        materiais.add(material);
    }

    public double calcularTotal() {

        double total = 0;

        for (Material material : materiais) {
            total += material.calcularCusto(obra);
        }

        return total;
    }

    public void exibirMateriais() {

        System.out.println("==========================================");
        System.out.println("           ESTIMATIVA DE MATERIAIS");
        System.out.println("==========================================");

        for (Material material : materiais) {

            double quantidade = material.calcularQuantidade(obra);
            double custo = material.calcularCusto(obra);

            System.out.printf("%-15s: %.2f %s - R$ %.2f%n",material.getNome(),quantidade,material.getUnidade(),custo);
        }

        System.out.println("==========================================");
        System.out.printf("CUSTO TOTAL ESTIMADO: R$ %.2f%n",calcularTotal());
        System.out.println("==========================================");
    }

    public Obra getObra() {
        return obra;
    }
}