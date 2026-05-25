public class Assalariado extends Funcionario {
    private double salarioMensal;

    public Assalariado(String nome, String cpf, double salarioMensal){
        super(nome, cpf);
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double vencimentos(){
        return salarioMensal;
    }
}
