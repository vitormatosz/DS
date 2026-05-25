public class Comissionado extends Funcionario {
    private double totalVendas;
    private double taxaComissao;

    public Comissionado(String nome, String cpf, double totalVendas, double taxaComissao){
        super(nome, cpf);
        this.totalVendas = totalVendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double vencimentos(){
        return (totalVendas * taxaComissao);
    }
}
