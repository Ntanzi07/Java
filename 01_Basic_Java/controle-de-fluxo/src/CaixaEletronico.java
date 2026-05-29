public class CaixaEletronico {
    public static void main(String[] args) {
        double saldo = 25.0;
        double valorSolicitado = 17.0;

        if(valorSolicitado < saldo){
            saldo -= valorSolicitado;
            System.out.println("Novo valor: " + saldo);
        } else if(valorSolicitado == saldo){
            saldo -= valorSolicitado;
            System.out.println("saldo está zerado: " + saldo);
        } else
            System.out.println("Dinheiro insuficiente...");

       
    }
}
