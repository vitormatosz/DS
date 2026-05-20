// SUPERCLASSE (Classe Pai)
class Midia {
    protected String titulo;
    protected int anoLancamento;

    // Construtor da classe pai
    public Midia(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public void exibirFicha() {
        System.out.println("Título: " + titulo);
        System.out.println("Ano de Lançamento: " + anoLancamento);
    }
}
// ========================================================
// TODO: VOCÊ DEVE IMPLEMENTAR AS SUBCLASSES AQUI (VEJA O DESAFIO)
// ========================================================

class Filme extends Midia{
    private int duracaoEmMinutos;
    
    public Filme(String titulo, int anoLancamento, int duracaoEmMinutos){
        this.duracaoEmMinutos = duracaoEmMinutos;
        super(titulo, anoLancamento);
    }

    @Override
    public void exibirFicha(){
        super.exibirFicha();
        System.out.println("Duração: " + duracaoEmMinutos + " minutos");
    }
}
 class Serie extends Midia{
    private int totalTemporadas;
    
    public Serie(String titulo, int anoLancamento, int totalTemporadas){
        this.totalTemporadas = totalTemporadas;
        super(titulo, anoLancamento);
    }

    @Override
    public void exibirFicha(){
        super.exibirFicha();
        System.out.println("Total de Temporadas: " + totalTemporadas + " temporadas");
    }
}
// CLASSE PRINCIPAL (Não mexer aqui, serve para testar seu código)
public class JavaFlixApp {
    public static void main(String[] args) {
        System.out.println("--- Carregando Catálogo JavaFlix ---");

        // Instanciando um Filme (Título, Ano, Duração)
        Filme filme = new Filme("Inception", 2010, 148);
        
        // Instanciando uma Série (Título, Ano, Temporadas)
        Serie serie = new Serie("Stranger Things", 2016, 4);

        // Testando os métodos herdados e sobrescritos
        System.out.println("\n[Ficha do Filme]");
        filme.exibirFicha();

        System.out.println("\n[Ficha da Série]");
        serie.exibirFicha();
    }
}