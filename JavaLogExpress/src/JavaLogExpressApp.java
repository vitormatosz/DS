import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. CONTRATO DO SISTEMA (Interface ou Classe Abstrata)
abstract class Veiculo {
    private String placa;
    private String modelo;
    protected double capacidadeCargaKg;

    public Veiculo(String placa, String modelo, double capacidadeCargaKg) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeCargaKg = capacityValida(capacidadeCargaKg);
    }

    private double capacityValida(double carga) {
        return carga > 0 ? carga : 100; // Validação simples de encapsulamento
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public double getCapacidadeCargaKg() { return capacidadeCargaKg; }

    // Método polimórfico que cada tipo de veículo calculará de sua forma
    public abstract double calcularCustoFrete(double distanciaKm);
    public abstract String getTipo();
}

// ====================================================================
// TODO: ALUNO DEVE IMPLEMENTAR AS SUBCLASSES (Caminhao e Van) AQUI

class Van extends Veiculo{
    
    public Van(String placa, String modelo, double capacidadeCargaKg){
        super(placa, modelo, capacidadeCargaKg);
    }

   

    @Override
    public double calcularCustoFrete(double distanciaKm){

        double frete = distanciaKm * 2.50;

        if(capacidadeCargaKg > 1000){
            frete += 30;
        }

        return frete;
    } 
    
    public String getTipo(){
        return "Van";
    }
}

class Caminhao extends Veiculo{

    private int eixos;
    
    public Caminhao(String placa, String modelo, double capacidadeCargaKg, int eixos){
        super(placa, modelo, capacidadeCargaKg);
        this.eixos = eixos;
    }

    public int getEixos(){
        return eixos;
    }

    public void setEixos(int eixos) {
        if (eixos > 0) {
            this.eixos = eixos;
        }
    }

    

    @Override
    public double calcularCustoFrete(double distanciaKm){

        double frete = distanciaKm * 4.50 * eixos;

        return frete;
    }
    
    public String getTipo(){
        return "Caminhao";
    }
}

// ====================================================================

// 2. CLASSE PRINCIPAL DO SISTEMA
public class JavaLogExpressApp {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Veiculo> frota = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- JAVALOG EXPRESS - SISTEMA DE FROTA ---");
            System.out.println("1. Cadastrar Van no Sistema");
            System.out.println("2. Cadastrar Caminhão no Sistema");
            System.out.println("3. Listar Veículos da Frota e Custos de Frete Simulados");
            System.out.println("0. Encerrar Sistema");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer do Enter

            switch (opcao) {
                case 1:
                    System.out.print("Digite a Placa da Van: ");
                    String pVan = leitor.nextLine();
                    System.out.print("Digite o Modelo: ");
                    String mVan = leitor.nextLine();
                    System.out.print("Capacidade de Carga (kg): ");
                    double cVan = leitor.nextDouble();
                    
                    // TODO: Instanciar a Van e adicionar na lista 'frota'

                    Van van = new Van(pVan, mVan, cVan);
                    frota.add(van);

                    System.out.println("Van cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite a Placa do Caminhão: ");
                    String pCam = leitor.nextLine();
                    System.out.print("Digite o Modelo: ");
                    String mCam = leitor.nextLine();
                    System.out.print("Capacidade de Carga (kg): ");
                    double cCam = leitor.nextDouble();
                    System.out.print("Número de Eixos do Caminhão: ");
                    int eixos = leitor.nextInt();
                    
                    // TODO: Instanciar o Caminhão e adicionar na lista 'frota'

                    Caminhao cam = new Caminhao(pCam, mCam, cCam, eixos);
                    frota.add(cam);

                    System.out.println("Caminhão cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("\n--- RELATÓRIO DA FROTA E SIMULAÇÃO DE FRETE (Para 100km) ---");
                    if (frota.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado na frota.");
                    } else {
                        // TODO: Percorrer a frota exibindo os dados e o cálculo do frete polimórfico
                       for (Veiculo v : frota) {
                        System.out.print("Veículo: "+ v.getTipo()+" | Placa: "+ v.getPlaca()+" | Modelo: "+ v.getModelo());

                        if (v.getTipo().equals("Caminhao")) {
                            Caminhao c = (Caminhao) v;
                            System.out.print(" | Eixos: "+c.getEixos());
                        }

                        System.out.println(" | Frete Simulado: R$ "+v.calcularCustoFrete(100.00));
                       } 

                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        leitor.close();
    }
}