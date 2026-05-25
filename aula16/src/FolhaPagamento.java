public class FolhaPagamento {
    public static void main(String[] args) throws Exception {
        Funcionario[] funcionarios = new Funcionario[4];

        funcionarios[0] = new Comissionado("Douglas Silva",
        "555.444.333.22", 15000.00, 0.10);

        funcionarios[1] = new Assalariado("Victoria Martins",
        "444.555.333.22", 3000.00);

        funcionarios[2] = new Comissionado("Yago Oproprio",
        "666.555.444.22", 10000.00, 0.13);

        funcionarios[3] = new Assalariado("Julia Costa",
        "333.555.111.88", 4000.00);


        System.out.println("=====FOLHA DE PAGAMENTO=====");

        for (Funcionario f : funcionarios) {
            double venc = f.vencimentos();

            if (f instanceof Comissionado) {
                venc += 200;
                System.out.println("Bonus de 200 reais!");
            }

            System.out.println(f);
            System.out.printf("Vencimentos: R$ "+ venc +"\n");
            System.out.println("--------------------------------\n");
        }
    }


}
