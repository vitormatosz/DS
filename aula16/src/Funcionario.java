public abstract class Funcionario {
    private String nome;
    private String cpf;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }

    // Método abstrato: força as subclasses a implementarem sua própria lógica
    public abstract double vencimentos();

    @Override // Sobrescrevendo toString da classe Object
    public String toString() {
        return String.format("Nome: %s | CPF: %s", nome, cpf);
    }
}