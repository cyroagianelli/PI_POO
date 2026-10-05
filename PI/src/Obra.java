public class Obra {

    private double largura;
    private double comprimento;
    private double altura;

    public Obra (double largura, double comprimento, double altura){
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
    }

    public double calcularAreaPiso(){
        return largura * comprimento;
    }

    public double calcularPerimetro(){
        return 2 * (largura + comprimento);
    }

    public double calcularAreaParedes(){
        return calcularPerimetro() * altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getAltura(){
        return altura;
    }
}
