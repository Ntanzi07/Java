public class Conta {
    int numero;
    String agencia, nomeCliente;
    Double saldo;

    public void numeroConta(int newValue){
        numero = newValue;
    }

    public void agencia(String newValue){
        agencia = newValue;
    }

    public void nomeCliente(String newValue){
        nomeCliente = newValue;
    }

    public void saldo(Double newValue){
        saldo = newValue;
    }

}
