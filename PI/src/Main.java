import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Material[] materiais = {
                new Piso("Piso", 35.00),
                new Argamassa("Argamassa", 32.00),
                new Bloco("Bloco", 2.50),
                new Cimento("Cimento", 32.00),
                new Tinta("Tinta", 280.00)
        };

        int opcao = 0;

        while (opcao != 3) {

            System.out.println("==========================================");
            System.out.println("                CONSTRURUN                ");
            System.out.println("       ESTIMADOR DE CUSTO DE OBRA         ");
            System.out.println("==========================================");

            System.out.println("1 - Nova estimativa");
            System.out.println("2 - Alterar preços dos materiais");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();

            switch (opcao) {

                case 1:
                    novaEstimativa(teclado, materiais);
                    break;

                case 2:
                    alterarPrecos(teclado, materiais);
                    break;

                case 3:
                    System.out.println("\nObrigado por utilizar o sistema!");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }
        }

        teclado.close();
    }

    private static void novaEstimativa(Scanner teclado, Material[] materiais) {

        System.out.println("==========================================");
        System.out.println("          DADOS DA OBRA");
        System.out.println("==========================================");

        System.out.print("Digite a largura da obra (m): ");
        double largura = teclado.nextDouble();

        System.out.print("Digite o comprimento da obra (m): ");
        double comprimento = teclado.nextDouble();

        System.out.print("Digite a altura das paredes (m): ");
        double altura = teclado.nextDouble();

        if (largura <= 0 || comprimento <= 0 || altura <= 0) {
            System.out.println("Erro: as medidas devem ser maiores que zero.");
            return;
        }

        Obra obra = new Obra(largura, comprimento, altura);

        Orcamento orcamento = new Orcamento(obra);

        for (Material material : materiais) {
            orcamento.adicionarMaterial(material);
        }

        System.out.println("==========================================");
        System.out.println("           DADOS CALCULADOS");
        System.out.println("==========================================");

        System.out.printf("Área do piso: %.2f m²%n", obra.calcularAreaPiso());
        System.out.printf("Perímetro: %.2f m%n", obra.calcularPerimetro());
        System.out.printf("Área das paredes: %.2f m²%n", obra.calcularAreaParedes());

        orcamento.exibirMateriais();

        double area = obra.calcularAreaPiso();

        System.out.println("\nClassificação da obra:");

        if (area <= 50) {
            System.out.println("Obra de pequeno porte.");
        } else if (area <= 150) {
            System.out.println("Obra de médio porte.");
        } else {
            System.out.println("Obra de grande porte.");
        }
    }

    private static void alterarPrecos(Scanner teclado, Material[] materiais) {

        int escolha = -1;

        while (escolha != 0) {

            System.out.println("==========================================");
            System.out.println("          PREÇOS DOS MATERIAIS");
            System.out.println("==========================================");

            for (int i = 0; i < materiais.length; i++) {
                System.out.printf("%d - %-12s R$ %.2f por %s%n",i + 1,materiais[i].getNome(),materiais[i].getPreco(),materiais[i].getUnidade());
            }

            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha o material para alterar o preço: ");

            escolha = teclado.nextInt();

            if (escolha >= 1 && escolha <= materiais.length) {

                Material material = materiais[escolha - 1];

                System.out.printf("Novo preço de %s (por %s): R$ ",material.getNome(), material.getUnidade());
                double novoPreco = teclado.nextDouble();

                if (novoPreco <= 0) {
                    System.out.println("Erro: o preço deve ser maior que zero.");
                } else {
                    material.setPreco(novoPreco);
                    System.out.printf("Preço de %s atualizado para R$ %.2f.%n",material.getNome(), novoPreco);
                }

            } else if (escolha != 0) {

                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }
}