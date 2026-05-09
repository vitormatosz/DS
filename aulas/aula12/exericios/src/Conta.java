public class Conta {
    String titular;
    double saldo;

    void deposita(double valor) {
        saldo += valor;
    }

    boolean saca(double valor){
        if (this.saldo >= valor){
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    double getSaldo(){
        return saldo;
    }

    boolean transfere(Conta destino, double valor){

        if(this.saca(valor)){
            destino.deposita(valor);
            return true;
        }

        return false;
    }
}
