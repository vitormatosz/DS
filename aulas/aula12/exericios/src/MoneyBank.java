public class MoneyBank {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        Conta c2 = new Conta();

        c1.titular = "Aluno Herói";
        c1.saldo = 1000.0;
        
        c2.titular = "MoneyBank Reserva";
        c2.saldo = 500.0;

        System.out.println("--- Bem-vindo ao MoneyBank ---");
        
        // Testando Depósito
        System.out.println("\n[Ação] Depositando R$ 250 na conta de " + c1.titular);
        c1.deposita(250.0);
        System.out.println("Novo saldo c1: R$" + c1.getSaldo());

        // Testando Saque
        System.out.println("\n[Ação] Tentando sacar R$ 2000 da conta de " + c1.titular);
        if (c1.saca(2000.0)) {
            System.out.println("Saque realizado! Saldo atual: R$" + c1.getSaldo());
        } else {
            System.out.println("Erro: Saldo insuficiente.");
        }

        // Testando Transferência
        System.out.println("\n[Ação] Transferindo R$ 300 de " + c1.titular + " para " + c2.titular);
        if (c1.transfere(c2, 300.0)) {
            System.out.println("Transferência concluída com sucesso!");
        } else {
            System.out.println("Falha na transferência.");
        }

        System.out.println("\nSaldo final de " + c1.titular + ": R$" + c1.getSaldo());
        System.out.println("Saldo final de " + c2.titular + ": R$" + c2.getSaldo());
    }
}