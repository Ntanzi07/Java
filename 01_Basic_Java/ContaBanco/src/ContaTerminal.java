import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Conta Conta = new Conta();

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o numero da conta: ");
        Conta.numeroConta(Integer.parseInt(entrada.nextLine()));

        System.out.println("Digite a agencia: ");
        Conta.agencia(entrada.nextLine());

        System.out.println("Digite o seu nome: ");
        Conta.nomeCliente(entrada.nextLine());

        System.out.println("Digite o saldo: ");
        Conta.saldo(Double.parseDouble(entrada.nextLine()));

        System.out.println("Olá " + Conta.nomeCliente + ", obrigado por criar uma conta em nosso banco,"+
        " sua agência é " + Conta.agencia + ", conta " + Conta.numero + ", e seu saldo " + Conta.saldo + 
        " já está disponível para saque");

    }
}
