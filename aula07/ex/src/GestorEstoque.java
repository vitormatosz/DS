import java.util.*;

public class GestorEstoque {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<String> estoque = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- GESTOR DE ESTOQUE ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Remover Produto");
            System.out.println("4. Buscar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    // TODO: Implementar Adição

                    System.out.println("\nDigite o nome do produto para cadastrar: ");
                    String nomeProd = leitor.nextLine();

                    if (estoque.contains(nomeProd)) {
                        System.out.println("Produto já Cadastrado!");
                    } else {
                        estoque.add(nomeProd);
                        System.out.println("Produto: "+nomeProd+" Cadastrado com Sucesso!");
                    }
                    break;
                case 2:
                    // TODO: Implementar Listagem

                    if (estoque.size() == 0) {
                        System.out.println("Estoque Vazio!");
                    } else {
                        Collections.sort(estoque);
                        
                        int i = 1;

                        for (String itens : estoque) {
                            System.out.println(i+". "+itens);
                            i++;
                        }
                    }
                    break;
                case 3:
                    // TODO: Implementar Remoção
                    System.out.println("\nDigite o nome do produto para remoção: ");
                    String nameProd = leitor.nextLine();

                    if (estoque.contains(nameProd) == false) {
                        System.out.println("Produto não encontrado!");
                    } else {
                        estoque.remove(nameProd);
                        System.out.println("Produto: "+nameProd+" removido com Sucesso!");
                    }

                    break;
                case 4:
                    // TODO: Implementar Busca
                    System.out.println("\nDigite o nome do produto para busca: ");
                    String nameProdu = leitor.nextLine();

                    if (estoque.contains(nameProdu)) {
                        System.out.println("Produto Encontrado! No indíce: "+estoque.indexOf(nameProdu));
                    } else {
                        System.out.println("Produto não encontrado no Estoque!");
                    }

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        leitor.close();
    }
}